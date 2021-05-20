package cn.hezhiling.mask.model.vo;

import cn.hezhiling.mask.SysPropUtil;
import cn.hezhiling.mask.model.goods.Goods;

/**
 * 为返回给前台的数据而特定的
 * @author Ray
 * @date 2018/3/1.
 */
public class GoodsBaseVo extends Goods {

    private static final long serialVersionUID = 2564140876215486769L;

    @Override
    public String getOriginalImg() {
        if (super.getOriginalImg() != null) {
            if (super.getOriginalImg().startsWith("http")) {
                return super.getOriginalImg();
            } else {
                return SysPropUtil.getPicDomain(super.getOriginalImg());
            }
        }
        return null;
    }
}
