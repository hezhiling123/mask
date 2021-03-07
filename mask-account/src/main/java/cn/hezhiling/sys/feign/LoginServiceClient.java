package cn.hezhiling.sys.feign;

import cn.hezhiling.mask.service.auth.LoginService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = /*"MASK-USER-SERVICE"*/"API-GATEWAY"/*,path = "/user"*/)
public interface LoginServiceClient extends LoginService {
}
