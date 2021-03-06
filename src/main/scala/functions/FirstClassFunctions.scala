package functions

// "First class functions are functions that are treated like an object (or are assignable to a variable)."
// Java does not support HOFs or FCFs (https://alvinalexander.com/scala/fp-book/what-is-functional-programming)

object FirstClassFunctions extends App {

  val compareStrings: (String, String) => Boolean = (string1: String, string2: String) => {
    if (string1 == string2) true
    else false
  }
  println(compareStrings("abc", "def"))
}
