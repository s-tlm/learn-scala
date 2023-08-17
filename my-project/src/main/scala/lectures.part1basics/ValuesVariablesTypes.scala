package lectures.part1basics

object ValuesVariablesTypes extends App {

  // vals are immutable
  // types are optional
  val x: Int = 42
  
  println(x)

  val aString: String = "hello"

  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 4613 // 4 bytes
  val aLong: Long = 12345678L // 8 bytes. L at the end denotes a long
  val aFloat: Float = 2.0f // f denotes a Float
  val aDouble: Double = 3.14

  // variables
  var aVariable: Int = 4

  // variables are mutable
  aVariable = 5 // side effects
}
