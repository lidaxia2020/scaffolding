package com.scaffolding.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.scaffolding.demo.entity.SysMenu;

import java.util.List;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/12/12 16:20
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    List<SysMenu> getMenusByRoleIds(List<Integer> roleIds);
}
