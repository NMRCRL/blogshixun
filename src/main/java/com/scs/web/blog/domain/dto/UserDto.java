package com.scs.web.blog.domain.dto;
import lombok.Data;
@Data
public class UserDto {
    private String mobile;
    private String password;
    private String code;

    //    数据传输对象
    public UserDto(String mobile, String password) {
        this.mobile = mobile;
        this.password = password;
    }

    public UserDto() {
    }

    public String getCode() {
        return code;
    }
}
