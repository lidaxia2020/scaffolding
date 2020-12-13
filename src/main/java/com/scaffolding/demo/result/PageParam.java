package com.scaffolding.demo.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/12/12 21:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageParam {

    /**
     * 当前页码
     */
    private Integer page = 1;

    /**
     * 每页尺寸
     */
    private Integer size = 10;

    /**
     * 排序字段，默认使用ID来排序
     */
    private String sortField = "id";

    /**
     * 排序方式，默认升序
     */
    private String sortOrder = "DESC";


    public Integer getOffset(){

        return this.page > 0? (this.page -1) * this.size : 0;
    }

}