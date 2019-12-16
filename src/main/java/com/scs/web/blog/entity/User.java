package com.scs.web.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author liu tianyuan
 * @ClassName User
 * @Description 用户实体类
 * @Date 9:47 2019/11/9
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String mobile;
    private String password;
    private String nickname;
    private String avatar;
    private String gender;
    private LocalDate birthday;
    private String address;
    private String introduction;
    private String banner;
    private String email;
    private String homepage;
    private Integer follows;
    private Integer fans;
    private Integer articles;
    private LocalDateTime createTime;
    private Short status;

    public User(String mobile, String password) {
        this.mobile = mobile;
        this.password = password;
    }
    public User(String mobile, String password,String nickname,String gender,String avatar){
        this.mobile = mobile;
        this.password = password;
        this.nickname=nickname;
        this.gender=gender;
        this.avatar=avatar;
    }
}
