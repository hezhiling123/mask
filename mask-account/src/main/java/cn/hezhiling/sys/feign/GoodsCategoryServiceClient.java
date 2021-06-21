package cn.hezhiling.sys.feign;

import cn.hezhiling.mask.service.goods.GoodsCategoryService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "MASK-PRODUCT-SERVICE", path = "/product")
public interface GoodsCategoryServiceClient extends GoodsCategoryService {
}
