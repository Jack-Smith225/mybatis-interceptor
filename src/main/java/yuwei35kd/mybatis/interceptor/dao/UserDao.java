package yuwei35kd.mybatis.interceptor.dao;

import java.util.List;

import yuwei35kd.mybatis.interceptor.bean.User;

public interface UserDao {
    User findById(Integer userId);

    List<User> findByName(String userName);

    List<User> findByNameAndBirthday(String userName, String birthday);

    List<User> findAll();
}
