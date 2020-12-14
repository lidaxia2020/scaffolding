package com.scaffolding.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/12/12 16:19
 */
@Data
@TableName("sys_user_role")
public class SysUserRole {

    /**
     * 主键
     * 用户ID
     * isNullAble:0
     */
    private Long userId;

    /**
     * 主键
     * 角色ID
     * isNullAble:0
     */
    private Long roleId;

}
