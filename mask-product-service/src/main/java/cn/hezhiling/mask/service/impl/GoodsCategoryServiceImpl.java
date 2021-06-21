package cn.hezhiling.mask.service.impl;

import cn.hezhiling.mask.constant.SysParamCode;
import cn.hezhiling.mask.dao.GoodsCategoryMapper;
import cn.hezhiling.mask.dao.SpecGoodsPriceMapper;
import cn.hezhiling.mask.model.goods.GoodsCategory;
import cn.hezhiling.mask.model.goods.RecommendGoods;
import cn.hezhiling.mask.model.spec.SpecGoodsPrice;
import cn.hezhiling.mask.mongo.CategoryCountDao;
import cn.hezhiling.mask.mongo.GoodsCategoryDao;
import cn.hezhiling.mask.mongo.GoodsDao;
import cn.hezhiling.mask.mongo.HotCategoryDao;
import cn.hezhiling.mask.service.goods.GoodsCategoryService;
import cn.hezhiling.mask.model.vo.*;
import cn.hezhiling.sys.model.SysParam;
import cn.hezhiling.sys.service.SysParamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品目录管理
 *
 * @author Jack
 * @date 2018/2/5.
 */
@RestController
@RequestMapping("/product/mask/service/GoodsCategoryService")
public class GoodsCategoryServiceImpl implements GoodsCategoryService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    private GoodsCategoryMapper goodsCategoryMapper;
    @Resource
    private GoodsDao goodsDao;
    @Resource
    private GoodsCategoryDao goodsCategoryDao;
    @Resource
    private CategoryCountDao categoryCountDao;
    @Resource
    private HotCategoryDao hotCategoryDao;

    @Resource
    private SysParamService sysParamService;

    @Resource
    private SpecGoodsPriceMapper specGoodsPriceMapper;
    @Value("${goods.pic.domain}")
    private String goodsPicDomain;

    @Autowired
    private RedisTemplate redisTemplate;

    private static String topCategoryTree = "topCategoryTree";
    private static String appHomeCategoryTree = "appHomeCategoryTree";

    @PostConstruct
    public void cacheCategoryTree() {
        if (!redisTemplate.hasKey(topCategoryTree)) {
            new Thread(() -> {
                List<CategoryTree> categoryTrees = goodsCategoryMapper.selectCategoryTree3("0", "");
                redisTemplate.opsForValue().set(topCategoryTree, categoryTrees);
            }).start();
        }
    }

    @PostConstruct
    public void cacheAppHomeCategoryTree() {
        if (!redisTemplate.hasKey(appHomeCategoryTree)) {
            new Thread(() -> {
                List<CategoryTree> categoryTrees = goodsCategoryMapper.selectCategoryTree3("999", "");
                redisTemplate.opsForValue().set(appHomeCategoryTree, categoryTrees);
            }).start();
        }
    }

    /**
     * 查询商品目录树
     *
     * @param parentId
     * @param keywords
     * @return
     * @throws Exception
     * @author Jack
     * @date 2020/9/8
     * @version
     */
    @RequestMapping(value = "/selectCategoryTree", method = RequestMethod.POST)
    @Override
    public List<CategoryTree> selectCategoryTree(String parentId, String keywords) {
        return goodsCategoryMapper.selectCategoryTree(parentId, keywords);
    }

    /**
     * 查询3级目录树
     *
     * @param parentId
     * @param keywords
     * @return
     * @throws Exception
     * @author Jack
     * @date 2020/9/8
     * @version
     */
    @RequestMapping(value = "/selectCategoryTree3", method = RequestMethod.POST)
    @Override
    public List<CategoryTree> selectCategoryTree3(String parentId, String keywords) {
        if (redisTemplate.hasKey(topCategoryTree)) {
            log.info("----------从缓存获取商品分类数据---------");
            List<CategoryTree> categoryTrees = (List<CategoryTree>) redisTemplate.opsForValue().get(topCategoryTree);
            return categoryTrees;
        } else {
            log.info("----------从数据库获取商品分类数据---------");
            List<CategoryTree> categoryTrees = goodsCategoryMapper.selectCategoryTree3(parentId, keywords);
            redisTemplate.opsForValue().set(topCategoryTree, categoryTrees);
            return categoryTrees;
        }
    }

    /**
     * 查询3级目录树
     *
     * @param parentId
     * @param keywords
     * @return
     * @throws Exception
     * @author Jack
     * @date 2020/9/8
     * @version
     */
    @RequestMapping(value = "/selectAppHomeCategoryTree", method = RequestMethod.POST)
    @Override
    public List<CategoryTree> selectAppHomeCategoryTree(String parentId, String keywords) {
        if (redisTemplate.hasKey(appHomeCategoryTree)) {
            log.info("----------从缓存获取小程序首页商品分类数据---------");
            List<CategoryTree> categoryTrees = (List<CategoryTree>) redisTemplate.opsForValue().get(topCategoryTree);
            return categoryTrees;
        } else {
            log.info("----------从数据库获取小程序首页商品分类数据---------");
            List<CategoryTree> categoryTrees = goodsCategoryMapper.selectCategoryTree3("999", keywords);
            redisTemplate.opsForValue().set(appHomeCategoryTree, categoryTrees);
            return categoryTrees;
        }
    }

    /**
     * 根据父id查询目录
     *
     * @param parentId
     * @return
     * @throws Exception
     * @author Jack
     * @date 2020/9/8
     * @version
     */
    @RequestMapping(value = "/selectCategoryByParentId", method = RequestMethod.POST)
    @Override
    public List<CategoryTree> selectCategoryByParentId(Integer parentId) {
        return goodsCategoryMapper.selectCategoryByParentId(parentId, null);
    }

    /**
     * 查询主页的目录
     *
     * @param parentId
     * @return
     * @throws Exception
     * @author Jack
     * @date 2020/9/8
     * @version
     */
    @RequestMapping(value = "/selectCategory4Home", method = RequestMethod.POST)
    @Override
    public List<CategoryTree> selectCategory4Home(Integer parentId) {
        List<CategoryTree> list = goodsCategoryMapper.selectCategoryByParentId(parentId, 1);
        for (CategoryTree categoryTree : list) {
            List<CategoryTree> goods = new ArrayList<>();
            //查找所有的子类
            List<GoodsCategory> categories = goodsCategoryMapper.selectSubCategoryByParentId(categoryTree.getId());
            //根据子类来找商品
            outer:
            for (GoodsCategory category : categories) {
                List<GoodsVo> subGoodsList = goodsDao.findByCategory(category.getId());
                for (GoodsVo goodsVo : subGoodsList) {
                    //取默认的商品规格，因为查商品详情是按规格ID来查的
                    List<SpecGoodsPrice> specGoodsPriceList = goodsVo.getSpecGoodsPriceList();
                    if (specGoodsPriceList != null && specGoodsPriceList.size() > 0) {
                        goodsVo.setDefaultSpecId(specGoodsPriceList.get(0).getId());
                        goods.add(this.map2Obj(goodsVo));
                        //一个分类最多显示24个商品
                        if (goods.size() > 23) {
                            break outer;
                        }
                    }
                }
            }
            categoryTree.setNodes(goods);
        }
        return list;
    }

    private CategoryTree map2Obj(GoodsVo goodsVo) {
        CategoryTree categoryTree = new CategoryTree();
        String goodsName = goodsVo.getBase().getGoodsName();
        categoryTree.setName(goodsName);
        categoryTree.setImage(goodsVo.getBase().getOriginalImg());
        categoryTree.setId(goodsVo.getDefaultSpecId());
        return categoryTree;
    }

    /**
     * 查询主页目录树并加入mongodb
     *
     * @return
     * @throws Exception
     * @author Jack
     * @date 2020/9/8
     * @version
     */
    @RequestMapping(value = "/produceCategory4Home")
    @Override
    public void produceCategory4Home() {
        List<CategoryTree> list = this.selectCategory4Home(0);
        Query query = new Query();
        goodsCategoryDao.remove(query);
        goodsCategoryDao.insert(list);
    }

    /**
     * 从mongodb中查询主页目录
     *
     * @return
     * @throws Exception
     * @author Jack
     * @date 2020/9/8
     * @version
     */
    @RequestMapping(value = "/getCategory4HomeFromMg")
    @Override
    public List<CategoryTree> getCategory4HomeFromMg() {
        List<CategoryTree> categoryTrees = goodsCategoryDao.findAll(null, CategoryTree.class);
        return categoryTrees;
    }

    /**
     * 自动计算每个分类下的商品数据，存入mongodb
     *
     * @return
     * @throws Exception
     * @author Jack
     * @date 2020/9/8
     * @version
     */
    @RequestMapping(value = "/produceCategoryGoodsCount")
    @Override
    public void produceCategoryGoodsCount() {
        List<GoodsCategory> categories = goodsCategoryMapper.selectAll();

        List<CategoryCountVo> list = new ArrayList<>();
        for (GoodsCategory goodsCategory : categories) {
            //查找所有的子类
            List<GoodsCategory> subCategories = goodsCategoryMapper.selectSubCategoryByParentId(goodsCategory.getId());
            int subGoodsCount = 0;
            for (GoodsCategory subCategory : subCategories) {
                subGoodsCount += goodsDao.countByCategory(subCategory.getId());
            }
            if (subGoodsCount > 0) {
                CategoryCountVo vo = new CategoryCountVo();
                vo.setCatId(goodsCategory.getId());
                vo.setName(goodsCategory.getName());
                vo.setCount(subGoodsCount);
                list.add(vo);
            }
        }
        categoryCountDao.remove(new Query());
        categoryCountDao.insert(list);
    }

    /**
     * 查询热门2级分类
     *
     * @return
     * @throws Exception
     * @author Jack
     * @date 2020/9/8
     * @version
     */
    @RequestMapping(value = "/produceHotCategories")
    @Override
    public void produceHotCategories() {
        GoodsCategory param = new GoodsCategory();
        param.setLevel((short) 2);
        param.setIsHot(true);
        param.setIsShow(true);
        List<GoodsCategory> categories = goodsCategoryMapper.selectList(param);
        hotCategoryDao.remove(new Query());
        hotCategoryDao.insert(categories);
    }

    /**
     * 搜索框自动提示
     *
     * @param keyword
     * @return
     * @throws Exception
     * @author Jack
     * @date 2020/9/8
     * @version
     */
    @RequestMapping(value = "/searchList", method = RequestMethod.POST)
    @Override
    public List<CategoryCountVo> searchList(String keyword) {
        List<CategoryCountVo> list = new ArrayList<>();
        if (StringUtils.isEmpty(keyword)) {
            SysParam sysParam = sysParamService.selectByCode(SysParamCode.HOME_SEARCH_KEYWORDS);
            if (sysParam != null) {
                String[] keywords = sysParam.getValue().split(",");
                for (String searchKey : keywords) {
                    List<CategoryCountVo> categories = categoryCountDao.find(new Query(Criteria.where("name").regex(searchKey)), CategoryCountVo.class);
                    list.addAll(categories);
                }
            }
        } else {
            list = categoryCountDao.find(new Query(Criteria.where("name").regex(keyword)).limit(10), CategoryCountVo.class);
            if (list == null) {
                list = new ArrayList<>();
            }
            //如果根据分类只找到9个以下，那就根据商品名称来搜索
            if (list.size() < 10) {
                int goodsCount = goodsDao.countByName(keyword);
                if (goodsCount > 0) {
                    CategoryCountVo vo = new CategoryCountVo();
                    vo.setName(keyword);
                    vo.setCount(goodsCount);
                    list.add(vo);
                }
            }
        }
        //list去重
        List<CategoryCountVo> newList = new ArrayList<>();
        list.forEach(categoryCountVo -> {
            if (!newList.contains(categoryCountVo)) {
                newList.add(categoryCountVo);
            }
        });
        return newList;
    }

    /**
     * 从mongodb查询分类信息
     *
     * @return
     * @throws Exception
     * @author Jack
     * @date 2020/9/8
     * @version
     */
    @RequestMapping(value = "/getClassification")
    @Override
    public List<GoodsCategory> getClassification() {
        return hotCategoryDao.find(new Query(), GoodsCategory.class);
    }

    /**
     * 查询热门商品
     *
     * @return
     * @throws Exception
     * @author Jack
     * @date 2020/9/8
     * @version
     */
    @RequestMapping(value = "/getHotGoods")
    @Override
    public List<HotGoodsVo> getHotGoods() {
        //查询推荐二级分类TOP5
        List<HotGoodsVo> hotCats = hotCategoryDao.find(new Query().with(Sort.by("sortOrder")).limit(5), HotGoodsVo.class);
        for (HotGoodsVo vo : hotCats) {
            //找商品: 属于该分类或其子分类，并且是推荐的商品
            List<GoodsPageVo> list = goodsDao.findList(new Query(new Criteria()
                    .and("base.isOnSale").is(true)
                    .and("base.isRecommend").is(true)
                    .and("base.catId").in(this.getSubCats(vo.getId())))
                    .limit(10), GoodsPageVo.class);
            vo.setList(list);
        }
        return hotCats;
    }

    /**
     * 获取子分类(包括自己)
     *
     * @param catId
     * @return
     * @throws Exception
     * @author Jack
     * @date 2020/9/8
     * @version
     */
    @RequestMapping(value = "/getSubCats", method = RequestMethod.POST)
    @Override
    public List<Integer> getSubCats(int catId) {
        List<Integer> allCatIds = new ArrayList<>();
        allCatIds.add(catId);

        //找到分类的子分类
        List<GoodsCategory> subCats = goodsCategoryMapper.selectSubCategoryByParentId(catId);
        if (subCats != null && subCats.size() > 0) {
            for (GoodsCategory subCat : subCats) {
                allCatIds.add(subCat.getId());
            }
        }
        return allCatIds;
    }

    /**
     * 获取子分类(包括自己)
     *
     * @param catName
     * @return
     * @throws Exception
     * @author Jack
     * @date 2020/9/8
     * @version
     */
    @RequestMapping(value = "/getSubCats1", method = RequestMethod.POST)
    @Override
    public List<Integer> getSubCats(String catName) {
        List<Integer> allCatIds = new ArrayList<>();
        List<Integer> catIds = goodsCategoryMapper.selectIdByName(catName);
        if (catIds != null && catIds.size() > 0) {
            allCatIds.addAll(catIds);

            for (Integer catId : catIds) {
                //找到分类的子分类
                List<GoodsCategory> subCats = goodsCategoryMapper.selectSubCategoryByParentId(catId);
                if (subCats != null && subCats.size() > 0) {
                    for (GoodsCategory subCat : subCats) {
                        allCatIds.add(subCat.getId());
                    }
                }
            }
        }
        return allCatIds;
    }

    /**
     * 获取推荐商品列表
     *
     * @return list of {@link GoodsCategory}
     */
    @RequestMapping(value = "/listRecommendGoods", method = RequestMethod.POST)
    @Override
    public List<RecommendGoods> listRecommendGoods() {
        List<RecommendGoods> recommendGoods = goodsCategoryMapper.listRecommendGoods();
        return recommendGoods;
    }

    /**
     * 获取小程序首页推荐商品列表
     *
     * @return list of {@link HotGoodsVo}
     */
    @Override
    public List<HotGoodsVo> listAppHomeGoods() {
        List<GoodsCategory> goodsCategory = goodsCategoryMapper.listAppHomeGoodsParentId();
//        List<CategoryTree> appHomeGoodsTree = goodsCategoryMapper.selectList()
        return null;
    }
}
