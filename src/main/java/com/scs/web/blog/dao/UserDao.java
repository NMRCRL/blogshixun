package com.scs.web.blog.dao;

import com.scs.web.blog.domain.vo.UserVo;
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
    //新增用户
    void insert(User user) throws SQLException;

    //批量插入
    void batchInsert(List<User> userList) throws SQLException;

    //根据电话查询用户
    User findUserByMobile(String mobile) throws SQLException;
//查询热门用户
    List<User> selectHotUsers() throws SQLException;
    //查询分页用户
    List<User> selectByPage(int currentPage,int count) throws SQLException;
    //根据ID查询用户
    UserVo getUser(long id) throws SQLException;
    //模糊搜索用户
    List<User> selectByKeywords(String keywords) throws SQLException;


}
