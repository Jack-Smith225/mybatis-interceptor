package yuwei35kd.mybatis.interceptor.service;

import javax.annotation.Resource;
import java.util.List;

import org.springframework.stereotype.Service;
import yuwei35kd.mybatis.interceptor.bean.User;
import yuwei35kd.mybatis.interceptor.dao.UserDao;

@Service
public class UserService {
    @Resource
    private UserDao userDao;

    public User findById(Integer userId) {
        return userDao.findById(userId);
    }

    public List<User> findByName(String userName) {
        return userDao.findByName(userName);
    }

    public List<User> findByNameAndBirthday(String userName, String birthday) {
        return userDao.findByNameAndBirthday(userName, birthday);
    }

    public List<User> findAll(){
        return userDao.findAll();
    }
}
