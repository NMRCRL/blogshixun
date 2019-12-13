package com.scs.web.blog.dao;

import com.scs.web.blog.entity.Comment;

import java.sql.SQLException;
import java.util.List;
/**
 * @author liu tianyuan
 * @ClassName
 * @Description
 * @Date 2019/12/13
 * @Version 1.0
 **/

public interface CommentDao {
    /**
     * 添加新的评论
     * @param
     * @return
     * @throws SQLException
     */


    int insert(Comment user) throws SQLException;



    List<Comment> selectHotComments() throws SQLException;
    List<Comment> selectAll() throws SQLException;

}