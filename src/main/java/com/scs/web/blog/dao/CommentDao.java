package com.scs.web.blog.dao;


import com.scs.web.blog.domain.dto.CommentDto;

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
     * 查询所有的评论
     * @param article_id
     * @return
     */
    List<CommentDto> selectAll(long article_id) throws SQLException;

    /**
     *
     * @param artcle_id
     * @param user_id
     * @param content
     * @return
     * @throws SQLException
     */
    boolean addComment(long artcle_id, long user_id, String content) throws SQLException;

}