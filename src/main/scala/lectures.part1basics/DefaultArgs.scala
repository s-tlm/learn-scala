package lectures.part1basics

object DefaultArgs extends App {

  // provide a default value for acc argument
  def factorial(n: Int, acc: Int = 1): Int = 
    if (n <= 1) acc
    else factorial(n-1, n*acc)

  val fact10 = factorial(10)

  /* 
   Best practice is to:
      * name each argument when inputting function arguments
  */
}
