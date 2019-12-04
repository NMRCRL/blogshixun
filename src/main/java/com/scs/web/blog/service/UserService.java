package com.scs.web.blog.service;

import com.scs.web.blog.domain.dto.UserDto;
import com.scs.web.blog.util.Result;

/**
 * @author liu tianyuan
 * @ClassName
 * @Description
 * @Date 2019/12/3
 * @Version 1.0
 **/


public interface UserService {
    /**
     * 用户登录功能
     *
     * @param userDto
     * @return Result
     */
    Result signIn(UserDto userDto);
    /**
     * 用户注册
     * @param userDto
     * @return Result
     */
    Result signUp(UserDto userDto);
    /**
     * 验证手机号是否可用
     * @param mobile
     * @return Result
     */
    Result checkMobile(String mobile);
}
