package yuwei35kd.mybatis.interceptor;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import yuwei35kd.mybatis.interceptor.bean.User;
import yuwei35kd.mybatis.interceptor.dao.UserDao;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={MybatisInterceptorApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)

/*@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@MybatisTest*/
public class MybatisInterceptorApplicationTests {
    @Resource
    private UserDao userDao;

    @Test
    public void findById() {
        User user = userDao.findById(1);
        Assert.assertNull(user);
    }

    @Test
    public void findByName(){
        List<User> userList = userDao.findByName("李四");
        Assert.assertTrue("userList为空",userList!=null && !userList.isEmpty());
    }

    @Test
    public void findByNameAndBirthday(){
        List<User> userList = userDao.findByNameAndBirthday("李四","1991-05-12");
        Assert.assertTrue("userList为空",userList!=null && !userList.isEmpty());
    }

    @Test
    public void findAll(){
        List<User> userList = userDao.findAll();
        Assert.assertTrue("userList为空",userList!=null && !userList.isEmpty());
    }

}
