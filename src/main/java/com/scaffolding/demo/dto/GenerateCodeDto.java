package com.scaffolding.demo.dto;

import com.scaffolding.demo.entity.TableClass;
import lombok.Data;

import java.util.List;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/12/24 17:06
 */
@Data
public class GenerateCodeDto {

    private Db db;

    List<TableClass> tableClassList;

}
