package com.yuyan.mall.admin.vo;

import com.yuyan.mall.admin.bo.MenuBO;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chengmingchao
 * @version 1.0
 * @date 2021/3/16 下午11:09
 */
@Data
public class MenuVO {
    private Long id;
    /**
     * 父菜单id，一级菜单为0
     */
    private Long parentId;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 菜单url
     */
    private String url;
    /**
     * 授权
     */
    private String perms;
    /**
     * 类型   0：目录   1：菜单   2：按钮
     */
    private Integer type;
    /**
     * 菜单图标
     */
    private String icon;
    /**
     * 排序
     */
    private Integer orderNum;
    /**
     * 子菜单
     */
    private List<MenuBO> children;

    public static List<MenuVO> convert(List<MenuBO> menuBOS){
        if (!CollectionUtils.isEmpty(menuBOS)){
           return menuBOS.stream().map(m->{
                MenuVO menuVO=new MenuVO();
                BeanUtils.copyProperties(m,menuVO);
                return menuVO;
            }).collect(Collectors.toList());
        }
        return null;
    }
}
