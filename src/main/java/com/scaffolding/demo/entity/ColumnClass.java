package com.scaffolding.demo.entity;

import lombok.Data;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/12/24 14:20
 */
@Data
public class ColumnClass {

    private String propertyName;

    private String columnName;

    private String type;

    private String remark;

    private Boolean isPrimary;
}
