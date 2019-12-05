package com.scs.web.blog.dao.impl;

import com.scs.web.blog.dao.UserDao;
import com.scs.web.blog.domain.vo.UserVo;
import com.scs.web.blog.entity.User;
import com.scs.web.blog.util.BeanHandler;
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
    //新增用户
    @Override
    public void insert(User user) throws SQLException {
        Connection connection = DbUtil.getConnection();
        String sql = "INSERT INTO t_user (mobile,password) VALUES (?,?) ";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, user.getMobile());
        pst.setString(2, user.getPassword());
        pst.executeUpdate();
        DbUtil.close(connection, pst);
    }
//批量新增用户
    @Override
    public void batchInsert(List<User> userList) throws SQLException {
        Connection connection = DbUtil.getConnection();
        connection.setAutoCommit(false);
        String sql = "INSERT INTO t_user (id,mobile,password,nickname,avatar,gender,birthday,address,introduction,homepage,follows,fans,articles,create_time,status) VALUES (null,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
        PreparedStatement pst = connection.prepareStatement(sql);
        userList.forEach(user -> {
            try {
                pst.setString(1, user.getMobile());
                pst.setString(2, user.getPassword());
                pst.setString(3, user.getNickname());
                pst.setString(4, user.getAvatar());
                pst.setString(5, user.getGender());
                pst.setObject(6, user.getBirthday());
                pst.setString(7, user.getAddress());
                pst.setString(8, user.getIntroduction());
                pst.setString(9, user.getHomepage());
                pst.setInt(10, 0);
                pst.setInt(11, 0);
                pst.setInt(12, 0);
                pst.setObject(13, user.getCreateTime());
                pst.setShort(14, user.getStatus());
                pst.addBatch();
            } catch (SQLException e) {
                e.printStackTrace();
//                logger.error("批量加入用户数据产生异常");
            }
        });
        pst.executeBatch();
        connection.commit();
        DbUtil.close(connection, pst);
    }

//    @Override
//    public int[] batchInsert(List<User> userList) throws SQLException {
//        //链接数据库
//        Connection connection= DbUtil.getConnection();
//        //sql语句,就是数据执行的操作，括号中的为数据库的列名（主键自增，不设值），问号的个数于列名相等
//        String sql="INSERT INTO t_user (mobile ,password,nickname,avatar,gender,birthday,introduction,create_time) VALUES(?,?,?,?,?,?,?,?)";
//        //关闭自动提交（true为自动提交）
//        connection.setAutoCommit(false);
//        //执行SQL语句
//        PreparedStatement pstmt=connection.prepareStatement(sql);
//        //遍历，将数据存入数据库中
//        userList.forEach(user -> {
//            try{
//                pstmt.setString(1,user.getMobile());
//                pstmt.setString(2,user.getPassword());
//                pstmt.setString(3,user.getNickname());
//                pstmt.setString(4,user.getAvatar());
//                pstmt.setString(5,user.getGender());
//                //日期的设置，可以使用setObject
//                pstmt.setObject(6,user.getBirthday());
//                pstmt.setString(7,user.getIntroduction());
//                pstmt.setObject(8,user.getCreateTime());
//                //addBatch 将语句添加到同一批操作中
//                pstmt.addBatch();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        });
//        //将添加进来的单个操作进行批操作
//        int[]result=pstmt.executeBatch();
//        //提交数据，将数据存入数据库
//        connection.commit();
//        //关闭数据库
//        DbUtil.close(connection,pstmt);
//        return result;
//    }
//根据手机号查询用户
    @Override
    public User findUserByMobile(String mobile) throws SQLException {
        Connection connection = DbUtil.getConnection();
        String sql = "SELECT * FROM t_user WHERE mobile = ? ";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, mobile);
        ResultSet rs = pst.executeQuery();
        List<User> userList = BeanHandler.convertUser(rs);
        User user = null;
        if (userList.size() != 0) {
            user = userList.get(0);
        }
        DbUtil.close(connection, pst, rs);
        return user;
    }
//查询热门用户
    @Override
    public List<User> selectHotUsers() throws SQLException {
        Connection connection = DbUtil.getConnection();
        String sql = "SELECT * FROM t_user ORDER BY fans DESC LIMIT 10 ";
        PreparedStatement pst = connection.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        List<User> userList = BeanHandler.convertUser(rs);
        DbUtil.close(connection, pst, rs);
        return userList;
    }
//查询分页用户
    @Override
    public List<User> selectByPage(int currentPage, int count) throws SQLException {
        Connection connection = DbUtil.getConnection();
        String sql = "SELECT * FROM t_user LIMIT ?,? ";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setInt(1, (currentPage - 1) * count);
        pst.setInt(2, count);
        ResultSet rs = pst.executeQuery();
        List<User> userList = BeanHandler.convertUser(rs);
        DbUtil.close(connection, pst, rs);
        return userList;
    }
//根据id查询用户
    @Override
    public UserVo getUser(long id) throws SQLException {
        Connection connection = DbUtil.getConnection();
        String sql = "SELECT * FROM t_user WHERE id = ? ";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setLong(1, id);
        ResultSet rs = pst.executeQuery();
        UserVo userVo = new UserVo();
        User user = BeanHandler.convertUser(rs).get(0);
        userVo.setUser(user);
        DbUtil.close(connection, pst, rs);
        return userVo;
    }
//模糊查询用户
    @Override
    public List<User> selectByKeywords(String keywords) throws SQLException {
        Connection connection = DbUtil.getConnection();
        String sql = "SELECT * FROM t_user " +
                "WHERE nickname LIKE ?  OR introduction LIKE ? ";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, "%" + keywords + "%");
        pst.setString(2, "%" + keywords + "%");
        ResultSet rs = pst.executeQuery();
        List<User> userList = BeanHandler.convertUser(rs);
        DbUtil.close(connection, pst, rs);
        return userList;
    }

}
