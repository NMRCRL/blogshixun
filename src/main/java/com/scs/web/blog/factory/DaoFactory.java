package com.scs.web.blog.factory;

import com.scs.web.blog.dao.UserDao;
import com.scs.web.blog.dao.impl.UserDaoImpl;

/**
 * @author liu tianyuan
 * @ClassName
 * @Description
 * @Date 2019/12/3
 * @Version 1.0
 **/


public class DaoFactory {
    public static UserDao getUserDaoInstance(){
        return new UserDaoImpl();
    }
}
