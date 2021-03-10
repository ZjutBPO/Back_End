package com.crazy.scala

import scala.collection.mutable.ListBuffer

object Lesson_List {
  def main(args: Array[String]): Unit = {

    val list = ListBuffer[Int](1,2,3)
    list.append(4,5,6)
    list.+=:(110)
    list.foreach(println)
//    val list = List(1,2,3)
//    list.foreach(println)
//    val list = List[String]("hello scala","hello Java","hello spark"," a","b")
//
//    val strings = list.filter(s => {
//      "hello scala".equals(s)
//    })
//    val i = list.count(s => {
//      s.length < 3
//    })
//    println(i)
//    strings.foreach(println)

//    val result:List[Array[String]] = list.map(s => {
//      s.split(" ")
//    })

//    val result1 = list.flatMap(s => {
//      s.split(" ")
//    })
//    result1.foreach(println)
//    result.foreach(arr=>{
//      println("新的数组")
//      arr.foreach(println)
//    })


//    println(result)
  }
}
