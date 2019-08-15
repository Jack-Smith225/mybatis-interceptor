# mybatis-interceptor

### 目标
```text
通过mybatis的拦截器实现一些功能
1，打印sql以及输出sql执行时间
2，多语言切换，动态选择字段
```

### 说明
```text
resources目录下的文件
1,init.sql是初始化数据库、表、数据的脚本
2,mybatis-interceptor.postman_collection.json 是对应测试的postman导出的文件
```
### mybatis 插件
```text
1，LanguagePlugin
多语言切换，动态选择字段
2，LogPlugin
打印sql以及输出sql执行时间
```
