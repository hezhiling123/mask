package cn.hezhiling.sys.feign;

import cn.hezhiling.sys.service.IDepartmentService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = /*"MALL-USER-SERVICE"*/"API-GATEWAY"/*,path = "/user"*/)
public interface IDepartmentServiceClient extends IDepartmentService {
}
