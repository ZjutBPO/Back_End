package com.crazy.scala

import scala.reflect.internal.SymbolTable

/*
* Scala
* 1.Scala object 相当于java的单例，object中定义的全是静态的,对象不能直接传参，要使用apply传参
*2.scala中定义变量使用var ，定义常量使用val
* 3.scala中每行末尾有分号自动判断机制，不用显式写出
* 4.建议scala中命名使用驼峰
* 5.scala类中可以传参，传参一定要指定类型，有了参数就默认有了构造
* 6.类中重写构造 def this(){}
* 7.构造类对象时，类中除了方法不执行，其他都执行
* 8.在同一个scala文件中，class名称和Object名称一样时，这个类叫做对象的伴生类。这个对象叫做类的伴生对象，他们之间可以互相访问私有变量
*
*
* */
class Person(xname:String, xage:Int){
//  var name=xname
//  var age=xage
//  var gender='M'
//  def sayName():Unit ={
//    println("hello "+Lesson_ClassObj.name)
//  }
//  println("**********Person class****************")
//  def this(yname:String, yage:Int,ygneder:Char){
//    this(yname,yage)
//    this.gender=ygneder
//  }
//  println("*========*Person class****************")

}
object Lesson_ClassObj {
//  val name="wangwu"
//  def apply(i:Int):Unit={
//    println("Score is "+i)
//  }
  def main(args: Array[String]):Unit = {




    /*
    * while
    * do... while
    * */
//    var i = 0
//    while(i<100){
//      i += 1
//      println(s"the $i")
//    }
//    do{
//      println(s"the $i")
//      i += 1
//    }while(i<100)
    /*
    *  for()
    * */

//    val r = 1 to 10
//    println(r)
//    val r1 = 1 until 10
//    println(r1)
//    for(i<- 1 to 10){
//      println(i)
//    }
  //小九九
//    for(i <- 1 until 10){
//      for(j <- 1 until 10){
//        if(i>=j){
//          print(s"$i * $j = "+i*j+"\t")
//        }
//        if(i == j )
//          println()
//      }
//    }
//    val vec = for(i <- 1 to 100 if(i>60) if(i%2==0)) yield i
//    println(vec)
    /*
    * if...else...
    * */
//    val age = 20
//    if(age<=20){
//      println("age <= 20")
//    }else if(age>20 && age<=30){
//      println("20<age<=30")
//    }else{
//      println("age>30")
//    }

//    Lesson_ClassObj(1000)
//    val p = new Person("zhangsan",20)
//    println(p.gender)
//    val p1 = new Person("wangwu",30,'F')
//    println(p1.gender)
//    p.age=200
//    println(p.name)
//    println(p.age)
//    p.sayName()
  }
}
