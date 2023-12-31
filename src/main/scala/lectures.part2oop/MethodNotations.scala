package lectures.part2oop

object MethodNotations extends App {
  
  class Person(val name: String, favouriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favouriteMovie 

    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}!"

    // need a space before the return type or else compiler thinks ":" is part of the unary name
    def unary_! : String = s"${name}, what the heck?!"

    def isAlive: Boolean = true

    // Need brackets "()"
    def apply(): String = s"Hi, my name is ${name} and I like ${favouriteMovie}."

    // Exercises
    // 1.
    def +(nicname: String): Person = new Person(s"${name} (${nicname})", favouriteMovie)

    // 2.
    def unary_+ : Person = new Person(name, favouriteMovie, age + 1)

    // 3.
    def learns(subject: String): String = s"${name} learns ${subject}."
    def learnsScala: String = this learns "Scala"

    // 4.
    def apply(n: Int): String = s"${name} watched ${favouriteMovie} ${n} times!"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))

  // infix notation = operator notation (syntatic sugar)
  // Only works with methods with one parameter
  println(mary likes "Inception") // equivalent to above

  val tom = new Person("Tom", "Fight Club")
  println(mary hangOutWith tom) // Scala allows very flexible operator naming
  // Eg. "+", "-" are all valid method names!
  
  // All operators are actually methods using infix notation!
  println(1 + 2)
  println(1.+(2)) // equivalent to above

  // Prefix notation (syntatic sugar)
  val x = -1
  val y = 1.unary_-
  // unary_ prefix only works with "-", "+", "~" and "!"
  
  println(!mary)
  println(mary.unary_!) // equivalent

  // Postfix notation (syntatic sugar)
  // !IMPORTANT!: Rarely used in practice because the only difference is the "." 
  // and spaces can introduce unexpected errors
  println(mary.isAlive)
  println(mary isAlive) // equivalent

  // apply
  println(mary.apply()) 
  println(mary()) // equivalent. Looks for a method called apply() in the class
  // no need to specify the method name! Can specify any method called apply
  // with or without input variables.

  // Exercises
  // 1. Overload the + operator. Receives a string and returns a new Person with a nickname
  //  mary + "the rockstar" => new person "Mary (the rockstar)"
  
  // 2. Add an age method to Person class. 
  //  Add unary + operator => new Person with age + 1
  println((+mary).age)

  // 3. Add a learns method in the Person class
  //  mary learns "scala" => "Mary learns scala"
  //  Add a learnScala method, calls learns method with "Scala"
  //  Use postfix notation.
  println(mary learns "maths")
  println(mary learnsScala)

  // 4. Overload apply method
  //  mary.apply(2) => "Mary watched Inception 2 times."
  println(mary(2))
}
