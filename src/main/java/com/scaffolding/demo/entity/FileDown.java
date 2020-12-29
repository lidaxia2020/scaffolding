package com.scaffolding.demo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class FileDown {

    /**
     * 菜单ID
     */
    private Long id;
    /**
     * 包名
     */
    private String packageName;
    /**
     * 创建者
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新者
     */
    private String updateBy;
    /**
     * 更新时间
     */
    private Date updateTime;

}