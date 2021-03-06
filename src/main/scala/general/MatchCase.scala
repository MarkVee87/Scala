package general

object MatchCase extends App {

  val name = "a"

  functionThatHasMatcherInside()
  def functionThatHasMatcherInside(): Unit = {
    val aVal = name match {
      case "a" => 115200
      case "b" => 1645
      case "c" => 2029
    }
    println(aVal)
  }

  println(functionWithMatchAsTheBody(name))
  def functionWithMatchAsTheBody(x: Any): String = x match {
    case s: String => "String"
    case i: Int    => "int"
    case _         => "unknown"
  }
}
