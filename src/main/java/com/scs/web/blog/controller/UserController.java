package com.scs.web.blog.controller;

import com.scs.web.blog.factory.ServiceFactory;
import com.scs.web.blog.service.UserService;
import com.scs.web.blog.util.HttpUtil;
import com.scs.web.blog.util.UrlPatten;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * @author liu tianyuan
 * @ClassName
 * @Description
 * @Date 2019/12/3
 * @Version 1.0
 **/

@WebServlet(urlPatterns = "/sign-in")
public class UserController extends HttpServlet {
    private static Logger logger= (Logger) LoggerFactory.getLogger(UserController.class);
    private UserService userService= ServiceFactory.getUserServiceInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI().trim();
        switch (uri) {
            case UrlPatten.USER_SIGN_IN:
                signIn();
                break;
            case UrlPatten.USER_SIGN_UP:
                signUp(req, resp);
                break;
            case UrlPatten.USER_CHECK_MOBILE:
                String mobile = req.getParameter("mobile");
                HttpUtil.getResponseBody(resp, userService.checkMobile(mobile));
                break;
            default:
        }
    }

}
