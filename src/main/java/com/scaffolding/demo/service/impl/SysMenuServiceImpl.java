package com.scaffolding.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scaffolding.demo.dto.RoleAddDto;
import com.scaffolding.demo.entity.SysRole;
import com.scaffolding.demo.mapper.SysMenuMapper;
import com.scaffolding.demo.entity.SysMenu;
import com.scaffolding.demo.mapper.SysRoleMapper;
import com.scaffolding.demo.service.SysMenuService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/12/17 17:44
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Resource
    private SysMenuMapper sysMenuMapper;

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public List<SysMenu> getMenusByRoleIds(List<Integer> roleIds) {


        return sysMenuMapper.getMenusByRoleIds(roleIds);
    }

    @Override
    public List<SysMenu> getMenus(List<Integer> roleIds) {

        List<SysMenu> menus = null;
        if (CollectionUtils.isEmpty(roleIds)) {
            QueryWrapper queryWrapper = new QueryWrapper();
//            queryWrapper.eq("", );
            menus = sysMenuMapper.selectList(queryWrapper);
        } else {
            menus = sysMenuMapper.getMenusByRoleIds(Arrays.asList(1));
        }

        //分组
        Map<Long, List<SysMenu>> collect = menus.stream().collect(Collectors.groupingBy(SysMenu::getParentId));
        //树形结构 肯定有一个根部，我的这个根部的就是parentId.euqal("0"),而且只有一个就get（"0"）
        List<SysMenu> sysMenus = collect.get(0L);

        for (SysMenu sysMenu : sysMenus) {
            sysMenu.setChild(collect.get(sysMenu.getId()));
        }

        return sysMenus;
    }


}
