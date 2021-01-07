package com.scaffolding.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.scaffolding.demo.dto.RoleAddDto;
import com.scaffolding.demo.entity.SysRole;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/12/17 17:26
 */
public interface SysRoleService  extends IService<SysRole> {


    void roleAdd(RoleAddDto roleAddDto);

}
