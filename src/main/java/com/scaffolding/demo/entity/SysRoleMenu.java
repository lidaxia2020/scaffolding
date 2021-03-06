package com.scaffolding.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/12/12 16:17
 */
@Data
@TableName("sys_role_menu")
public class SysRoleMenu {


    /**
     * 主键
     * 角色ID
     * isNullAble:0
     */
    private Long roleId;

    /**
     * 主键
     * 菜单ID
     * isNullAble:0
     */
    private Long menuId;


}
