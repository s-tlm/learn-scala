package exercises

abstract class MyList {

  /*
  Exercise:
    head = first element of the list
    tail = remainder of the list
    isEmpty = Boolean - is this list empty?
    add(Int) => new List with this element add
    toString => a string representation of the list
  */

  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(n: Int): MyList
  def printElements: String // polymorphic call
  override def toString: String = s"[ ${printElements} ]"
}

object Empty extends MyList {
  def head: Int = throw new NoSuchElementException
  def tail: MyList = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(n: Int): MyList = new Cons(n, Empty)
  def printElements: String = ""
}

class Cons(h: Int, t: MyList) extends MyList {
  def head: Int = h
  def tail: MyList = t
  def isEmpty: Boolean = false
  def add(n: Int): MyList = new Cons(n, this)
  def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
}

// Testing our Linked List
object ListTest extends App {

  val list = new Cons(1, new Cons(2, new Cons(3, new Cons(4, Empty))))
  println(list.head)
  println(list.add(4).head)
  println(list.toString)
}
