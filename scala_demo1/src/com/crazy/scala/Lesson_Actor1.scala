package com.crazy.scala

import scala.actors.Actor

class MyActor extends Actor{
  override def act()={
    receive{
      case s:String=>{println(s"type is String,value = $s")}
      case _=>{println("no match ")}
    }
  }
}


object Lesson_Actor1 {
  def main(args: Array[String]): Unit = {
    val actor = new MyActor
    actor.start()

    actor ! "11"
  }

}
