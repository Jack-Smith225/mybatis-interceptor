package yuwei35kd.mybatis.interceptor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"yuwei35kd.mybatis.interceptor.dao"})
public class MybatisInterceptorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisInterceptorApplication.class, args);
    }

}
