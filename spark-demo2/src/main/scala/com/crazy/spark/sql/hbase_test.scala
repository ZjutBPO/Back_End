package com.crazy.spark.sql

import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

object hbase_test {
  System.setProperty("HADOOP_USER_NAME","root")
  def main(args: Array[String]): Unit = {
    val spark:SparkSession = SparkSession
      .builder()
      .enableHiveSupport()
      .master("local[*]")
      .appName("sql")
      .getOrCreate()

//    val sourceRDD = spark.sparkContext.parallelize()
  }

}
