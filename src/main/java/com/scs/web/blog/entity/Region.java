package com.scs.web.blog.entity;

import lombok.Data;

/**
 * @author liu tianyuan
 * @ClassName
 * @Description
 * @Date 2019/12/7
 * @Version 1.0
 **/


@Data
public class Region {
    private  Integer id;
    private String name;
    private Integer parentId;
    private Integer level;
    private String cityCode;
    private String postCode;
    private String mergeName;
}
