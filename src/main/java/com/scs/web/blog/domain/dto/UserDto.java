package com.scs.web.blog.domain.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;



/**
 * @author liu tianyuan
 * @ClassName UserDto
 * @Description 用户传输对象
 * @Date 2019/11/9
 * @Version 1.0
 **/
@Data
public class UserDto implements Serializable {
    private String mobile;
    private String password;
    private String code;
    private String nickname;
    private String gender;
    private String avatar="https://upload.jianshu.io/users/upload_avatars/1300228/fd90987f-bad3-4dce-8783-f85a84fcf4c5.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/180/h/180";
    private LocalDate birthDay;
    private LocalDateTime creteTime;
}
