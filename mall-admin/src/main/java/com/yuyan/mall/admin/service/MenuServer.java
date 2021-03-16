package com.yuyan.mall.admin.service;

import com.yuyan.mall.admin.bo.MenuBO;

import java.util.List;

/**
 * @author chengmingchao
 * @version 1.0
 * @date 2021/3/16 下午10:29
 */
public interface MenuServer {

    void addMenu(MenuBO menuBO);

    List<MenuBO> queryMenusByTree();

    void deleteMenu(MenuBO menuBO);

    void editMenu(MenuBO menuBO);
}
