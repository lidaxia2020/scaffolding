package com.scaffolding.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scaffolding.demo.dto.RoleAddDto;
import com.scaffolding.demo.mapper.SysRoleMapper;
import com.scaffolding.demo.entity.SysRole;
import com.scaffolding.demo.mapper.SysRoleMenuMapper;
import com.scaffolding.demo.service.SysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/12/17 17:27
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public void roleAdd(RoleAddDto roleAddDto) {


        SysRole sysRole = new SysRole();
        sysRole.setRoleName(roleAddDto.getName());
        sysRole.setRemark(roleAddDto.getRemark());
        int save = sysRoleMapper.save(sysRole);

        sysRoleMenuMapper.insertBatch(save, roleAddDto.getMenuList());

    }

}
