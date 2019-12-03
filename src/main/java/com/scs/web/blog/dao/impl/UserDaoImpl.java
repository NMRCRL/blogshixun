package com.scs.web.blog.dao.impl;

import com.scs.web.blog.dao.UserDao;
import com.scs.web.blog.entity.User;
import com.scs.web.blog.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author liu tianyuan
 * @ClassName
 * @Description
 * @Date 2019/12/3
 * @Version 1.0
 **/


public class UserDaoImpl implements UserDao {
    @Override
    public int[] batchInsert(List<User> userList) throws SQLException {
        //链接数据库
        Connection connection= DbUtil.getConnection();
        //sql语句,就是数据执行的操作，括号中的为数据库的列名（主键自增，不设值），问号的个数于列名相等
        String sql="INSERT INTO t_user (mobile ,password,nickname,avatar,gender,birthday,introduction,create_time) VALUES(?,?,?,?,?,?,?,?)";
        //关闭自动提交（true为自动提交）
        connection.setAutoCommit(false);
        //执行SQL语句
        PreparedStatement pstmt=connection.prepareStatement(sql);
        //遍历，将数据存入数据库中
        userList.forEach(user -> {
            try{
                pstmt.setString(1,user.getMobile());
                pstmt.setString(2,user.getPassword());
                pstmt.setString(3,user.getNickname());
                pstmt.setString(4,user.getAvatar());
                pstmt.setString(5,user.getGender());
                //日期的设置，可以使用setObject
                pstmt.setObject(6,user.getBirthday());
                pstmt.setString(7,user.getIntroduction());
                pstmt.setObject(8,user.getCreateTime());
                //addBatch 将语句添加到同一批操作中
                pstmt.addBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        //将添加进来的单个操作进行批操作
        int[]result=pstmt.executeBatch();
        //提交数据，将数据存入数据库
        connection.commit();
        //关闭数据库
        DbUtil.close(connection,pstmt);
        return result;
    }

    @Override
    public User findUserByMobile(String mobile) throws SQLException {
        Connection connection=DbUtil.getConnection();
        String sql="SELECT *FROM t_user WHERE mobile=?";
        PreparedStatement pstmt=connection.prepareStatement(sql);
        pstmt.setString(1,mobile);
        ResultSet rs=pstmt.executeQuery();
        User user=null;
        while (rs.next()){
            user=new User();
            user.setId(rs.getLong("id"));
            user.setMobile(rs.getString("mobile"));
            user.setPassword(rs.getString("Password"));
            user.setNickname(rs.getString("nickname"));
            user.setAddress(rs.getString("avatar"));
            user.setGender(rs.getString("gender"));
            user.setBirthday(rs.getDate("birthday").toLocalDate());
            user.setIntroduction(rs.getString("introduction"));
            user.setAddress(rs.getString("address"));
            user.setFollows(rs.getShort("follows"));
            user.setFans(rs.getShort("fans"));
            user.setArticles(rs.getShort("articles"));
            user.setCreateTime(rs.getTimestamp("create_time").toLocalDateTime());
            user.setStatus(rs.getShort("status"));
        }
        return user;
    }
}
