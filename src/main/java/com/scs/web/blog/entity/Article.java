package com.scs.web.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author liu tianyuan
 * @ClassName Article
 * @Description TODO
 * @Date 21:37 2019/11/9
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    private Long id;
    private Long userId;
    private Long topicId;
    private String title;
    private String summary;
    private String thumbnail;
    private String content;
    private Integer likes;
    private int comments;
    private LocalDateTime createTime;

    public Article(Long userId,Long topicId,String title,String summary ,String thumbnail,String content,int likes,int comments,LocalDateTime createTime){
        this.userId=userId;
        this.topicId=topicId;
        this.title=title;
        this.summary=summary;
        this.thumbnail=thumbnail;
        this.content=content;
        this.likes=likes;
        this.comments=comments;
        this.createTime=createTime;
    }

}

