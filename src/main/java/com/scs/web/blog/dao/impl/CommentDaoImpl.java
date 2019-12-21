package com.scs.web.blog.dao.impl;
import com.scs.web.blog.dao.CommentDao;
import com.scs.web.blog.domain.dto.CommentDto;
import com.scs.web.blog.util.BeanHandler;
import com.scs.web.blog.util.DbUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.List;
/**
 * @author liu tianyuan
 * @ClassName
 * @Description
 * @Date 2019/12/20
 * @Version 1.0
 **/

public class CommentDaoImpl implements CommentDao {
    private static Logger logger = LoggerFactory.getLogger(FollowDaoImpl.class);
    @Override
    public List<CommentDto> selectAll(long article_id) throws SQLException {
        Connection connection = DbUtil.getConnection();
        String sql = "select t_comment.id , t_comment.content , t_user.nickname from t_comment , t_user where article_id= ? and t_user.id = t_comment.user_id";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setLong(1,article_id);
        ResultSet rs = pst.executeQuery();
        List<CommentDto>  list = BeanHandler.converComment(rs);
        DbUtil.close(connection, pst, rs);
        return list;
    }

    @Override
    public boolean addComment(long artcle_id, long user_id, String content) throws SQLException {
        Connection connection = DbUtil.getConnection();
        boolean success = false ;
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String sql = "insert into t_comment (user_id , article_id , content , create_time) values (? ,? , ? ,?)";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setLong(1,user_id);
        pst.setLong(2, artcle_id);
        pst.setString(3,content);
        pst.setTimestamp(4,timestamp);
        System.out.println(content);
        int rs = pst.executeUpdate() ;
        if (rs > 0 ){
            success = true ;
        }
        DbUtil.close(connection, pst);
        return success;
    }


}