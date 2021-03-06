package functions

// "Higher order functions are functions that take at least one first class function as a parameter."
// Java does not support HOFs or FCFs (https://alvinalexander.com/scala/fp-book/what-is-functional-programming)

object HigherOrderFunctions extends App {

  // The higher order function has now returned a function which we are assigning to a val (as a first class function)
  val returnedFunction: (String, String) => Int = getComparator(true)
  private val str1 = "abc"
  private val str2 = "abc"

  // Higher order functions can return functions
  // e.g. this function returns a function that takes 2 strings and returns an Int -> (String, String) => Int
  def getComparator(reverse: Boolean): (String, String) => Int =
    if (reverse) compareStringsDescending
    else compareStringsAscending

  def compareStringsDescending(string1: String, string2: String): Int =
    if (string1 == string2) 0
    else if (string1 > string2) -1
    else 1

  def compareStringsAscending(string1: String, string2: String): Int =
    if (string1 == string2) 0
    else if (string1 > string2) 1
    else -1
  println(returnedFunction(str1, str2))
}
