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

#### 加入jar依赖
* 在父工程项目中整合SpringBoot的依赖管理
修改父工程 `pom.xml`文件，新增 `springboot parent`，代码如下
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.wip.kyriecao</groupId>
    <artifactId>springboot-api-mult-modular</artifactId>
    <packaging>pom</packaging>
    <version>1.0-SNAPSHOT</version>

    <!--新增-->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.0.3.RELEASE</version>
    </parent>

    <!--子模块-->
    <modules>
        <module>project-front</module>
        <module>project-service</module>
        <module>project-dao</module>
        <module>project-core</module>
        <module>project-admin</module>
    </modules>
</project>
```
###### 说明
`springboot parent` 对构建SpringBoot工程spring系列和一些常用的第三方包进行了管理。我们只需要将其作为parent即可不用指定版本号来引入spring和已经加入管理的第三方包，SpringBoot这么做，也是为了解决每三方包之间的版本冲突问题。

* **给`project-front`工程添加spring依赖**

修改`project-front/pon.xml`,增加 `spring web starter`、`project-core`和`project-service`工程的依赖。代码如下
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>springboot-api-mult-modular</artifactId>
        <groupId>com.wip.kyriecao</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>project-front</artifactId>
    <!-- 打包方式为 jar包 -->
    <packaging>jar</packaging>

    <dependencies>
        <!-- SpringBoot web starter -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <!--依赖 project-core -->
        <dependency>
            <groupId>com.wip.kyriecao</groupId>
            <artifactId>project-core</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>

        <!--依赖 project-service -->
        <dependency>
            <groupId>com.wip.kyriecao</groupId>
            <artifactId>project-service</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
    </dependencies>
</project>
```
###### 说明
因为这是一个web工程，所以需要增加`web starter` 的依赖，web starter引入了构建一个web工程的jar包。

* **给`project-admin`工程添加spring依赖**，同`project-front`一样。
* **给`project-service`工程添加`spring-context`和`project-dao`工程的依赖包**。

修改`project-service/pom.xml`文件，如下
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>springboot-api-mult-modular</artifactId>
        <groupId>com.wip.kyriecao</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>project-service</artifactId>

    <dependencies>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <scope>provided</scope>
        </dependency>

        <!--依赖 project-dao 数据持久层-->
        <dependency>
            <groupId>com.wip.kyriecao</groupId>
            <artifactId>project-dao</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        
    </dependencies>
</project>
```
###### 说明
这里的`spring-context`包的`scope`为`provided`，因为这个包在front的`springboot web starter`中已经被引入了。
我们之所以需要引入这个包，是因为我们需要使用@Service、@Autowired等Spring提供的注解。如果你还需要用到别的第三方包，也可以直接引入。
