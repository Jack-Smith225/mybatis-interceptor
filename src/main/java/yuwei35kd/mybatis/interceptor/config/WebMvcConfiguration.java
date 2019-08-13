package yuwei35kd.mybatis.interceptor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import yuwei35kd.mybatis.interceptor.interceptor.MyInterceptor;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new MyInterceptor());
    }
}
