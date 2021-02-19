# Shell

sudo cat /etc/shells 可以看见六种shell解析器

/bin/sh

/bin/bash

/bin/nologin

/bin/dash

/bin/tcsh

/bin/csh  

ubuntu系统默认的解析器是/bin/bash



## **Shell脚本入门**

​	#!/bin/bash开头（指定解析器）

​	echo “helloworld” **输出**

**VIM编辑** 

vim 文件名进入编辑	遇到读写问题可以直接加sudo

按 i 或 | 进入编辑模式，按esc退出编辑模式，进入命令行模式

**VIM保存**

命令行模式中输入：wq！，基本上万能，w表示write，q表示quit退出vim编辑器

多命令处理

**创建脚本，写入文件**

创建shell脚本touch xxx.sh

在shell脚本中编辑（解释器，内容，shell命令写入也是用 >> 形如 echo ”XXX“ >> xx.txt）

外部运行

## shell变量

​	set命令查看所有变量

**系统变量**

​	$HOME $PWD $SHELL $USER等

**自定义变量**

​	变量名 = 值    且**等号左右不能有空格**

​	unset删除变量

​	只读变量 加前缀readonly（不可unset删除）

​	环境变量建议**大写**

​	bash解释器中的变量默认为字符串，无法直接**数值运算**

​	带空格的字符串要用单/双引号括起来

**特殊变量$n**

​	n表示数字，类似C#输入多个变量的{1}{2}，$0表示文件名本身，后续是自命名的

**特殊变量$#**

​	获取所有输入参数的个数（因为0是文件名，所以输入参数个数是从1开始算的）

**特殊变量$*、$@**

​	$*表示命令行中所有参数，并且看作整体（自定义的）

​	$@表示命令行中所有参数，分开看待各个参数

**特殊变量$?**

​	$?表示最后一次执行的命令的返回状态，变量为0表示正确

## 运算符

**基本语法**

​	$((运算式)) 或$[运算式]

​	expr x op y（要加空格）

​	expr 运算也可以嵌套实现，用``包含

## 条件判断

**基本语法**

​	[ condition ] (条件两边要留空格)

​	**多条件判断**： &&表示前一条执行成功则执行后一条，|| 表示前一条执行失败则执行下一条

## 流程控制

**基本语法**

​	if [ 条件判断式 ]；then 程序 fi

​	if [ 条件判断式 ] 

​		then

​			程序

​	fi

