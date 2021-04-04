package com.crazy.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark._
object Mysql_trying {
  def main(args: Array[String]): Unit = {
    val conf:SparkConf=new SparkConf().setMaster("local[*]").setAppName("sparksql_mysql")

    val sparkSession:SparkSession = SparkSession.builder().config(conf).getOrCreate()

    val df = sparkSession.read.format("jdbc")
      .option("url", "jdbc:mysql://localhost:3306/bpo3?serverTimezone=UTC")
      .option("driver", "com.mysql.cj.jdbc.Driver")
      .option("user", "root")
      .option("password", "123456")
      .option("dbtable", "total2")
      .load()
    df.createGlobalTempView("total")
    val time_span = 10
    val start_time = 1577808000
    val time_period = 600
    sparkSession.sql(s"select count(*) from global_temp.total where unix_timestamp(InTime,'yyyy-MM-dd HH:mm:ss') < ${start_time} and unix_timestamp(InTime,'yyyy-MM-dd HH:mm:ss') < ${start_time+time_period}").show()

    //save the data

  }

}
