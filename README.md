
# fox-fw
基于springcloud开发分布式框架（支持oauth2认证授权、sharding-sphere分库分表、常见服务监控、链路监控、异步日志、redis缓存等功能），实现基于fox-vue全家桶等前后端分离项目工程

# 项目特点
* 框架方面独立、模块相互之间非常独立(feign api 独立工程，方便调用)，第三方工程服务能够轻松接入
* 服务通过网关统一接入，鉴权（网关和业务模块权限独立分开）、监控、日志、缓存等统计分析更加清晰
* 采用分布式模式，部署方便，易于扩展
* 采用分布式模式，[docker部署]方便，易于扩展
* 前端基于element ui 、Vue全家桶、React 等主流，实现前后端分离

# 技术模块相关说明
1、 fw-cloud-system 模块
- fw-cloud-system-eureka  [端口1001] 服务注册中心 
- fw-cloud-system-config  [端口1002] 服务配置和发现
- fw-cloud-system-gateway [端口1003] zuul服务网关（外部接口接入入口）
- fw-cloud-system-auth    [端口1004] 权限接入服务(支持oauth2、单点登录) 

2、fw-cloud-core 基础公共模块
- cloud-commons 抽离底层基础部分依赖
- fw-cloud-core-beans 常用全局bean
- fw-cloud-core-commons 常量、切面等
- fw-cloud-core-configuration 基础配置
- fw-cloud-core-exception Exception定义
- fw-cloud-core-utils 常用工具类

3、fw-cloud-business 业务模块服务模块
- fw-cloud-business-commons business各业务公共组件等
- fw-cloud-business-admin      基于hibernate demo
- fw-cloud-business-demo       基于mybatis  demo
- fw-cloud-business-adminitor  中台管理等接口服务控制系统(基于目前硬件条件限制替换下bootstrap.yml/bootstrap.properties线上线下运行和开发)
- fw-cloud-business-sso        单点登录模块接入demo


4、fw-cloud-api 抽离feign api供其它工程调用
- fw-cloud-system-api admin工程相关的feign api

5、系统监控模块
- fw-cloud-monitor-monitor    [端口1010] 服务状态监控[服务在线访问](http://localhost:1010/)
- fw-cloud-monitor-zipkin-db  [端口1011] 数据库db监控[服务在线访问](http://localhost:1011/)
- fw-cloud-monitor-zipkin-elk [端口待定] elk监控
- fw-cloud-system-xxx         [端口待定] 缓存监控
- fw-cloud-system-xxx         [端口待定] 日志等监控
- fw-cloud-system-pinpoint    [端口待定] APM监控

6、中台平台建设
- fw-cloud-midgroud-xxx        待与云栈，业务发展

7、API开放平台建设
- fw-cloud-apicenter-xxx       待与业务发展


# 开发部署环境
- Redis
- MySQL
- RabbitMQ
- Java8
- Lombok
- Feign
- docker
- nginx
- git


 
