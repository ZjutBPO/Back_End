package com.crazy.streaming

import org.apache.spark.SparkConf
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.{Seconds, StreamingContext}

object StreamingWordCount {

  def main(args: Array[String]): Unit = {
    //初始化环境
    val sparkConf = new SparkConf().setAppName("streaming w c").setMaster("local[6]")
    val ssc = new StreamingContext(sparkConf,Seconds(5))
    ssc.sparkContext.setLogLevel("WARN")
    val lines = ssc.socketTextStream(
      hostname = "192.168.1.101",
      port = 9999,
      storageLevel = StorageLevel.MEMORY_AND_DISK_SER
    )
    //数据的处理
      //1.把句子拆为单词
    val words = lines.flatMap(_.split(" "))
      //2.转换单词
    val tuples = words.map((_,1))
      //3.词频reduce
    val counts = tuples.reduceByKey(_ + _)
    //展示和启动
    counts.print()
    ssc.start()

    //main 方法执行结束后会退出，需要阻塞主线程
    ssc.awaitTermination()
  }
}