​	if和[之间有空格

​	**case语句**

​	case $变量名 in

​		值1）

​			程序

​		；；

​		值2）

​			程序

​		；；

​	...

​	esac

​	**for语句**

​	for((；；))

​		do

​			程序

​		done

​	**while循环**

​	while [ 条件判断式 ]

​		do

​			程序

​		done

​	**read读取控制台输入**

​	read(选项)(参数)

​	选项：

​		-p：指定读取值时的提示符

​		-t：指定读取值时等待的时间

​		参数

​			变量：指定读取值的变量名

## 函数

​	**系统函数**

​	basename基本语法

​	basename[string/pathname] [suffix]

​	pathname是文件名，是basename截取的内容，如果后面还指定了suffix后缀，那么basename会讲后缀也去掉

​	![image-20210213001338466](Hbase.assets/image-20210213001338466.png)

​	dirname基本语法

​		获取文件绝对路径

​		![image-20210213001513479](image-20210213001513479.png)

​	**自定义函数**

​	[ function ] funname[()]

​	{

​		Action；

​		[return int;]

​	}

​	funname

![image-20210213002406383](Hbase.assets/image-20210213002406383.png)

## Shell工具

### cut

​	剪切数据

​	基本用法：cut[选项参数]	filename

​	默认用tab分隔

​	选项参数 -f 列号，提取第几列 -d 分隔符，按照指定分隔符分割列

​	截取ip地址

![image-20210213010236752](Hbase.assets/image-20210213010236752.png)

### sed

​	**基本用法**

​	sed[选项参数] ‘command’	filename

​	参数 -e 直接在指令列模式上进行sed动作编辑

​	command中有

​	a 新增

​	d 删除

​	s 查找并替换（/符号后加g表示global全局替换）

### awk

​	**基本用法**

​	awk[选项参数] ‘pattern{action1} pattern2{action2}...’	filename

​	pattern awk在数据中查找的内容，是匹配模式

​	选项参数

​	-F 指定输入文件折分隔符

​	-v 赋值一个用户定义变量

​	**内置变量**

​	FILENAME 文件名

​	NR 已读的记录数

​	NF 浏览记录的域的个数

### sort

sort(选项)(参数)

选项

-n 按照数值大小排序

-r 相反的顺序排序

-t 设置分隔符

-k 指定需要排序的列

# Hadoop

​	**优势**

​		高可靠性

​		高扩展性

​		高效性

​		高容错性

​	**组成**

​		MapReduce 计算

​		Yarn资源调度

​		HDFS数字存储

​		Common 辅助工具

​	**HDFS架构概述**

​		NameNode（nn）存储文件的元数据，文件目录

​		DataNode 本地文件系统存储文件块数据和快数据的校验和

​		Secondary NameNode 用来监控HDFS状态的辅助后台程序

​	**YARN架构概述**

​		ResourceManager用于处理客户端请求，监控NodeManager，启动或监控	ApplicationMaster，资源分配与调度

​		NodeManager用于管理节点上的资源，处理来自RM的命令。处理来自AM的命令
​		ApplicationMaster负责数据的切分，为应用程序申请资源并分配给内部的任务，任务的监控与容错

​		Container分装了某节点上的多维度资源如内存、cpu、磁盘、网络

​	**MapReduce架构概述**

​		将计算过程分为Map和Reduce

​		Map并行处理输入数据

​		Reduce对Map结果进行汇总

## 运行环境搭建

​	https://blog.csdn.net/yps_leaf/article/details/104467624/

## Hadoop目录

​	**bin**存放hadoop相关服务进行操作的脚本

​	**etc**存放hadoop的配置文件

​	**lib**存放hadoop本地库，可以进行压缩解压功能

​	**sbin**存放启动和停止hadoop相关服务的脚本

​	**share**存放依赖jar包、文档、官方案例

## hadoop运行模式

​	有本地模式、伪分布式、完全分布式模式

### 伪分布式

1. ​	启动HDFS运行MapReduce，测试集群增、删、查，运行wordcount测试

​	集群增删查：

​		启动集群后启动namenode和datanode

​		可以在web端查看hdfs文件系统（http://hadoop101:50070/dfshealth.html#tab-overview）

​		创建文件夹input 在hadoop文件目录下输入命令bin/hafs dfs -mkdir -p /user/ub1/input

​		上传文件命令 bin/hdfs dfs -put **wcinput/wc.input**

[^wcinput/wc.input是本地文件夹的文件]: 

 /user/ub1/input

​		运行wordcount程序测试bin/hadoop jar share/hadoop/mapreduce/hadoop-mapreduce-examples-2.7.5.jar wordcount    /user/ub1/input/    /user/ub1/output

​	

​	2.	启动yarn运行MapReduce，测试集群增删查，运行wordcount测试

​	配置完环境之后，启动了namenode和datanode的前提下启动ResourceManager和NodeManager(sbin/yarn0daemon.sh start resource/nodemanager)

​	执行MapReduce如1hdfs中的操作

​	查看结果bin/hdfs dfs -cat /user/ub1/output/*

 3. 配置历史服务器

    配置mapred-site.xml(位于etc)

    启动(sbin/mr0jobhistory-daemon.sh start historyserver)

 4. 配置日志的聚集

    **日志聚集**的概念：应用运行完成后，将程序运行日志信息上传到HDFS系统上，以便方便的查看到程序运行详情

    查看地址(hadoop101:19888/jobhistory)

​	为分布式应用提供协调服务	

​	

# Hbase

## HBase数据模型

​	数据存储在一张表中，有行列，HBase的底层物理存储结构是K-V模式，更像一个多维Map

![屏幕截图 2021-02-06 114020](Hbase.assets/屏幕截图 2021-02-06 114020.png)

Row Key按照字典序排列



**Store**存储数据块的部分

纵向切分出的是不同的列族，横向切分出的是表的切片内容

### **物理存储结构**

![image-20210206114530625](Hbase.assets/image-20210206114530625.png)

注意：TimeStamp时间戳部分，windows和linux时间不同步会导致数据操作出现问题

正常状态的数据标记为put，而面对时间戳更大的Delete类型，则该行早于delete状态时间的数据都不返回数据

### **数据模型**

**Name Space**

​	命名空间，类似普通数据库database概念，每个命名空间下有多个表，Hbase下有两个自带的命名空间hbase和default，hbase存放HBase内置的表，default表是用户默认使用的命名空间

**Region**横向切片  

​	类似普通数据库表的概念，但是HBase定义表时只需要声明列族，不需要声明列，说明字段可以动态、按需指定。

**Row**
	每行数据又一个RowKey和多个Column列组成，数据按照RowKey字典序存储，并且查询数据时只能根据RowKey进行检索

**Column**

​	HBase中的每个列都是列族（column family）和列限定符（column qualifier）进行限定，建表时只需要实现定义列族

**Time Stamp**

​	用来标识数据的不同版本（version），数据写入的时候如果不指定时间戳，会自动为其加上该字段，自动填充当前时间

**Cell**

​	由{rowkey，column family：column qualifier ,timestamp}唯一确定的一个单元，cell中的数据是没有类型的，由字节码形式存贮

### HBase基本架构

**RegionServer作用**

Data:get,put(add&&modify）,delete

Region：splitRegion（切分表），compactRegion（合并表）

**Master Zookeeper**

zookeeper帮助Master管理

Master管理表结构ddl，zookeeper管理dml

**Table**：create,delete,alter

**RegionServer**:分配到regions到每个RegionServer，监控每个RS的状态，底层对数据的增删改查，master是管理高层级的增删改查（表）

多个master，源数据由中间件保存

![image-20210214152711926](Hbase.assets/image-20210214152711926.png)



## HBase部署安装 （伪分布式）

学习阶段是在win10下的linux子系统安装

准备环境：java，hadoop

第一步，hbase安装包下载（http://hbase.apache.org/）

