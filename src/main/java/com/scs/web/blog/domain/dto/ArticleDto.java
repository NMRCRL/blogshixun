package com.scs.web.blog.domain.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author liu tianyuan
 * @ClassName
 * @Description
 * @Date 2019/12/17
 * @Version 1.0
 **/

@Data
public class ArticleDto implements Serializable {
    private Long userId;
    private Long topicId;
    private String title;
    private String summary;
    private String thumbnail;
    private String content;
    private int likes = 100;
    private int  comment;
    private LocalDateTime createTime;

}
