package com.scs.web.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author liu tianyuan
 * @ClassName
 * @Description
 * @Date 2019/12/7
 * @Version 1.0
 **/


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private Long id;
    private Long userId;
    private Long articleId;
    private String content;
    private LocalDateTime createTime;
}
