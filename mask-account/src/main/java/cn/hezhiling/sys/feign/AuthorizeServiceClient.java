package cn.hezhiling.sys.feign;

import cn.hezhiling.sys.service.auth.AuthorizeService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "MASK-USER-SERVICE",path = "/user")
public interface AuthorizeServiceClient extends AuthorizeService {
}
