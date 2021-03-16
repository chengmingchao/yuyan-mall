package com.yuyan.mall.admin.request;

import lombok.Data;

/**
 * @author chengmingchao
 * @version 1.0
 * @date 2021/3/16 下午10:43
 */
@Data
public class MenuReq {

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
}
