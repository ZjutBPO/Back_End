package com.crazy.scala

import scala.collection.mutable
import scala.collection.immutable.Set

object Lesson_Set {
  def main(args: Array[String]): Unit = {
    import scala.collection.mutable.Set

    val set = Set[Int](1,2,3)
    set.+=(100)
//    set.foreach(println)
    val set1 = scala.collection.immutable.Set[String]("a","b")
    set1.foreach(println)
//    val ints : mutable.Set[Int] = set.+=(100,101)
//    ints.foreach(println)


    //    val set = Set[Int](1,2,3,3,4,4,5)
//    val set1 = Set[Int](3,4,5,6)

//
//    val ints = set.filter(elem => {
//      elem > 2
//    })
//    ints.foreach(println)
//    val result:Set[Int] = set.intersect(set1)
//    val result1:Set[Int] = set.diff(set1)

//    val result = set &~ set1
//    result.foreach(println)
//    result1.foreach(println)

    //    for(elem<-set){
//      println(elem)
//    }
//    set.foreach(println)
  }

}
