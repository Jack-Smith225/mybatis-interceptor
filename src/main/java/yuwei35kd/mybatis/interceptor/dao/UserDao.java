package yuwei35kd.mybatis.interceptor.dao;

import yuwei35kd.mybatis.interceptor.bean.User;

import java.util.List;

public interface UserDao {
    User findById(Integer userId);

    List<User> findByName(String userName);

    List<User> findByNameAndBirthday(String userName, String birthday);

    List<User> findAll();
}
