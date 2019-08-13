package yuwei35kd.mybatis.interceptor.interceptor;

import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import yuwei35kd.mybatis.interceptor.config.LanguageThreadLocal;
import yuwei35kd.mybatis.interceptor.utils.ReflectUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Intercepts({
        @Signature(
                method = "query",
                type = Executor.class,
                args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}
        )
})
public class ExecutorInteceptor implements Interceptor {
    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {}

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement ms = (MappedStatement)invocation.getArgs()[0];
        Configuration configuration = ms.getConfiguration();
        String language = LanguageThreadLocal.getLanguage();
        Object parameterObject = invocation.getArgs()[1];

        BoundSql boundSql = ms.getBoundSql(parameterObject);
        List<ParameterMapping> parameterMappingList = boundSql.getParameterMappings();
        if(parameterObject==null){//0个参数
            parameterObject = language;
        }else if(parameterObject!=null){
            if(parameterObject instanceof MapperMethod.ParamMap){//多个参数
                ((MapperMethod.ParamMap) parameterObject).put("language",language);
            }else{//1个参数
                String property = parameterMappingList.get(0).getProperty();
                MapperMethod.ParamMap po = new MapperMethod.ParamMap();
                po.put(property, parameterObject);
                po.put("language",language);

                boundSql = ms.getBoundSql(po);

                ParameterMapping parameterMapping = new ParameterMapping.Builder(configuration,language, java.lang.Object.class).build();
                List<ParameterMapping> pmList = new ArrayList<>();
                pmList.addAll(parameterMappingList);
                pmList.add(parameterMapping);

                ReflectUtil.setFieldValue(boundSql,"parameterObject",po);
                ReflectUtil.setFieldValue(boundSql,"parameterMappings",pmList);
            }
        }


        /*ParameterMapping parameterMapping = new ParameterMapping.Builder(configuration,"language", java.lang.Object.class).build();
        parameterMappingList.add(parameterMapping);*/
        return invocation.proceed();
    }
}
