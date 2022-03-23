package cn.hezhiling.mask.mongo.dao;

import cn.hezhiling.mask.constant.CollectionConstants;
import cn.hezhiling.mask.vo.UserShoppingGoodsVo;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ShoppingCartDao extends BaseMgDao {

    @Override
    String getCollectionName() {
        return CollectionConstants.USER_SHOPPINGART;
    }

    public void removeByUserId(String userId) {
        remove(new Query(Criteria.where("userId").is(userId)));
    }

    public UserShoppingGoodsVo findOne(String userId) {
        return mongoTemplate.findOne(new Query(Criteria.where("userId").is(userId)), UserShoppingGoodsVo.class, getCollectionName());
    }
}
