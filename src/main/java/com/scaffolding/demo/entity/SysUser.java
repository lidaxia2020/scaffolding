package com.scaffolding.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/12/12 16:18
 */
@Data
@TableName("sys_user")
public class SysUser {

    /**
     * 主键
     * 用户ID
     * isNullAble:0
     */
    private Long id;

    /**
     * 部门ID
     * isNullAble:1
     */
    private Long deptId;

    /**
     * 用户账号
     * isNullAble:0
     */
    private String userName;

    /**
     * 用户昵称
     * isNullAble:0
     */
    private String nickName;

    /**
     * 用户类型（00系统用户）
     * isNullAble:1,defaultVal:00
     */
    private String userType;

    /**
     * 用户邮箱
     * isNullAble:1,defaultVal:
     */
    private String email;

    /**
     * 手机号码
     * isNullAble:1,defaultVal:
     */
    private String phone;

    /**
     * 用户性别（0男 1女 2未知）
     * isNullAble:1,defaultVal:0
     */
    private String sex;

    /**
     * 头像地址
     * isNullAble:1,defaultVal:
     */
    private String avatar;

    /**
     * 密码
     * isNullAble:1,defaultVal:
     */
    private String password;

    /**
     * 帐号状态（0正常 1停用）
     * isNullAble:1,defaultVal:0
     */
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）
     * isNullAble:1,defaultVal:0
     */
    private String delFlag;

    /**
     * 最后登陆IP
     * isNullAble:1,defaultVal:
     */
    private String loginIp;

    /**
     * 最后登陆时间
     * isNullAble:1
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private LocalDateTime loginDate;

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
    private LocalDateTime updateTime;

    /**
     * 备注
     * isNullAble:1
     */
    private String remark;

    /** 角色集合 */
    @TableField(exist = false)
    private List<String> roles;

}
