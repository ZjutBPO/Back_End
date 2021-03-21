package com.crazy.bigdata.spark.core.wc

import org.apache.spark.{SparkConf, SparkContext}

object spark01_WordCount {
  def main(args: Array[String]): Unit = {
    //建立和spark框架的连接
    val sparkConf = new SparkConf().setMaster("192.168.1.101").setAppName("WordCount")

    val sc = new SparkContext(sparkConf)

    //执行业务操作

    //关闭连接
    sc.stop()
  }
}
