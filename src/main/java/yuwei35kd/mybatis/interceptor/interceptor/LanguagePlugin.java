package yuwei35kd.mybatis.interceptor.interceptor;

import org.apache.ibatis.builder.StaticSqlSource;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import yuwei35kd.mybatis.interceptor.config.LanguageThreadLocal;
import yuwei35kd.mybatis.interceptor.utils.ReflectUtil;

import java.util.Properties;

@Intercepts({
        @Signature(
                method = "query",
                type = Executor.class,
                args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}
        )
})
public class LanguagePlugin implements Interceptor {
    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {}

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement ms = (MappedStatement)invocation.getArgs()[0];
        Object parameterObject = invocation.getArgs()[1];
        BoundSql boundSql = ms.getBoundSql(parameterObject);
        String sql = boundSql.getSql();
        //替换@language为当前线程中的language
        sql = sql.replaceAll("@language",LanguageThreadLocal.getLanguage());

        // 创建一个 StaticSqlSource，并将拼接好的 sql 传入
        SqlSource sqlSource = new StaticSqlSource(
                ms.getConfiguration(), sql, boundSql.getParameterMappings());
        ReflectUtil.setFieldValue(ms,"sqlSource",sqlSource);
        return invocation.proceed();
    }
}
