# Scala基础

Scala中每行后面有分号自动推断机制，不用显示写出";"

### 变量与常量的声明

在 Scala 中，使用关键词 **"var"** 声明变量，使用关键词 **"val"** 声明常量。定义变量或常量时，可以写上返回值类型，例如

```
Val a ：Int = 10
```

一般不写返回值

### 数据类型

Scala与Java有着相同的数据类型，Scala数据类型都是对象，Scala中没有类似Java中那样的原始类型。

Scala基本数据类型：Byte，Short，Int，Long ， Char，Float ， Double，String

| 数据类型 | 描述                                                         |
| -------- | ------------------------------------------------------------ |
| Unit     | 表示无值，和其他语言的void等同。用作不返回任何结果的方法的结果类型。Unit只有一个实例值为()。 |
| Null     | null 或空引用。                                              |
| Nothing  | 是Scala的类层级的最低端，是任何其他类型的子类型。            |
| Any      | 是所有其他类的超类。                                         |
| AnyRef   | 是所有引用类的基类。                                         |
| AnyVal   | 是所有值类型的超类。                                         |

当给变量定义的时候，不给出类型就是一个Nothing

空值之间的区别：

| 数据类型 | 描述                                                         |
| -------- | ------------------------------------------------------------ |
| Null     | 其唯一实例为null，是AnyRef的子类，不是AnyVal的子类           |
| Nothing  | 所有类型的子类（包括AnyRef和AnyVal）                         |
| None     | Option（用于Map）的子类之一，另一个是Some，用于安全函数的返回值 |
| Unit     | 无返回值的函数的类型                                         |
| Nil      | 长度为0的List                                                |

### 类和对象

1、Scala object 相当于 java 中的单例，object 中定义的全是静态的（相当于java中的工具类），object不可传，对象要传参时使用apply方法。main方法在object中定义。

2、Scala类中可以传参，传参一定要指定类型，有了参数就有了默认构造。类中的属性默认有getter和setter方法。

```
class Person(xname:String,xage:Int)
{
  val name = xname
  val age = xage
}
```

3、Scala类中重写构造，构造第一行必须先调用默认的构造。def this(...){...}

```
class Person(xname:String,xage:Int)
{
  val name = xname
  val age = xage
  var gender = 'M'
  def this(yname:String,yage:Int,ygender:Char){
    this(yname,yage)
    this.gender = ygender
  }
}
```

4、Scala中当new class时，类中除了方法不执行（除了构造方法），其他都执行。使用object时不用new。

5、 在同一个Scala文件中，class和object名称一样时，这个类叫做这个对象的伴生类，这个对象叫做这个类的伴生对象。

### until和to

```
/ * 操作符操作 */
val r = 1 to 10         //包括10，相当于1.to(10)
val r1 = 1 until 10     //不包括10，相当于1.until(10)

val r = 1.to(10,2)      //步长为2 Range(1,3,5,7,9)
```

### for循环

1、可以有两个

```
for(i <- 1 until 10;j <- 1 until 10) 
```

2、可以有多个条件(条件之间也可直接用空格隔开)

```
for(i <- 1 to 10;if(i>5);if(i%2==0)) 
for(i <- 1 to 10 if(i>5) if(i%2==0)) 
```

```
val result = for(i <- 1 to 10 if(i%2==0)) yield i
println(result)

输出结果：
Vector(2, 4, 6, 8, 10)
```

Scala中没有i++，i--

