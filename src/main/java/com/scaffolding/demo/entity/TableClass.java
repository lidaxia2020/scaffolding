package com.scaffolding.demo.entity;

import lombok.Data;

import java.util.List;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/12/24 14:19
 */
@Data
public class TableClass {

    private String tableName;
    private String modelName;
    private String serviceName;
    private String mapperName;
    private String controllerName;
    private List<ColumnClass> columns;



}
