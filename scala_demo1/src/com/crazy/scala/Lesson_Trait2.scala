package com.crazy.scala


trait isEquale{
  def isEqu(o:Any):Boolean
  def isNotEqu(o:Any):Boolean={
    !isEqu(o)
  }
}
class Point(xx:Int,xy:Int) extends isEquale {
  val x = xx
  val y = xy

  override def isEqu(o: Any): Boolean = {
    o.isInstanceOf[Point]&&o.asInstanceOf[Point].x==this.x&&o.asInstanceOf[Point].y==y
  }
}
object Lesson_Trait2 {

  def main(args: Array[String]): Unit = {
    val p1 = new Point(1,2)
    val p2 = new Point(1,3)
    println(p1.isNotEqu(p2))
  }

}
