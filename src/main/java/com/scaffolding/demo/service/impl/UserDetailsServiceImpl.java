//package com.scaffolding.demo.service.impl;
//
///**
// * @author lidaxia
// * @version 1.0
// * @date 2020/12/12 17:01
// */
//
//import com.scaffolding.demo.entity.SysUser;
//import com.scaffolding.demo.service.SysUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 自定义的认证用户获取服务类
// */
//@Component("userDetailsServiceImpl")
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private SysUserService sysUserService;
//
//    /**
//     * 根据用户名获取认证用户信息
//     */
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        if(StringUtils.isEmpty(username)) {
//            throw new UsernameNotFoundException("UserDetailsService没有接收到用户账号");
//        } else {
//            /**
//             * 根据用户名查找用户信息
//             */
//            SysUser authUserByUsername = sysUserService.getAuthUserByUsername(username);
//            if(authUserByUsername == null) {
//                throw new UsernameNotFoundException(String.format("用户'%s'不存在", username));
//            }
//            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//            for (String role : authUserByUsername.getRoles()) {
//                //封装用户信息和角色信息到SecurityContextHolder全局缓存中
//                grantedAuthorities.add(new SimpleGrantedAuthority(role));
//            }
//            /**
//             * 创建一个用于认证的用户对象并返回，包括：用户名，密码，角色
//             */
//            return new User(authUserByUsername.getUserName(), authUserByUsername.getPassword(), grantedAuthorities);
//        }
//    }
//}