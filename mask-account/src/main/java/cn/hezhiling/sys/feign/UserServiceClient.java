package cn.hezhiling.sys.feign;

import cn.hezhiling.sys.service.user.UserService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = /*"MALL-USER-SERVICE"*/"API-GATEWAY"/*,path = "/user"*/)
public interface UserServiceClient extends UserService {
}
