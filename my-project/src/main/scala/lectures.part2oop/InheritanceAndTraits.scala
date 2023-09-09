package lectures.part2oop

object InheritanceAndTraits extends App {

  // single class inheritance. Can only extend one class at a time
  class Animal {
    // super-class of cat
    val creatureType = "Wild"
    def eat = println("Nom nom nom!")
    // private def eat = println("Nom nom nom!") prevents inheritance
    // protected def eat = println("Nom nom nom!") allows use inside class and sub-class
    
  } 

  class Cat extends Animal // sub-class of animal

  val cat = new Cat // inherits all non-private methods of super-class
  cat.eat

  // Constructors
  class Person(name: String, age: Int)
  // Calls the constructor from Person first before Adult
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  // Overriding
  // works for methods, vals and vars
  class Dog extends Animal {
    override val creatureType = "Domestic"
    override def eat = {
      super.eat // call eat from parent class
      println("crunch crunch!")
    }
  }

  val dog = new Dog
  println(dog.creatureType)
  dog.eat

  // Type Substitution (polymorphism)
  val unknownAnimal: Animal = new Dog
  unknownAnimal.eat // returns "crunch crunch!" Will use the dog's method. 
  // Method calls will always go to the most overridden method when possible
  

  // overRIDING vs overLOADING
  // overriding - provide different method implementation in sub-class
  // overloading - calling multiple methods of the same name by their different 
  // signatures in the same class
  
  // Super
  // Used when you want to reference a method or field from a parent class
  
  // Preventing Overrides
  // 1. Use keyword "final" on method
  // 2. Use keyword "final" on class
  // 3. Use keyword "sealed" on class. Extends class in this file, but prevent extension in other files
}
