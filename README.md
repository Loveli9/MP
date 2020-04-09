
## 技术栈

需要`Java 8`环境，推荐使用`IDEA`作为开发工具，所用到的技术：

1. Spring Boot v2.2.0
2. MySQL5.7
3. Spring Security
4. Spring Quartz
5. mybatis、mybatisPlus
6. redis缓存
7. 前端：Freemark、Bootstrap、Vue
8. Activiti v5.22

**技术可能未列举完**

## 部署

mp是使用`Maven`构建的多模块项目，分模块开发，各模块可插拔。`mp-web`项目是mp的主入口，在`mp-web`的`pom`文件中引入需要的模块之后，通过以下步骤来启动项目：
- 导入数据库
  在项目的`db`文件夹下有数据库脚本，首先导入数据。
- 启动`redis`服务
  本地安装`redis`或者其他远程`redis`。
- 修改相关配置
  修改`web`下`application-dev.yml`中的配置：
  1. 数据库相关配置
  2. `redis`相关配置
- 启动项目
  启动`web`工程下的`WebApplication`。

## 开发
开发上mp做了一些限制，或者叫约定：
1. 编码约定
Web系统分为`controller`、`service`、`dao`层。
`controller`主要负责转发、`service`主要负责业务逻辑、`dao`主要是数据库的操作。
2. `controller`、`service`、`dao`方法名称约定
   - 如果是增加数据操作用`insert`做前缀。
   - 如果是删除操作用`delete`做前缀
   - 如果是修改操作用`update`做前缀
   - 如果是查询操作用`select`做前缀
若是要新建模块开发，可以按照以下步骤进行：
1. new Module 
2. GroupId --->com.pms 
3. ArtifactId---> pms-模块名称   如  pms-common
4. Version --> 版本号   如 1.0SNAPSHOT 
5. Module-Name--> pms-模块名称   如  pms-javacore 
6. 提交新建模块 
7. pom 文件引入

   ```xml
   <name>pms-模块名称</name>
       <dependencies>
           <dependency>
               <groupId>com.pms</groupId>
               <artifactId>pms-common</artifactId>
           </dependency>
           .
           .其他的依赖
           .
       </dependencies>
       <build>
           <plugins>
               <plugin>
                   <groupId>org.apache.maven.plugins</groupId>
                   <artifactId>maven-compiler-plugin</artifactId>
                   <version>3.6.1</version>
                   <configuration>
                       <source>1.8</source>
                       <target>1.8</target>
                       <encoding>UTF-8</encoding>
                       <compilerArgs>
                           <arg>-parameters</arg>
                       </compilerArgs>
                       <useIncrementalCompilation>false</useIncrementalCompilation>
                   </configuration>
               </plugin>
           </plugins>
       </build>
   ```

新建完成模块之后需要继续功能性开发，可按照以下步骤：
1. 创建数据库
2. 创建`entity`类
3. 创建`service`类
4. 创建`controller`类
5. 创建列表界面
