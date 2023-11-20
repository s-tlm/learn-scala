package lectures.part1basics

object CBNvsCBV extends App {

  // Call by value:
  //  value is computed before a call
  //  same value used throughout the function

  // call by name:
  //  => (rocket) symbol
  //  expression is passed literally
  //  expression is evaluated *with every use* in the function
  //  good for lazy evaluation

  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  // the value is parsed as the input variable x
  calledByValue(System.nanoTime())
  // the time function is parsed literally in the calledByName function
  calledByName(System.nanoTime()) 

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  printFirst(infinite(), 34) // will cause stack overflow error
  printFirst(34, infinite) // runs because the y variable is never used
}

