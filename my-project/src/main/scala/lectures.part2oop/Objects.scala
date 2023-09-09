package lectures.part2oop

object Objects extends App {
  // SCALA DOES NOT HAVE CLASS LEVEL FUNCTIONALITY ("static")
  object Person { // type + its only instance
    // can define vals, vars and methods in objects
    // "static"/"class" level functionality
    
    val N_EYES = 2
    def canFly: Boolean = false

    // In practice, we usually define our Factory methods within the object
    // Factory method:
    // *Convention is to name them apply*
    def apply(mother: Person, father: Person): Person = new Person("Bobby")
  }

  class Person(name: String) {
    // instance level functionality
    // defined with the same name and scope as the object: Companion
  }

  // COMPANIONS
  //

  println(Person.N_EYES)
  println(Person.canFly)

  // Scala object = SINGLETON INSTANCE
  val mary = Person
  val john = Person
  println(mary == john) // returns TRUE as they are referencing the same object instance

  // Scala class = UNIQUE INSTANCE
  val slam = new Person("Slam")
  val nat = new Person("Nat")
  println(slam == nat) // returns FALSE as these are different class instances

  // Using a Factory method
  val bobby = Person(slam, nat)

  // Scala applications = Scala object with:
  // def main(args: Array[String]): Unit
  // This allows it to be parsable by the Java LLVM
  // OR
  // specify the object "extends App" - has the main method built-in
  
}
