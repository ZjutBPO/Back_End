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

​	$@表述命令行中所有参数，分开看待各个参数

**特殊变量$?**



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

