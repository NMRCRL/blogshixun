package com.scs.web.blog.factory;

import com.scs.web.blog.service.UserService;
import com.scs.web.blog.service.impl.UserServiceImpl;

/**
 * @author liu tianyuan
 * @ClassName
 * @Description
 * @Date 2019/12/3
 * @Version 1.0
 **/


public class ServiceFactory {
    public static UserService getUserServiceInstance() {
        return new UserServiceImpl();
    }
}
