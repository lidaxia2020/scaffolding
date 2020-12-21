package com.scaffolding.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/12/12 16:15
 */
@Data
@TableName("sys_menu")
public class SysMenu {

    /**
     * 主键
     * 菜单ID
     * isNullAble:0
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Long menuId;

    /**
     * 菜单名称
     * isNullAble:0
     */
    private String menuName;

    /**
     * 父菜单ID
     * isNullAble:1,defaultVal:0
     */
    private Long parentId;

    /**
     * 显示顺序
     * isNullAble:1,defaultVal:0
     */
    private Integer orderNum;

    /**
     * 路由地址
     * isNullAble:1,defaultVal:
     */
    private String path;

    /**
     * 组件路径
     * isNullAble:1
     */
    private String component;

    /**
     * 是否为外链（0是 1否）
     * isNullAble:1,defaultVal:1
     */
    private Integer isFrame;

    /**
     * 菜单类型（M目录 C菜单 F按钮）
     * isNullAble:1,defaultVal:
     */
    private String menuType;

    /**
     * 菜单状态（0显示 1隐藏）
     * isNullAble:1,defaultVal:0
     */
    private String visible;

    /**
     * 菜单图标
     * isNullAble:1,defaultVal:#
     */
    private String icon;

    /**
     * 创建者
     * isNullAble:1,defaultVal:
     */
    private String createBy;

    /**
     * 创建时间
     * isNullAble:1
     */
    private java.time.LocalDateTime createTime;

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
     * isNullAble:1,defaultVal:
     */
    private String remark;

}
