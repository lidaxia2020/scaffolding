package com.scaffolding.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scaffolding.demo.dao.SysMenuMapper;
import com.scaffolding.demo.entity.SysMenu;
import com.scaffolding.demo.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lijiannan
 * @version 1.0
 * @date 2020/12/17 17:44
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<SysMenu> getMenusByRoleIds(List<Integer> roleIds) {


        return sysMenuMapper.getMenusByRoleIds(roleIds);
    }
}
