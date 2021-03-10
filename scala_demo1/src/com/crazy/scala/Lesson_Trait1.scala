package com.crazy.scala

trait Read{
  def read(name:String)={
    println(s"$name is reading ...")
  }
}
trait Listen{
  def listen(name:String)={
    println(s"$name is listening ...")
  }
}

class Human() extends Read with Listen {

}
object Lesson_Trait1 {
  def main(args: Array[String]): Unit = {
    val p = new Human()
    p.read("zhangsan")
    p.listen("lisi")
  }
}
