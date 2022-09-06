# Seata Springboot Sample

Springboot 中使用 Seata，使用 Feign 实现远程调用，使用 Spring Jpa 访问 MySQL 数据库，
原官方示例代码中都引用了 `spring-cloud-alibaba-seata` 这个依赖，本示例中并未引用该依赖

### 准备工作

* 1.执行`sql/database.sql`

* 2.下载最新版本的 [Seata Sever](https://github.com/seata/seata/releases)

* 3.解压并启动 Seata server

```bash
unzip seata-server-1.5.2.zip

cd seata-server-1.5.2\seata\bin
seata-server.bat -m file -p 8091
```

* 4.启动 Account, Order, Stock, Web 服务

## 测试

* 模拟请求成功提交：`curl http://127.0.0.1:8084/purchase/commit`

* 模拟异常事务回滚：`curl http://127.0.0.1:8084/purchase/rollback`

## 本demo参考代码来自以下仓库地址：

* https://github.com/seata/seata-samples
