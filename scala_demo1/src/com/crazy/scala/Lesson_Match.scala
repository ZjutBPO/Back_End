package com.crazy.scala

object Lesson_Match {
  def main(args: Array[String]): Unit = {
    val tp = (1,1.2,"abc",'a',true)
    val iter: Iterator[Any] = tp.productIterator
    iter.foreach(matchTest)
  }
  def matchTest(o:Any)=
    o match {
      case 1 => println("value is 1")
      case i: Int => println(s"value is int,value = $i")
      case d: Double => println(s"value is double,value = $d")
      case s: String => println(s"value is double,value = $s")
      case 'c' => println("value is c")
      case _ => {println("no match...")}
    }
}
