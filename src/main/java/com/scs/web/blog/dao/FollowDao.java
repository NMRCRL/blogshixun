package com.scs.web.blog.dao;

import com.scs.web.blog.entity.Topic;
import com.scs.web.blog.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @author liu tianyuan
 * @ClassName
 * @Description
 * @Date 2019/12/7
 * @Version 1.0
 **/

public interface FollowDao {
    /**
     * 根据用户id获取他关注的用户列表
     *
     * @param userId
     * @return
     * @throws SQLException
     */
    List<User> getUserFollows(long userId) throws SQLException;

    /**
     * 根据用户id获取他的粉丝列表
     *
     * @param userId
     * @return
     * @throws SQLException
     */
    List<User> getUserFans(long userId) throws SQLException, SQLException;

    /**
     * 根据专题id获取其所有关注用户
     * @param topicId
     * @return
     * @throws SQLException
     */
    List<Topic> getTopicFollows(long topicId) throws SQLException;
}