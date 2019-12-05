package com.scs.web.blog.service.impl;

import com.scs.web.blog.dao.UserDao;
import com.scs.web.blog.domain.dto.UserDto;
import com.scs.web.blog.entity.User;
import com.scs.web.blog.factory.DaoFactory;
import com.scs.web.blog.service.UserService;
import com.scs.web.blog.util.Result;
import com.scs.web.blog.util.ResultCode;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

/**
 * @author liu tianyuan
 * @ClassName
 * @Description
 * @Date 2019/12/3
 * @Version 1.0
 **/


public class UserServiceImpl implements UserService {
    private UserDao userDao = DaoFactory.getUserDaoInstance();
    private static Logger logger = (Logger) LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public Result signIn(UserDto userDto) {
        User user = null;
        try {
            user = userDao.findUserByMobile(userDto.getMobile());
        } catch (SQLException e) {
            logger.error("根据手机号查询用  户出现异常");
        }
        if (user != null) {
            //数据库查到的用户密码和前端传递的用户密码（经过加密）相等
            if (user.getPassword().equals(DigestUtils.md5Hex(userDto.getPassword()))) {
                //登录成功
                return (Result) Result.success(user);
            } else {
                //密码错误
                return (Result) Result.failure(ResultCode.USER_PASSWORD_ERROR);
            }
        } else {
            //账号错误
            return (Result) Result.failure(ResultCode.USER_ACCOUNT_ERROR);
        }
    }

    @Override
    public Result getHotUsers() {
        List<User> userList = null;
        try {
            userList = userDao.selectHotUsers();
        } catch (SQLException e) {
            logger.error("获取热门用户出现异常");
        }
        if (userList != null) {
            //成功并返回数据
            return Result.success(userList);
        } else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

    @Override
    public Result signUp(UserDto userDto) {
        User user = new User(userDto.getMobile(), userDto.getPassword());
        try {
            userDao.insert(user);
            return Result.success();
        } catch (SQLException e) {
            logger.error("新增用户出现异常");
            return Result.failure(ResultCode.USER_SIGN_UP_FAIL);
        }
    }

    @Override
    public Result checkMobile(String mobile) {
        User user = null;
        try {
            user = userDao.findUserByMobile(mobile);
        } catch (SQLException e) {
            logger.error("根据手机号查询用户信息出现异常");
        }
        if (user == null) {
            return Result.success(ResultCode.USER_NOT_EXIST);
        } else {
            return Result.failure(ResultCode.USER_HAS_EXISTED);
        }
    }

    @Override
    public Result selectByPage(int currentPage, int count) {
        List<User> userList = null;
        try {
            userList = userDao.selectByPage(currentPage, count);
        } catch (
                SQLException e) {
            logger.error("分页查询用户出现异常");
        }
        if (userList != null) {
            return Result.success(userList);
        } else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }


    @Override
    public Result getUser(long id) {
//        UserVo userVo = null;
//        try {
//            userVo = userDao.getUser(id);
//        } catch (SQLException e) {
//            logger.error("根据id获取用户详情出现异常");
//        }
//        if (userVo != null) {
//            try {
//                List<ArticleVo> articleVoList = articleDao.selectByUserId(id);
//                userVo.setArticleList(articleVoList);
//                return Result.success(userVo);
//            } catch (SQLException e) {
//                logger.error("根据用户id获取文章列表数据出现异常");
//            }
//        }
//        return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        return null;
    }

    @Override
    public Result selectByKeywords(String keywords) {
        List<User> userList = null;
        try {
            userList = userDao.selectByKeywords(keywords);
        } catch (SQLException e) {
            logger.error("根据关键字查询用户出现异常");
        }
        if (userList != null) {
            return Result.success(userList);
        } else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

}



