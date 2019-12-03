package com.scs.web.blog.dao;

import com.scs.web.blog.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @author liu tianyuan
 * @ClassNameUser
 * @Description
 * @Date 2019/12/3
 * @Version 1.0
 **/


public interface UserDao {
//批量插入
    int [] batchInsert(List<User> userList)throws SQLException;
    //根据电话查询用户
    User findUserByMobile(String mobile)throws SQLException;
}
