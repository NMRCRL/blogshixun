package com.scs.web.blog.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

/**
 * @author liu tianyuan
 * @ClassName
 * @Description 数据生成工具
 * @Date 2019/12/3
 * @Version 1.0
 **/


public class DataUtil {
    //获得电话号码
    public static String getMobile(){
        StringBuilder stringBuilder=new StringBuilder("139");
        Random random= new Random();
        for (int i=0;i<8;i++){
            //左开右比
            int num=random.nextInt(10);
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }
    //随机生成密码
    public static String getPassword(){
        StringBuilder password=new StringBuilder();
        Random random=new Random();
        for (int i=0;i<6;i++){
            int num=random.nextInt(10);
            password.append(num);
        }
        return DigestUtils.md5Hex(password.toString());
    }
    //随机获得性别
    public static String getGender(){
        String[]gender=new String[]{"男","女"};
        Random random=new Random();
        //根据从数组的索引获取值
        int index=random.nextInt(2);
        return gender[index];
    }
    //随机获取生日的日期
    public static LocalDate getBirthday(){
        LocalDate now=LocalDate.now();
        Random random=new Random();
        int bound=random.nextInt(6666);
        //当前日期的bound天
        return now.minusDays(bound);
    }
    /**
     * 生成时间
     *
     * @return
     */
    public static LocalDateTime getCreateTime() {
        LocalDateTime now = LocalDateTime.now();
        Random random = new Random();
        int bound = random.nextInt(999);
        return now.minusHours(bound);
    }
}
