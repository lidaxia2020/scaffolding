package com.scaffolding.demo.dto;

import lombok.Data;

import java.util.List;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2021/1/7 17:34
 */
@Data
public class RoleAddDto {

    private String name;

    private List<Integer> menuList;

    private String remark;
}
