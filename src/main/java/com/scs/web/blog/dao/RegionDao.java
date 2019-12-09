package com.scs.web.blog.dao;
import com.scs.web.blog.entity.Region;

import java.sql.SQLException;
import java.util.List;
/**
 * @author liu tianyuan
 * @ClassName
 * @Description
 * @Date 2019/12/7
 * @Version 1.0
 **/

public interface RegionDao {

    /**
     *  查询所有地址
     *
     * @return
     */
    List<Region> selectAll()throws SQLException;
}