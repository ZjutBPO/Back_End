# Shell

sudo cat /etc/shells 可以看见六种shell解析器

/bin/sh

/bin/bash

/bin/nologin

/bin/dash

/bin/tcsh

/bin/csh  

ubuntu系统默认的解析器是/bin/bash



**Shell脚本入门**

​	#!/bin/bash开头（指定解析器）

​	echo “helloworld” **输出**

​	

# Hbase

## HBase数据模型

​	数据存储在一张表中，有行列，HBase的底层物理存储结构是K-V模式，更像一个多维Map

![屏幕截图 2021-02-06 114020](Hbase.assets/屏幕截图 2021-02-06 114020.png)

Row Key按照字典序排列

**Region**横向切片  

**Store**存储数据块的部分

纵向切分出的是不同的列族，横向切分出的是表的切片内容

**物理存储结构**

![image-20210206114530625](Hbase.assets/image-20210206114530625.png)

注意：TimeStamp时间戳部分，windows和linux时间不同步会导致数据操作出现问题

正常状态的数据标记为put，而面对时间戳更大的Delete类型，则该行早于delete状态时间的数据都不返回数据

数据模型

## HBase部署安装 

