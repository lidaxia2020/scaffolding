package com.scaffolding.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.scaffolding.demo.entity.SysUser;
import java.util.List;
import java.util.Map;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/12/12 17:03
 */
public interface SysUserService extends IService<SysUser> {

    SysUser getAuthUserByUsername(String username);

    /**
     * 获取页面列表
     * @param page
     * @param pageSize
     * @param username
     * @param startTime
     * @param endTime
     * @return
     */
    Map list(int page, int pageSize,
             String username, String startTime,
             String endTime);

}
