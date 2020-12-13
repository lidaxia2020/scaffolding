package com.scaffolding.demo.service;

import com.scaffolding.demo.dto.SysUserDto;
import com.scaffolding.demo.entity.SysUser;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/12/12 17:03
 */
public interface SysUserService {

    SysUser getAuthUserByUsername(String username);

    Map list(int page, int pageSize,
             String username, LocalDateTime startTime,
             LocalDateTime endTime);

    void add(SysUser sysUser);

    void delete(List<Integer> ids);
}
