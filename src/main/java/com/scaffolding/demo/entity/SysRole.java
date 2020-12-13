package com.scaffolding.demo.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/12/12 16:16
 */
@Data
public class SysRole {

    /**
     * 主键
     * 角色ID
     * isNullAble:0
     */
    private Long roleId;

    /**
     * 角色名称
     * isNullAble:0
     */
    private String roleName;

    /**
     * 角色权限字符串
     * isNullAble:0
     */
    private String roleKey;

    /**
     * 显示顺序
     * isNullAble:0
     */
    private Integer roleSort;

    /**
     * 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
     * isNullAble:1,defaultVal:1
     */
    private String dataScope;

    /**
     * 角色状态（0正常 1停用）
     * isNullAble:0
     */
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）
     * isNullAble:1,defaultVal:0
     */
    private String delFlag;

    /**
     * 创建者
     * isNullAble:1,defaultVal:
     */
    private String createBy;

    /**
     * 创建时间
     * isNullAble:1
     */
    private LocalDateTime createTime;

    /**
     * 更新者
     * isNullAble:1,defaultVal:
     */
    private String updateBy;

    /**
     * 更新时间
     * isNullAble:1
     */
    private java.time.LocalDateTime updateTime;

    /**
     * 备注
     * isNullAble:1
     */
    private String remark;

}