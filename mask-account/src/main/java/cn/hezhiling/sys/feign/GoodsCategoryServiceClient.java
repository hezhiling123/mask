package cn.hezhiling.sys.feign;

import cn.hezhiling.mask.service.goods.GoodsCategoryService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "/API-GATEWAY", path = "/product")
public interface GoodsCategoryServiceClient extends GoodsCategoryService {
}
