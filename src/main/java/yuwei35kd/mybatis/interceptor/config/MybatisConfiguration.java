package yuwei35kd.mybatis.interceptor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yuwei35kd.mybatis.interceptor.interceptor.LanguagePlugin;
import yuwei35kd.mybatis.interceptor.interceptor.LogPlugin;

import java.util.Properties;

/**
 * mybatis配置
 */
@Configuration
public class MybatisConfiguration {

    @Bean
    public LogPlugin logInterceptor() {
        LogPlugin interceptor = new LogPlugin();
        Properties properties = new Properties();
        // 设置是否显示数据库执行语句的执行时间
        properties.setProperty(LogPlugin.PROPERTIES_KEY_ENABLE_EXECUTOR_TIME, LogPlugin.ENABLE_EXECUTOR_TIME);
        interceptor.setProperties(properties);
        return interceptor;
    }

    @Bean
    public LanguagePlugin executorInteceptor() {
        LanguagePlugin interceptor = new LanguagePlugin();
        return interceptor;
    }

}
