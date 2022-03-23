package cn.hezhiling.mask.service.wx;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Map;

@RequestMapping("/pay/wxPay")
public interface WxPayService {

    @RequestMapping(value = "/unifiedorder", method = RequestMethod.POST)
    Map<String, String> unifiedorder(@RequestParam("actionId") String actionId, @RequestParam("payAmount") BigDecimal payAmount,
                                     @RequestParam("userId") String userId, @RequestParam("orderType") String orderType);
}
