package lectures.part2oop

object AbstractDataTypes extends App {
    // abstract members have unimplemented code  
    // abstract classes contains abstract members

    // abstract class can not be instantiated
    abstract class Animal {
      // sub-classes fill in the values
      // can have abstract and non-abstract members
      val creatureType: String = "Wild"
      def eat: Unit // abstract member
    }

    class Dog extends Animal {
      // override key word isn't required for Abstract members
      override val creatureType: String = "Canine"
      def eat: Unit = println("Crunch crunch!")
    }

    // traits
    trait Carnivore {
      // can also have abstract and non-abstract members
      def eat(animal: Animal): Unit
      val preferredMeal: String = "fresh meat"
    }

    trait ColdBlooded

    class Crocodile extends Animal with Carnivore with ColdBlooded {
      // Crocodile inherits from Animal and Carnivore
      override val creatureType: String = "Croc"
      def eat: Unit = println("Nom nom nom!")
      def eat(animal: Animal): Unit = println(s"I'm a ${creatureType} and I'm eating ${animal.creatureType}")
    }

    val dog = new Dog
    val croc = new Crocodile

    croc.eat(dog)

    // traits vs abstract classes
    // 1. traits can't have input parameters
    // 2. you can extend only one class, but mix in multiple traits
    // 3. traits = behaviours, abstract class = "thing"
    
    /* 
    Scala Type Hierarchy

                extends       extends           extends
    scala.AnyVal --> scala.Any <-- scala.AnyRef <-- scala.Null
        ^                                               ^
        |_______________________________________________|
                                ||
                            scala.Nothing
    */
}
