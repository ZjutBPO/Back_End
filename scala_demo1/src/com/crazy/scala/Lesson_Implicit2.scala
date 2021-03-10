package com.crazy.scala


class Animal(name:String){
  def canFly()={
    println(s"$name can fly ....")
  }
}
class Rabbit(xname:String){
    val name = xname
}
object Lesson_Implicit2 {
  implicit def RabbitToAnimal(r:Rabbit):Animal = {
    new Animal(r.name)
  }
  def main(args: Array[String]): Unit = {
    val rabbit = new Rabbit("rabbit")
    rabbit.canFly()
  }
}
