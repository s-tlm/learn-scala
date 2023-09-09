package lectures.part2oop

object Generics extends App {
  // In the previous exercise, we implemented a class to create a Linked List
  // of Ints. Unfortunately, it's very limited to just Ints. So how can we make
  // it accept other data types without rewriting code?
  // Answer: Scala Generics!
  

  class MyList[A] {
    // [A] represents a generic type
    // Can be named anything you want [B], [C], [hello]
  }

  class MyMap[Key, Value] {
    // can have as many type parameters as you want
  }

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }
  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // Problem: Does a list of Cat also extend list of Animal?
  // 1. Yes List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A] // + sign
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // Does animalList.add(new Dog) work? HARD QUESTION
  
  // 2. No. List[Cat] != List[Animal] == INVARIANT
  class InVariantList[A]
  val inVariantList: InVariantList[Animal] = new InVariantList[Animal]

  // 3. Hell no! CONTRAVARIANCE. Opposite to COVARIANCE
  class Trainer[-A] // - sign
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types
  class Cage[A <: Animal](animal: A) // Accepts parameter A if subtype of type Animal
  val cage = new Cage(new Dog)
}
