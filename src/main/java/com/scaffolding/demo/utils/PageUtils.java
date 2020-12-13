package com.scaffolding.demo.utils;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/12/13 15:57
 */
public class PageUtils {

    public static Integer getOffeset(int page, int size) {
        return page > 0 ? (page - 1) * size : 0;
    }
}
