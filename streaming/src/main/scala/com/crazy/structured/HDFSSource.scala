package com.crazy.structured

import org.apache.spark.sql.SparkSession

class HDFSSource {
  def main(args: Array[String]): Unit = {
    //创建sparksession
    val spark = SparkSession.builder()
      .appName("hdfs_source")
      .master("local[6]")
      .getOrCreate()

    //数据获取，目录必须是一个文件夹
    val source = spark.readStream
      .json("hdfs://hadoop101:9000/dataset")
  }

}
