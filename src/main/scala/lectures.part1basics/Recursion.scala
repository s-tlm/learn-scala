package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  // Below example is memory inefficient. 
  // Each expression is stored in memory with each loop, until it is finally 
  // evaluated at the end.
  // For large numbers, this will cause a stack overflow error. A lot of memory
  // is used by the function to store each expression.

  // Non tail-recursion
  // @tailrec // a scala annotation that checks whether our function is tail recursive
  def factorial(n: Int): Int = {
    if (n <= 0) 1
    else n * factorial(n-1) // ide will show an error here as this is not tail recursive
  }

  // Tail recursion is more memory efficient and avoids stack overflow errors.
  // The trick is to use an accumulator, which stores the intermediate results 
  // at each step.
  // Unlike the example above, we are not building a larger and larger
  // expression in each iteration.
  // Therefore, this is more memory efficient and the preferred way to define 
  // recursive functions.

  // Tail recursion
  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator)
    }

    factHelper(n, 1)
  }

  // println(factorial(100000)) // causes stack overflow error
  // println(anotherFactorial(100000))

  // General rule of thumb: When you need loops, use *tail* recursion!
  
  // Exercises using tail recursion
  // 1. Concatenate a string n times
  // 2. isPrime function
  // 3. Fibonacci function

  // 1. String Concatenation
  @tailrec
  def stringConcat(s: String, n: Int, accumulator: String = ""): String = {
    if (n <= 0) accumulator
    else stringConcat(s, n - 1, s + accumulator)
  }
  println(stringConcat("hello", 5))

  // 2. isPrime?
  def isPrime(n: Int): Boolean = {
    @tailrec
    def primeHelper(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (n <= 1) true
      else primeHelper(n - 1, n % t != 0 && isStillPrime)
    }

    primeHelper(n / 2, true)
  }

  // 3. Fibonacci
  def fibonacci(n: Int): Int = {
    @tailrec
    def fiboHelper(t: Int, first: Int, second: Int): Int = {
      if (t >= n) first
      else fiboHelper(t + 1, first + second, first)
    }

    if (n <= 2) 1
    else fiboHelper(2, 1, 1)
  }
  // 1 1 2 3 5 8 13 21 34 55
  println(fibonacci(10))
}
