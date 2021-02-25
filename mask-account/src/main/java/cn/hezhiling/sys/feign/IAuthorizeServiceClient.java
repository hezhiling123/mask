package cn.hezhiling.sys.feign;

import cn.hezhiling.sys.service.IAuthorizeService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = /*"MALL-USER-SERVICE"*/"API-GATEWAY"/*,path = "/user"*/)
public interface IAuthorizeServiceClient extends IAuthorizeService {
}
