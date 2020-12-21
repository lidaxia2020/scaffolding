package com.scaffolding.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.scaffolding.demo.entity.SysMenu;

import java.util.List;

/**
 * @author lijiannan
 * @version 1.0
 * @date 2020/12/17 17:43
 */
public interface SysMenuService extends IService<SysMenu> {

    List<SysMenu> getMenusByRoleIds(List<Integer> roleIds);
}
