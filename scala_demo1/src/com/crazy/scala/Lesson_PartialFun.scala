package com.crazy.scala

object Lesson_PartialFun {
  def MyTest:PartialFunction[String,Int]={
    case "abc"=>2
    case "a"=>1
    case _=>200
  }
  def main(args: Array[String]): Unit = {
    val result: Int = MyTest("abc ")
    println(result)
  }

}
