package com.crazy.structured

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.streaming.OutputMode
import org.apache.spark.sql.types.StructType

object HDFSSource {
  def main(args: Array[String]): Unit = {
    //创建sparksession
    val spark = SparkSession.builder()
      .appName("hdfs_source")
      .master("local[6]")
      .getOrCreate()
    spark.sparkContext.setLogLevel("WARN")
    //数据获取，目录必须是一个文件夹
    val schema = new StructType()
      .add("name","string")
      .add("age","integer")
    val source = spark.readStream
      .schema(schema)
      .json("hdfs://hadoop101:9000/dataset/dataset1")

    //输出结果
    source.writeStream
      .outputMode(OutputMode.Append())
      .format("console")
      .start()
      .awaitTermination()
  }

}
