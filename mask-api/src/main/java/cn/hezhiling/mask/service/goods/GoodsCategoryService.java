package cn.hezhiling.mask.service.goods;

import cn.hezhiling.mask.model.goods.GoodsCategory;
import cn.hezhiling.mask.model.goods.RecommendGoods;
import cn.hezhiling.mask.vo.CategoryCountVo;
import cn.hezhiling.mask.vo.CategoryTree;
import cn.hezhiling.mask.vo.HotGoodsVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Ray
 * @date 2018/2/5.
 */
@RequestMapping("/product/mask/service/GoodsCategoryService")
public interface GoodsCategoryService {
    @RequestMapping(value = "/selectCategoryTree", method = RequestMethod.POST)
    List<CategoryTree> selectCategoryTree(@RequestParam("parentId") String parentId, @RequestParam("keywords") String keywords);
    //三层分类树
    @RequestMapping(value = "/selectCategoryTree3", method = RequestMethod.POST)
    List<CategoryTree> selectCategoryTree3(@RequestParam(value = "parentId",required = false) String parentId, @RequestParam(value = "keywords",required = false) String keywords);

    @RequestMapping(value = "/selectCategoryByParentId", method = RequestMethod.POST)
    List<CategoryTree> selectCategoryByParentId(@RequestParam("parentId") Integer parentId);

    @RequestMapping(value = "/selectCategory4Home", method = RequestMethod.POST)
    List<CategoryTree> selectCategory4Home(@RequestParam("parentId") Integer parentId);

    @RequestMapping(value = "/produceCategory4Home")
    void produceCategory4Home();

    @RequestMapping(value = "/getCategory4HomeFromMg")
    List<CategoryTree> getCategory4HomeFromMg();

    /**
     * 自动计算每个分类下的商品数据，存入mongodb
     * @author Ray
     */
    @RequestMapping(value = "/produceCategoryGoodsCount")
    void produceCategoryGoodsCount();

    /**
     * 生成商品查询页的分类数据
     */
    @RequestMapping(value = "/produceHotCategories")
    void produceHotCategories();

    /**
     * 搜索框自动提示
     * @param keyword 搜索框的输入
     * @return
     * @author Ray
     */
    @RequestMapping(value = "/searchList", method = RequestMethod.POST)
    List<CategoryCountVo> searchList(@RequestParam("keyword") String keyword);

    @RequestMapping(value = "/getClassification")
    List<GoodsCategory> getClassification();

    /**
     * 获取5个分类，再每个分类查最多10个商品
     * @return
     */
    @RequestMapping(value = "/getHotGoods")
    List<HotGoodsVo> getHotGoods();

    @RequestMapping(value = "/getSubCats", method = RequestMethod.POST)
    List<Integer> getSubCats(@RequestParam("catId") int catId);

    @RequestMapping(value = "/getSubCats1", method = RequestMethod.POST)
    List<Integer> getSubCats(@RequestParam("catName") String catName);

    /**
     * 获取推荐商品列表
     *
     * @return  list of {@link GoodsCategory}
     */
    @RequestMapping(value = "/listRecommendGoods", method = RequestMethod.POST)
    List<RecommendGoods> listRecommendGoods();
}
