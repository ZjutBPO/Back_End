package com.crazy.structured

import org.apache.spark.sql.streaming.OutputMode
import org.apache.spark.sql.{Dataset, SparkSession}

object SocketWordCount {
  def main(args: Array[String]): Unit = {
    //创建sparksession
    val spark = SparkSession.builder()
      .master("local[6]")
      .appName("socket_structured")
      .getOrCreate()

    spark.sparkContext.setLogLevel("WARN")
    import spark.implicits._
    //数据集的生成，数据读取
    val source = spark.readStream
      .format("socket")
      .option("host", "192.168.1.101")
      .option("port", 9999)
      .load()

    val sourceDS:Dataset[String] = source.as[String]
    //数据的处理
    val word = sourceDS.flatMap(_.split(" "))
      .map((_, 1))
      .groupByKey(_._1)
      .count()
    //数据集的生成和输出
    word.writeStream
      .outputMode(OutputMode.Complete())
      .format("console")
      .start()
      .awaitTermination()
  }
}
