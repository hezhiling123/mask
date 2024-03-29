package cn.hezhiling.mask.service.manage;

import cn.hezhiling.mask.model.system.Shipping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Ray
 * @date 2018/3/21.
 */
@RequestMapping("/order/mall/service/manage/IShippingService")
public interface IShippingService {

    /**
     * 查询物流公司
     *
     * @return
     */
    @RequestMapping(value = "/queryAll")
    List<Shipping> queryAll();

}
