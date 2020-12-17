package com.scaffolding.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scaffolding.demo.dao.SysRoleMapper;
import com.scaffolding.demo.entity.SysRole;
import com.scaffolding.demo.service.SysRoleService;
import org.springframework.stereotype.Service;

/**
 * @author lijiannan
 * @version 1.0
 * @date 2020/12/17 17:27
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
}
