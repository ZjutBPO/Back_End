package com.crazy.scala

import scala.collection.mutable.ArrayBuffer

object Lesson_Array {
  def main(args: Array[String]): Unit = {

    val arr = Array[String]("a","b","c","d")
    val arr1 =ArrayBuffer[Int](1,2,3)
    arr1.+=(4)
    arr1.foreach(println)
    arr1.+=:(100)
    arr1.append(7,8,9)
    arr1.foreach(println)
//    val arr1 = Array[String]("e","f","g")
//    val arrays:Array[String] = Array.fill(5)("hello")
//    arrays.foreach(println)
//    Array.concat()
//    val array = new Array[Array[Int]](3)
//      array(0) = Array[Int](1,2,3)
//      array(1) = Array[Int](4,5,6)
//      array(2) = Array[Int](7,8,9 )
//      array.foreach(arr=>{arr.foreach(println)})
//      for(arr<- array;elem<-arr){
//          println(elem)
//      }
//    val arr1 =new Array[Int](3)
//    arr1(0) = 100
//    arr1(1) = 200
//    arr1(2) = 300
//    arr1.foreach(println)

//    arr.foreach(println)
//    for(elem<-arr)
//      println(elem)
  }
}
