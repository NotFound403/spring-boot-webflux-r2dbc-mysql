## 1. 前言

在一篇中初步介绍了**r2dbc-mysql**的使用。但是借助于`DatabaseClient`操作过于初级和底层，不利于开发。今天就利用**Spring Data R2DBC**来演示**Spring 数据存储抽象（Spring Data Repository）**风格的**R2DBC**数据库操作。

> **请注意**：目前**Spring Data R2DBC**虽然已经迭代了多个正式版，但是仍然处于初级阶段，还不足以运用到生产中。不过未来可期，值得研究学习。

## 2. Spring Data R2DBC

**Spring Data R2DBC**提供了基于[R2DBC](https://r2dbc.io/)反应式关系数据库驱动程序的流行的**Repository**抽象。但是这并不是一个ORM框架，你可以把它看做一个数据库访问的抽象层或者**R2DBC**的客户端程序。它不提供**ORM**框架具有的缓存、懒加载等诸多特性，但它抽象了数据库和对象的抽象映射关系，具有轻量级、易用性的特点。

### 2.1 版本对应关系

胖哥总结了截至目前**Spring Data R2DBC**和**Spring Framework**的版本对应关系：

| Spring Data R2DBC | Spring Framework |
| ----------------- | ---------------- |
| 1.0.0.RELEASE     | 5.2.2.RELEASE    |
| 1.1.0.RELEASE     | 5.2.6.RELEASE    |
| 1.1.1.RELEASE     | 5.2.7.RELEASE    |
| 1.1.2.RELEASE     | 5.2.8.RELEASE    |

一定要注意版本对应关系，避免不兼容的情况。

## 3. 基础依赖



```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-r2dbc</artifactId>
</dependency>
<!--r2dbc mysql 库-->
<dependency>
    <groupId>dev.miku</groupId>
    <artifactId>r2dbc-mysql</artifactId>
</dependency>
<!--自动配置需要引入的一个嵌入式数据库类型对象-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jdbc</artifactId>
</dependency>
```