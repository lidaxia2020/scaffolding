package com.scaffolding.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.scaffolding.demo.dao.SysUserMapper;
import com.scaffolding.demo.dto.SysUserDto;
import com.scaffolding.demo.entity.SysUser;
import com.scaffolding.demo.service.SysUserService;
import com.scaffolding.demo.utils.PageUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Wrapper;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/12/12 17:03
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser getAuthUserByUsername(String username) {
        /**
         * 实际上这里应该是从数据库中查询或者是调用其它服务接口获取，
         * 为了方便，这里直接创建用户信息
         * admin用户拥有 ROLE_ADMIN 和 ROLE_EMPLOYEE 这两个角色
         * employee用户拥有 ROLE_EMPLOYEE 这个角色
         * temp用户没有角色
         */
//        String password = new BCryptPasswordEncoder().encode("123");
        String password = "";
        if (username.equals("admin")) {
            SysUser user = new SysUser();
            user.setUserId(1L);
            user.setUserName("admin");
            /**
             * 密码为123（通过BCryptPasswordEncoderl加密后的密文）
             */
            user.setPassword(password);
            List<String> roles = new ArrayList<>();
            roles.add("ROLE_ADMIN");
            roles.add("ROLE_EMPLOYEE");
            user.setRoles(roles);
            return user;
        } else if (username.equals("employee")) {
            SysUser user = new SysUser();
            user.setUserId(2L);
            user.setUserName("employee");
            /**
             * 密码为123（通过BCryptPasswordEncoderl加密后的密文）
             */
            user.setPassword(password);
            List<String> roles = new ArrayList<>();
            roles.add("ROLE_EMPLOYEE");
            user.setRoles(roles);
            return user;
        } else if (username.equals("temp")) {
            SysUser user = new SysUser();
            user.setUserId(3L);
            user.setUserName("temp");
            /**
             * 密码为123（通过BCryptPasswordEncoderl加密后的密文）
             */
            user.setPassword(password);
            List<String> roles = new ArrayList<>();
            user.setRoles(roles);
            return user;
        } else {
            return null;
        }
    }

    @Override
    public Map list(int page, int pageSize,
                    String username, LocalDateTime startTime,
                    LocalDateTime endTime) {


        Map map = new HashMap();
        List<SysUser> list = sysUserMapper.list(username, startTime, endTime, PageUtils.getOffeset(page, pageSize), pageSize);
        Integer total = sysUserMapper.count(username, startTime, endTime);
        map.put("list", list);
        map.put("total", total);
        return map;
    }

    @Override
    public void add(SysUser sysUser) {

        sysUserMapper.insert(sysUser);
    }

    @Override
    public void delete(List<Integer> ids) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.in("user_id", ids);
        sysUserMapper.delete(wrapper);
    }

}
