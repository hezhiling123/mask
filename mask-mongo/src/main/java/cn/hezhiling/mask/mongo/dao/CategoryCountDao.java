package cn.hezhiling.mask.mongo.dao;

import cn.hezhiling.mask.constant.CollectionConstants;
import org.springframework.stereotype.Repository;

/**
 * @author Ray
 * @date 2018/2/8.
 */
@Repository
public class CategoryCountDao extends BaseMgDao {
    @Override
    String getCollectionName() {
        return CollectionConstants.CATEGORY_COUNT;
    }
}
