package com.scaffolding.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.scaffolding.demo.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/12/12 16:22
 */
public interface SysRoleMenuMapper extends BaseMapper<SysRole> {

    void insertBatch(@Param("roleId") Integer roleId, @Param("list")List<Integer> menuss);
}
