package com.crazy.scala

import sun.rmi.runtime.Log

import java.util.Date

object Lesson_Function {
  def main(args: Array[String])={
//    def max(a:Int,b:Int)={
//      if (a>b) a else b
//    }
//    println(max(1,2))


    /*
    * 递归
    * */
//    def  fun(num:Int):Int={
//      if (num==1) 1 else num*fun(num-1)
//    }
//    println(fun(5))
    /*
    * 参数有默认值的方法
    * */
//    def fun(a:Int=10,b:Int=20)={
//      a+b
//    }
//    println(fun(200))


    /*
    * 可变长参数的方法
    * */
//    def fun(s:String*)={
//      println(s)
//      for(elem<-s)
//        println(elem)
//    }
//    fun("hello","a","b")
    /*
    * 匿名函数
    *
    * */
//    def fun=(a:Int,b:Int)=>{
//      a+b
//    }
//    println(fun(100,200))
//    var fun1:String => Unit = (s:String) =>{
//      println(s)
//    }
//    fun1("hello")
    /*
    *
    * 嵌套方法
    * */
//    def fun(num:Int)= {
//      def fun1(a:Int):Int={
//        if(a==1) 1 else a*fun1(a-1)
//      }
//      fun1(num)
//    }
//    println(fun(5))

    /*
    * 偏应用函数
    * */
//    def showLog(date:Date,log: String): Unit ={
//      println(s"date is $date , log is = $log")
//    }
//    val date = new Date()
//    showLog(date,"a")
//
//    def fun=showLog(date,_:String)
//    fun("aaa")
//    fun("bbb")
//    fun("ccc")


    /*
    * 高阶函数
    *   1)方法的参数是函数
    *   2）方法的返回是函数 必须显示返回函数类型
    *   3）方法的参数和返回都是函数
    * */
//    def fun(a:Int,b:Int):Int={
//      a+b
//    }
//    def fun1(f:(Int,Int)=>Int,s:String):String = {
//      val i:Int = f(100,200)
//      i+"#"+s
//    }
//
//    val result = fun1((a1:Int,b1:Int)=>{a1*b1},"scala")
//    println(result)
//    def fun(s:String)={
//      def fun1(s1:String,s2:String):String={
//        s1+"~"+s2+"#"+s
//      }
//      fun1 _
//    }
//    println(fun("a")("b","c"))
//    def fun(f:(Int,Int)=>Int):(String,String)=>String={
//      val i:Int = f(1,2)
//      def fun1(s1:String,s2:String):String={
//        s1+"@"+s2+"*"+i
//      }
//      fun1
//    }
//    print(fun((a,b)=>{a+b})("hello","18"))

    /*
    * 柯里化函数
    * */
//    def fun(a:Int,b:Int)(c:Int,d:Int)={
//      a+b+c+d
//    }
//    print(fun(1,2)(3,4))

  }

}
