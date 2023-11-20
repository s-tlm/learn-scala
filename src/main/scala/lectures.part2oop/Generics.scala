package lectures.part2oop

object Generics extends App {
  // In the previous exercise, we implemented a class to create a Linked List
  // of Ints. Unfortunately, it's very limited to just Ints. So how can we make
  // it accept other data types without rewriting code?
  // Answer: Scala Generics!
  

  class MyList[A] {
    // [A] represents a generic type
    // Can be named anything you want [B], [C], [hello]
  
    // if given an element B that's a superset of A, turn the list into type B
    def add[B >: A](element: B): MyList[B] = ???
  }

  // can have as many type parameters as you want
  class MyMap[Key, Value]

  // val listOfStrings = new MyList[String]
  // val listOfIntegers = new MyList[Int]

  // generic methods
  // object MyList {
  //   def empty[A]: MyList[A] = ???
  // }
  // val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // Problem: Does a list of Cat also extend list of Animal?
  // 1. Yes List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A] // + sign
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // Does animalList.add(new Dog) work? HARD QUESTION
  // Yes, we return a list of Animals
  
  // 2. No. List[Cat] != List[Animal] == INVARIANT
  class InVariantList[A]
  val inVariantList: InVariantList[Animal] = new InVariantList[Animal]

  // 3. Hell no! CONTRAVARIANCE. Opposite to COVARIANCE
  class Trainer[-A] // - sign
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types
  // <: (subset) || >: (superset)
  class Cage[A <: Animal](animal: A) // Accepts parameter A if subtype of type Animal
  val cage = new Cage(new Dog)


  // Exercise:
  // 1. Expand MyList from previous exercise to be generic
  // Accepts all data types
  
  // Make it covariant
  abstract class NewList[+A] {

    /*
    Exercise:
      head = first element of the list
      tail = remainder of the list
      isEmpty = Boolean - is this list empty?
      add(Int) => new List with this element add
      toString => a string representation of the list
    */

    def head: A
    def tail: NewList[A]
    def isEmpty: Boolean
    def add[B >: A](i: B): NewList[B]
    def printElements: String // polymorphic call
    override def toString: String = s"[ ${printElements} ]"
  }

  object Empty extends NewList[Nothing] {
    def head: Nothing = throw new NoSuchElementException
    def tail: NewList[Nothing] = throw new NoSuchElementException
    def isEmpty: Boolean = true
    def add[B >: Nothing](i: B): NewList[B] = new Cons(i, Empty)
    def printElements: String = ""
  }

  class Cons[+A](h: A, t: NewList[A]) extends NewList[A] {
    def head: A = h
    def tail: NewList[A] = t
    def isEmpty: Boolean = false
    def add[B >: A](i: B): NewList[B] = new Cons(i, this)
    def printElements: String =
      if (t.isEmpty) "" + h
      else h + " " + t.printElements
  }

  // Testing our Linked List
  val listOfIntegers: NewList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val listOfStrings: NewList[String] = new Cons("Hello", new Cons("World", new Cons("!", Empty)))
  println(listOfIntegers.head)
  println(listOfStrings.head)
  println(listOfIntegers.add(4).head)
  println(listOfStrings.add("Wow!").head)
  println(listOfIntegers.toString)
  println(listOfStrings.toString)
}
