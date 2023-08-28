package lectures.part1basics

object StringOps extends App {

  val str: String = "Hello, I am learning Scala"

  // java string ops are available in scala
  println(str.charAt(2))
  println(str.substring(7, 11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.toUpperCase())
  println(str.length)

  // scala specific string ops
  val aNumberString = "2"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z')
  println(str.reverse)
  println(str.take(2))

  // String Interpolators

  // S-interpolators
  val name = "Steven"
  val age = 12
  val greeting = s"Hello, my name is $name and I am $age years old!"
  val anotherGreeting = s"Hello, my name is $name and I will be ${age + 1} years old!"
  println(anotherGreeting)

  // F-interpolators
  // acts as s-interpolators, but can *receive printf-like formats*
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minute!"
  println(myth)

  // raw interpolator
  // acts as s-interpolator, but can also print characters literally
  // will work on raw strings only. Will not work on injected string variables
  
  println(raw"This is a \n newline.") // works
  val escaped = "This is a \n newline."
  println(raw"$escaped") // won't work
}
