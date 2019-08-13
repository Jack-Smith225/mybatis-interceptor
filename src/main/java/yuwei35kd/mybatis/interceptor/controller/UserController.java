package yuwei35kd.mybatis.interceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import yuwei35kd.mybatis.interceptor.bean.User;
import yuwei35kd.mybatis.interceptor.service.UserService;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/findById")
    public User findById(Integer userId){
        return userService.findById(userId);
    }

    @GetMapping("/findByName")
    public List<User> findByName(String userName){
        return userService.findByName(userName);
    }

    @GetMapping("/findByNameAndBirthday")
    public List<User> findByNameAndBirthday(String userName, String birthday){
        return userService.findByNameAndBirthday(userName,birthday);
    }

    @GetMapping("/findAll")
    public List<User> findAll(){
        return userService.findAll();
    }
}
