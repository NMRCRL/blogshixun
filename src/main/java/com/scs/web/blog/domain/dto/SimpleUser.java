package com.scs.web.blog.domain.dto;
import lombok.Data;
/**
 * @author liu tianyuan
 * @ClassName
 * @Description
 * @Date 2019/12/9
 * @Version 1.0
 **/

@Data
public class SimpleUser {
    private Long id;
    private String nickname;
    private String avatar;
}