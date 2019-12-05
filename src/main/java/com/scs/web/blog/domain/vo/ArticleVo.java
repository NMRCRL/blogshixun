package com.scs.web.blog.domain.vo;

import com.scs.web.blog.entity.Article;
import com.scs.web.blog.entity.Topic;
import com.scs.web.blog.entity.User;
import lombok.Data;
/**
 * @author liu tianyuan
 * @ClassName
 * @Description
 * @Date 2019/12/5
 * @Version 1.0
 **/

@Data
public class ArticleVo {
    private Article article;
    private User author;
    private Topic topic;
}