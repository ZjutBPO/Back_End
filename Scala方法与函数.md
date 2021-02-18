# Scala方法与函数

### 方法定义

1. 方法体的返回值类型可以省略，会自动推断

2. 方法体最后的返回值可以使用return，如果使用了return那么一定要指定返回类型

3. 方法体中没有用return，默认将方法体当中最后一行计算的结果当做返回值返回

4. 定义方法传入的参数一定要指定类型

5. 方法体当中，如果只有一行，大括号可以省略

   ```
   def max(a:Int,b:Int) = if(a<b) a else b
   ```

6. 如果定义方法时，省略了方法名称和方法体之间的 " = "，无论结果是什么，结果丢弃，返回空值Unit

### 递归方法

递归方法要显式的声明函数的返回值类型

```
def fun(num: Int): Int = {      
if (num == 1) 1 else num * fun(num - 1)    }
```

### 参数有默认值的方法

可重新赋值，也可直接用Default_parameters() 

    def fun(a: Int = 10, b: Int = 20) = {
      a + b}
    
    println(fun(b=54))
### 可变长参数的方法

传递参数的时候在后面加上一个* 表示可传递多个参数

对参数进行打印输出可以使用for循环，foreach

foreach循环使用 => 匿名函数

```
def fun(s: String*) = {
      // =>匿名函数
      s.foreach(ele => {println(ele)})
      //当foreach当中的参数只用了一次可以使用下划线 "_" 进行代替
      s.foreach(println(_))
      //可再进行省略
      s.foreach(println)
    }
```

```
fun("hello","world","123")
```

### 匿名函数

()=>{} 参数类型=>返回类型，自动推断，可直接调用，多用于方法的参数是函数时

```
def fun = (a: Int, b: Int) => {
  a + b
}
```

### 嵌套方法

### 偏应用函数

方法中参数过多，调用此方法频繁且每次调用只有固定某个参数变化，其他都不变，可用偏应用函数进行简化

```
def showLog(date:Date,log:String)={
  println("date is"+date+", log is"+log)
}

def fuc = showLog(date,_:String)
  fuc("aaa")
  fuc("bbb")
```

### 高阶函数

1、方法的参数是函数（可使用匿名函数）

	def sum1(a: Int, b: Int) = {
	  a + b
	}
	def fun(f: (Int, Int) => Int, s: String) = {
	  val i: Int = f(100, 200);
	  i + "  " + s
	}
	var res = fun(sum1,"string")
	/* 匿名函数 */ 
	def fun(f: (Int, Int) => Int, s: String) = {
	  val i: Int = f(100, 200);
	  i + "  " + s
	}
	var res = fun((a:Int,b:Int)=>{a*b},"string")
2、方法的返回是函数

要显式的写出方法的返回值类型，加_可不写

    def fun(a: String): (String, String) => String = {
      def fun1(s1: String, s2: String): String = {
        s1 + " " + s2 + " " + a
      }
      fun1
      fun1 _ //使用这种方式不需要给出返回类型
    }
    println(fun("a")("b", "c"))
3、方法的参数和返回均是函数

将前两种结合

    def fun(f: (Int, Int) => Int): (String, String) => String = {
      val i: Int = f(1, 2)
      def fun1(s1: String, s2: String): String = {
        s1 + " " + s2 + " " + i
      }
      fun1
    }
    println(fun((a,b)=>{a+b})("hello","123"))
### 柯里化函数

是对高阶函数的一个简化

    def fun(a: Int, b: Int)(c: Int, d: Int): Int = {
      a + b + c + d
    }
    println(fun(1,2)(3,4))