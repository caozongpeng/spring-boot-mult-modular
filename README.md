## 项目介绍
SpringBoot API Mult Modular 是一个基于SpringBoot & Mybatis构建的一个多模块种子项目，用于快速构建中小型API、RESTful API项目。根据不同的代码进行分层，可以很好的管理代码和维护。

#### 具体模块
该项目主要分为五大模块分别为
* **project-admin** 项目后台模块
* **project-front** 项目前台模块
* **project-core** 项目核心模块
* **project-dao** 数据持久层
* **project-service** 服务层

模块之间依赖关系
project-admin 依赖于`project-service`、`project-core`模块。
project-front 依赖于`project-service`、`project-core`模块。
project-service 依赖于 `project-dao`模块。


