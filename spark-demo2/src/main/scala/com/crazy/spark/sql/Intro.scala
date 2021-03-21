package com.crazy.spark.sql

import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}
import org.junit.Test

class Intro {
  @Test
  def rddInfo():Unit={
    val conf = new SparkConf().setMaster("local[6]").setAppName("rdd intro")
    val sc = new SparkContext(conf)
    sc.textFile("dataset/wordcount.txt")
      .flatMap(_.split(" "))
      .map((_,1))
      .reduceByKey(_ + _)
      .collect()
      .foreach(println)
  }



  @Test
  def dsIntro():Unit={
    val spark = new SparkSession.Builder()
      .appName("ds intro")
      .master("local[6]")
      .getOrCreate()

    import spark.implicits._
    val sourceRDD = spark.sparkContext.parallelize(Seq(Person("zhangsan", 10), Person("lisi", 15)))

    val personRS = sourceRDD.toDS()

    val resultRS = personRS.where('age > 10)
      .where('age < 20)
      .select('name)
      .as[String]
    resultRS.show()



  }
  @Test
  def dfIntro():Unit={
    val spark = new SparkSession.Builder()
      .appName("ds intro")
      .master("local[6]")
      .getOrCreate()

    import spark.implicits._
    val sourceRDD = spark.sparkContext.parallelize(Seq(Person("zhangsan", 10), Person("lisi", 15)))
    val df = sourceRDD.toDF()
    df.createOrReplaceTempView("person")
    val resultDf = spark.sql("select name from person where age > 9 and age <15")
    resultDf.show()
  }
}

case class Person(name:String,age: Int)
