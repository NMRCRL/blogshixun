package com.scs.web.blog.dao.impl;

import com.scs.web.blog.dao.FollowDao;
import com.scs.web.blog.entity.Topic;
import com.scs.web.blog.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;
/**
 * @author liu tianyuan
 * @ClassName
 * @Description
 * @Date 2019/12/7
 * @Version 1.0
 **/

public class FollowDaoImpl implements FollowDao {
    private static Logger logger = LoggerFactory.getLogger(FollowDaoImpl.class);

    @Override
    public List<User> getUserFollows(long userId) throws SQLException {
        return null;
    }

    @Override
    public List<User> getUserFans(long userId) throws SQLException {
        return null;
    }

    @Override
    public List<Topic> getTopicFollows(long topicId) throws SQLException {
        return null;
    }
}