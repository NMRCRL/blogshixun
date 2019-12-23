package com.scs.web.blog.service;


import com.scs.web.blog.util.Result;
/**
 * @author liu tianyuan
 * @ClassName
 * @Description
 * @Date 2019/12/13
 * @Version 1.0
 **/
public interface CommentService {

    /**
     *
     * @param
     * @return
     */
    Result getComments(long article_id);

    /**
     *
     * @param user_id
     * @param article_id
     * @param content
     * @return
     */
    Result addComment(long user_id, long article_id, String content);


    Result deleteComment(long user_id , long article_id ,int index);
}
