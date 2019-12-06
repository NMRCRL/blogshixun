package com.scs.web.blog.domain.dto;

import lombok.Data;

import java.io.Serializable;

//@Data
//public class UserDto {
//    private String mobile;
//    private String password;
//    private String code;
//
//    //    数据传输对象
//    public UserDto(String mobile, String password) {
//        this.mobile = mobile;
//
//        this.password = password;
//    }
//
//    public UserDto() {
//    }
//
//    public String getCode() {
//        return code;
//    }
//}
@Data
public class UserDto implements Serializable {
    private String mobile;
    private String password;
    private String code;

}
