# Spark

主要用于数据计算，基于内存计算

#### spark内置模块

![spark内置模块](C:\Users\starry\Desktop\spark内置模块.png)

Spark Core 中提供了 Spark 最基础与最核心的功能，Spark 其他的功能都是在 Spark Core 的基础上进行扩展的。

Spark SQL 是 Spark 用来操作结构化数据的组件，可以使用 SQL或者 Apache Hive 版本的 SQL 方言（HQL）来查询数据。

Spark Streaming 是 Spark 平台上针对实时数据进行流式计算的组件，提供了丰富的处理数据流的 API。 

Spark MLlib 是 Spark 提供的一个机器学习算法库，提供了模型评估、数据导入和一些更底层的机器学习原语。

Spark GraphX 是 Spark 面向图计算提供的框架与算法库。

#### 搭建环境

1、创建一个Maven项目spark

（1）删除项目spark的src

（2）右键spark->New->Module  spark-core

2、下载scala

File->Settings->Plugins

![image-20210207093414490](C:\Users\starry\Desktop\scala-1.png)

添加sdk

File->Project Structure->Global Libraries

![image-20210207093715828](C:\Users\starry\Desktop\scala-2.png)

3、测试环境

spark-core->src->main->java

![image-20210207095007210](C:\Users\starry\Desktop\test-1.png)

![image-20210207095037894](C:\Users\starry\Desktop\test-2.png)

可以输出 Hello Spark证明搭建成功