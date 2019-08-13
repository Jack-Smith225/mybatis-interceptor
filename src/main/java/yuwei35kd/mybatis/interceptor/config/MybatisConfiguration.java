package yuwei35kd.mybatis.interceptor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yuwei35kd.mybatis.interceptor.interceptor.ExecutorInteceptor;
import yuwei35kd.mybatis.interceptor.interceptor.LogInterceptor;

import java.util.Properties;

/**
 * mybatis配置
 */
@Configuration
public class MybatisConfiguration {

    /*@Bean
    public LogInterceptor logInterceptor() {
        LogInterceptor interceptor = new LogInterceptor();
        Properties properties = new Properties();
        // 设置是否显示数据库执行语句的执行时间
        properties.setProperty(LogInterceptor.PROPERTIES_KEY_ENABLE_EXECUTOR_TIME, LogInterceptor.ENABLE_EXECUTOR_TIME);
        interceptor.setProperties(properties);
        return interceptor;
    }*/

    @Bean
    public ExecutorInteceptor executorInteceptor() {
        ExecutorInteceptor interceptor = new ExecutorInteceptor();
        return interceptor;
    }

}
