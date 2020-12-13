package com.scaffolding.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.scaffolding.demo.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/12/12 16:22
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 查询列表
     * @param username
     * @param startTime
     * @param endTime
     * @param offset
     * @param size
     * @return
     */
    List<SysUser> list(@Param("username") String username, @Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime, @Param("offset") Integer offset, @Param("size") Integer size);

    /**
     * 查询总数
     * @param username
     * @param startTime
     * @param endTime
     * @return
     */
    Integer count(@Param("username") String username, @Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime);
}
