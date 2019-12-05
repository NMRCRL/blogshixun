package com.scs.web.blog.domain.vo;
import com.scs.web.blog.entity.Topic;
import com.scs.web.blog.entity.User;
import lombok.Data;

import java.util.List;
/**
 * @author liu tianyuan
 * @ClassName
 * @Description
 * @Date 2019/12/5
 * @Version 1.0
 **/
@Data
public class TopicVo {
    private Topic topic;
    private User admin;
    private List<ArticleVo> articleList;
    private List<User> followList;
}