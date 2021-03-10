package com.crazy.scala

import scala.actors.Actor

case class Msg(actor:Actor,message:String)
class Myactor1 extends Actor{
  override def act()={
    while(true){
      receive{
        case msg:Msg=>{
          if("hello".equals(msg.message)) {
            println(s"type is String ,value = ${msg.message}")
            msg.actor ! Msg(this,"hello")
          }
        }
        case _=>{"no match"}
      }
    }
  }
}
class Myactor2(act:Actor) extends Actor{
  act ! Msg(this,"hello")
  override def act()={
     while(true){
       receive{
         case s:String=>{println(s"type is String ,value = $s")}
         case msg:Msg=>{
           if("hello".equals(msg.message)) {
             println(s"type is String ,value = ${msg.message}")
             msg.actor ! "hi "
           }
         }
         case _=>{"no match"}
       }
     }
  }
}
object Lesson_Actor2 {
  def main(args: Array[String]): Unit = {
    val ac1 = new Myactor1()
    val ac2 = new Myactor2(ac1)
    ac1.start()
    ac2.start()
  }

}
