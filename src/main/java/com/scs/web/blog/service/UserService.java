package com.scs.web.blog.service;

import com.scs.web.blog.domain.UserDto;

import java.util.Map;

/**
 * @author liu tianyuan
 * @ClassName
 * @Description
 * @Date 2019/12/3
 * @Version 1.0
 **/


public interface UserService {
    //登录功能
    Map<String ,Object> signIn(UserDto userDto);
}
