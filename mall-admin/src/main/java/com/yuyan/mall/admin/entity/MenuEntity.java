package com.yuyan.mall.admin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author chengmingchao
 * @version 1.0
 * @date 2021/3/16 下午10:34
 */
@Data
@TableName("sys_menu")
public class MenuEntity {
    /**
     * 自增主键
     */
    @TableId
    private Long id;
    /**
     * 父菜单id，一级菜单为0
     */
    @TableField("parent_id")
    private Long parentId;
    /**
     * 菜单名称
     */
    @TableField("name")
    private String name;
    /**
     * 菜单url
     */
    @TableField("url")
    private String url;
    /**
     * 授权
     */
    @TableField("perms")
    private String perms;
    /**
     * 类型   0：目录   1：菜单   2：按钮
     */
    @TableField("type")
    private Integer type;
    /**
     * 菜单图标
     */
    @TableField("icon")
    private String icon;
    /**
     * 排序
     */
    @TableField("order_num")
    private Integer orderNum;
}
