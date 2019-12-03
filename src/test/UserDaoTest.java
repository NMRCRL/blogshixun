import com.scs.web.blog.dao.UserDao;
import com.scs.web.blog.factory.DaoFactory;
import com.scs.web.blog.util.JSoupSpider;
import org.junit.Test;

import java.sql.SQLException;
/**
 * @author liu tianyuan
 * @ClassName
 * @Description
 * @Date 2019/12/3
 * @Version 1.0
 **/


public class UserDaoTest {
    private UserDao userDao= DaoFactory.getUserDaoInstance();


    @Test
    public void batchInsert() throws SQLException {

        userDao.batchInsert(JSoupSpider.getUsers());

    }
}
