package com.scs.web.blog.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.scs.web.blog.factory.ServiceFactory;
import com.scs.web.blog.service.CommentService;
import com.scs.web.blog.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author liu tianyuan
 * @ClassName
 * @Description
 * @Date 2019/12/13
 * @Version 1.0
 **/

@WebServlet(urlPatterns = {"/api/comment", "/api/add/comment"})
public class CommentController extends HttpServlet {
    private CommentService commentService = ServiceFactory.getCommentServiceINstance();
    private static Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获得请求地质
        String uri = req.getRequestURI().trim();
        if ("/api/comment".equals(uri)) {
            String article_id = req.getParameter("article");
            getAllComments(resp, Long.parseLong(article_id));
        } else {
            String article_id = req.getParameter("article");
            String user_id = req.getParameter("user");
            String content = req.getParameter("content");
            addComment(resp, Long.parseLong(article_id), Long.parseLong(user_id), content);
        }
    }

    private void addComment(HttpServletResponse resp, long parseLong, long parseLong1, String content) throws IOException {
        Gson gson = new GsonBuilder().create();
        Result result = commentService.addComment(parseLong1, parseLong, content);
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(result));
        out.close();
    }

    private void getAllComments(HttpServletResponse resp, long parseLong) throws IOException {
        Gson gson = new GsonBuilder().create();
        Result result = commentService.getComments(parseLong);
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(result));
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
