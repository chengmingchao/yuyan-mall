package com.yuyan.mall.admin.controller;

import com.yuyan.mall.admin.bo.MenuBO;
import com.yuyan.mall.admin.request.MenuReq;
import com.yuyan.mall.admin.service.MenuServer;
import com.yuyan.mall.admin.vo.MenuVO;
import com.yuyan.mall.result.MallResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author chengmingchao
 * @version 1.0
 * @date 2021/3/16 下午10:22
 */
@Api("菜单接口")
@RestController
@RequestMapping("/admin")
public class MenuController {
    @Autowired
    private MenuServer menuServer;

    @ApiOperation("树形结构查询菜单")
    @GetMapping("/queryMenusByTree")
    public MallResult queryMenusByTree(){
        List<MenuBO> list=menuServer.queryMenusByTree();
        return MallResult.ok(MenuVO.convert(list));
    }

    @ApiOperation("添加菜单")
    @PostMapping("/addMenu")
    public MallResult addMenu(@RequestBody MenuReq menuReq){
        MenuBO menuBO=new MenuBO();
        BeanUtils.copyProperties(menuReq,menuBO);
        menuServer.addMenu(menuBO);
        return MallResult.ok();
    }

    @ApiOperation("修改菜单")
    @PostMapping("/editMenu")
    public MallResult editMenu(@RequestBody MenuReq menuReq){
        MenuBO menuBO=new MenuBO();
        BeanUtils.copyProperties(menuReq,menuBO);
        menuServer.editMenu(menuBO);
        return MallResult.ok();
    }


    @ApiOperation("删除菜单")
    @PostMapping("deleteMenu")
    public MallResult deleteMenu(@RequestBody MenuReq menuReq){
        MenuBO menuBO=new MenuBO();
        BeanUtils.copyProperties(menuReq,menuBO);
        menuServer.deleteMenu(menuBO);
        return MallResult.ok();
    }
}
