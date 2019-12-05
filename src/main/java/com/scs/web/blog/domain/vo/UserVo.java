package com.scs.web.blog.domain.vo;
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
public class UserVo {
    private User user;
//    private List<ArticleVo> articleList;
//    private List<Topic> topicList;
    private List<User> fansList;
}