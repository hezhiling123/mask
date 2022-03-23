package cn.hezhiling.sys.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Ray
 * @date 2018/2/3.
 */
@RestController
public class TestController {

    @GetMapping("test")
    public Object test(String type) {
        return "test";
    }
}
