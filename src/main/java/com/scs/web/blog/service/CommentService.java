package com.scs.web.blog.service;

import com.scs.web.blog.entity.Comment;
import com.scs.web.blog.util.Result;

import java.util.List;
/**
 * @author liu tianyuan
 * @ClassName
 * @Description
 * @Date 2019/12/13
 * @Version 1.0
 **/
public interface CommentService {

    /**
     * 新增评论
     * @param
     * @return
     */
    Result addArtComments(Comment comment);


    List<Comment> listComment();
    /**
     * 根据文章id查询所有评论信息
     * @param
     * @return
     */

}