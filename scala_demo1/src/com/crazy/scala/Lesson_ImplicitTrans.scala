package com.crazy.scala

object Lesson_ImplicitTrans {
//  def sayName(implicit name:String)={
//    println(s"$name is a studnet ....")
//  }
  def sayName(age:Int)(implicit name:String)={
    println(s"$name is a studnet .... $age")
  }
  def main(args: Array[String]): Unit = {
    implicit  val name:String="zhangsan"
    sayName(100)
  }
}
