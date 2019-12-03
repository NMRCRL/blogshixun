package com.scs.web.blog.service.impl;

import com.scs.web.blog.dao.UserDao;
import com.scs.web.blog.domain.UserDto;
import com.scs.web.blog.entity.User;
import com.scs.web.blog.factory.DaoFactory;
import com.scs.web.blog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.Message;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liu tianyuan
 * @ClassName
 * @Description
 * @Date 2019/12/3
 * @Version 1.0
 **/


public class UserServiceImpl implements UserService {
    private UserDao userDao= DaoFactory.getUserDaoInstance();
    private  static Logger logger= (Logger) LoggerFactory.getLogger(UserServiceImpl.class);
    @Override
    public Map<String, Object> signIn(UserDto userDto) {
        User user = null;
        Map<String,Object> map = new HashMap<>();
        try{
            user = userDao.findUserByMobile(userDto.getMobile());
        } catch (SQLException e){
            logger.error("根据手机号查询用户出现异常");
        }
        if(user!=null){
            //将前端的密码于user中的进行比较
            if (user.getPassword().equals(userDto.getPassword())){
                map.put("msg", Message.SIGN_IN_SUCCESS);
                map.put("data",user);

            }else{
                map.put("msg",Message.PASSWORD_ERROR);
            }
        }else{
            map.put("msg",Message.MOBILE_NOT_FOUND);
        }
        return map;
    }

}



