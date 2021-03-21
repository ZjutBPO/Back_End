package com.crazy.spark.rdd

import org.apache.spark.{SparkConf, SparkContext}

object WordCount {
  def main(args: Array[String]): Unit = {
    //创建sparkContext
    val conf = new SparkConf().setAppName("w_c")
    val sc = new SparkContext(conf)

    //加载文件
      //准备文件
      //读取文件
      val rdd1 = sc.textFile("hdfs:///data/wc.txt")
    //处理
      //拆分为单词
    val rdd2 = rdd1.flatMap( item => item.split(" "))
      //把每个单词指定一个词频
    val rdd3 = rdd2.map(item => (item, 1))

      //聚合
    val rdd4 = rdd3.reduceByKey((curr, agg) => curr + agg)

    //得到结果
    val result = rdd4.collect()
//    println(result)
    result.foreach(println)
  }
}
