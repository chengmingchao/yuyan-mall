package com.yuyan.mall.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuyan.mall.admin.bo.MenuBO;
import com.yuyan.mall.admin.dao.MenuDao;
import com.yuyan.mall.admin.entity.MenuEntity;
import com.yuyan.mall.admin.service.MenuServer;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chengmingchao
 * @version 1.0
 * @date 2021/3/16 下午10:30
 */
@Service
public class MenuServerImpl extends ServiceImpl<MenuDao,MenuEntity> implements MenuServer {

    @Autowired
    private MenuDao menuDao;

    @Override
    public void addMenu(MenuBO menuBO) {
        MenuEntity menuEntity=new MenuEntity();
        BeanUtils.copyProperties(menuBO,menuEntity);
        menuDao.insert(menuEntity);
    }

    /**
     * 树形结构查找菜单
     * @return
     */
    @Override
    public List<MenuBO> queryMenusByTree() {
        List<MenuEntity> menuEntities = menuDao.selectList(null);
        if (!CollectionUtils.isEmpty(menuEntities)){
            List<MenuBO> menuBOS = menuEntities.stream().map(m -> {
                MenuBO menuBO = new MenuBO();
                BeanUtils.copyProperties(m, menuBO);
                return menuBO;
            }).collect(Collectors.toList());

            List<MenuBO> collect = menuBOS.stream().filter(m -> m.getParentId() == 0).map(m -> {
                m.setChildren(getChildrenMenus(m, menuBOS));
                return m;
            }).sorted((m1, m2) -> m1.getOrderNum() - m2.getOrderNum()).collect(Collectors.toList());
            return collect;
        }
        return null;
    }

    @Override
    public void deleteMenu(MenuBO menuBO) {
        menuDao.deleteById(menuBO.getId());
    }

    @Override
    public void editMenu(MenuBO menuBO) {
        MenuEntity menuEntity=new MenuEntity();
        BeanUtils.copyProperties(menuBO,menuEntity);
        menuDao.updateById(menuEntity);
    }

    /**
     * 递归查找子菜单
     * @param menuBO
     * @param menuBOS
     * @return
     */
    private List<MenuBO> getChildrenMenus(MenuBO menuBO, List<MenuBO> menuBOS) {
       return menuBOS.stream().filter(m->m.getParentId().equals(menuBO.getId())).map(m->{
            m.setChildren(getChildrenMenus(m,menuBOS));
            return m;
        }).sorted((m1, m2) -> m1.getOrderNum() - m2.getOrderNum()).collect(Collectors.toList());
    }
}
