package lectures.part2oop

object OOBasics extends App {

  val person = new Person("John", 26) // instantiate class
  println(person.age)
  println(person.x)
  person.greet("Daniel")

  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(novel.authorAge)
  println(novel.isWrittenBy(author))
  println(novel.isWrittenBy(imposter)) // returns false incorrectly due to inequality

  val counter = new Counter()
  counter.increment.print
  counter.increment.increment.increment.print
  counter.increment(10).print

}

// class constructor
class Person(name: String, val age: Int = 0) {
  // body. Everything within will be executed everytime the class is evaluated
  val x = 2
  println(1 + 3)

  // this returns the current instances being operated on
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name!")

  // overloading. Define methods of the same name but different parameters
  def greet(): Unit = println(s"Hi, I am $name") // implies this.name

  // multiple constructors (overloading constructors)
  // Must call another constructor
  def this(name: String) = this(name, 0)

}

  /*
   Exercises

   1. Novel and a Write class
    * Writer: first name, surname, year
    *   - method full name (concats first and last name)
    * Novel: name, year of release, author
    *   - method authorAge (age of author at year of release)
    *   - isWrittenBy(author)
    *   - copy (new year of release) = new instance of Novel with a new year of
    *   release
    *
   2. Counter class
    *   - receives an int value
    *   - method current count
    *   - method to increment/decrement => new counter
    *   - overload inc/dec to receive an amount
   */

  // 1.
  class Writer(first_name: String, last_name: String, val year: Int) {
    def fullName: Unit = 
      println(f"$first_name $last_name")
  }

  class Novel(name: String, year: Int, author: Writer) {
    def authorAge: Int = year - author.year

    def isWrittenBy(author: Writer): Boolean = author == this.author

    def copy(newYear: Int): Novel = new Novel(name, newYear, author)
  }

  class Counter(val count: Int = 0) {
    def increment = {
      println("Incrementing...")
      new Counter(count + 1) // immutability. We *don't modify* the original parameter
    }

    def decrement = {
      println("Decrementing...")
      new Counter(count - 1)
    }

    def increment(n: Int): Counter = {
      if (n <= 0) 
        this
      else 
        increment.increment(n-1)
    }

    def decrement(n: Int): Counter = {
      if (n <= 0) 
        this
      else 
        decrement.decrement(n-1)
    }

    def print = println(count)
  }

// class parameters are *not fields*. Can't access by using Person.age
// To access class parameters, add the val keyword
