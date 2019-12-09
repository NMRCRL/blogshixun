package com.scs.web.blog.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
public class UserFollow {
    private Long id;
    private Long fromId;
    private Long toId;
}