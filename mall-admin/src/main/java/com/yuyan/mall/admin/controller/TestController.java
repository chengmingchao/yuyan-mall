package com.yuyan.mall.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Date 2021/3/15 21:08
 * @Created by chengmingchao
 */
@RestController
@Api("tes")
public class TestController {

    @ApiOperation("测试接口")
    @RequestMapping("test")
    public String test(){
        return "test";
    }
}
