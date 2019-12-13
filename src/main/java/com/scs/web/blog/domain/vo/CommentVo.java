package com.scs.web.blog.domain.vo;
import com.scs.web.blog.entity.User;
import lombok.Data;

import javax.xml.stream.events.Comment;
/**
 * @author liu tianyuan
 * @ClassName
 * @Description
 * @Date 2019/12/13
 * @Version 1.0
 **/
@Data
public class CommentVo {
    private String avatar;
    private String nickname;
    private Comment comment;
    private User user;


}