package `lectures.part1basics`

object Expressions extends App {

  val x = 1 + 2 // expression
  println(x)

  println(2 + 3 * 4) // evaluates using BODMAS
  println(1 == x)
  println(!(1 == x))

  var aVariable = 2
  aVariable += 3
  println(aVariable)

  // instructions (DO) vs expressions (VALUE)
  // IF expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3 // if *expression*
  println(aConditionedValue)

  // loops
  // AVOID WHILE LOOPS AND LOOPS IN GENERAL
  // NEVER WRITE IMPERATIVE CODE WITH SCALA CODE
  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }

  // everything in scala is an expression!
  val aWeirdValue = (aVariable = 3) // aVariable is of type Unit === void
  println(aWeirdValue)

  // side effects: println(), whiles, reassigning - all expressions that return
  // a unit
  
  // code blocks
  // code blocks can have their own val/var definitions
  // the data type of the code block is the last evaluated expression
  val aCodeBlock = {
    val y = 2
    val z = y + 1
    
    if (z > 2) "hello" else "goodbye"
  }

  // 1. type difference between "hello world" and println("hello world")? 
  // string, unit
  // 2. true, 42
}
