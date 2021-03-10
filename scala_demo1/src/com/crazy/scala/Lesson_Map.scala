package com.crazy.scala

import scala.collection.mutable

object Lesson_Map {
  def main(args: Array[String]): Unit = {

    val tuple1: Tuple1[String] = new Tuple1[String]("hello")
    val tuple2: (String,Int) = new Tuple2("1", 100)
    val tuple3: (Int,Boolean,Char) = new Tuple3(1,true,'C')
    val tuple4: (Int, Double, String, Boolean) = Tuple4(1, 3.4, "abc", false)

    println(tuple2.swap)
//    val iter: Iterator[Any] = tuple4.productIterator
//    iter.foreach(println)
//    while(iter.hasNext){
//      println(iter.next())
//    }

//    import scala.collection.mutable.Map
//    val map = Map[String,Int]()
//    map.put("a",100)
//    map.put("b",200)
//    map.put("c",300)
//    map.foreach(println)
//    val result:mutable.Map[String,Int] = map.filter(tp => {
//      val key = tp._1
//      val value = tp._2
//      value == 200
//    })
//    result.foreach(println)




//    val map1 = Map[String,Int](("a",1),("b",2),("c",3),("d",4))
//    val map2 = Map[String,Int](("a",100),("b",200),("c",300),("e",500))
//    val result:Map[String,Int] = map1.++(map2)
//    result.foreach(println)
//    val map = Map[String,Int]("a"->100,"b"->200,("c",300),("c",400))



//
//    val values:Iterable[Int] = map.values
//    values.foreach(println)
//    val keys:Iterable[String] = map.keys
//    keys.foreach(key=>{
//      val value = map.get(key).get
//      println(s"key = $key, value = $value")
//    })
//    val option:Option[Int] = map.get("a")
//    val value:Int= map.get("aa").getOrElse(555)
//    println(value)
//    for(elem<-map)
//      println(elem)
//

//    println(map)
  }
}
