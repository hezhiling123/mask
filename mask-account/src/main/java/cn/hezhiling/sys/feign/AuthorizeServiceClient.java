package cn.hezhiling.sys.feign;

import cn.hezhiling.mask.service.system.AuthorizeService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = /*"MALL-USER-SERVICE"*/"API-GATEWAY"/*,path = "/user"*/)
public interface AuthorizeServiceClient extends AuthorizeService {
}
