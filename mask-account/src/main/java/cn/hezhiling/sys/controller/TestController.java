package cn.hezhiling.sys.controller;

import cn.hezhiling.sys.service.IDictDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Ray
 * @date 2018/2/3.
 */
@RestController
public class TestController {

    @Autowired
    private IDictDataService dictDataService;

    @GetMapping("test")
    public Object test(String type){
        return dictDataService.findDictByType(type);
    }
}
