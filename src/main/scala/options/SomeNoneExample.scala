package options

object SomeNoneExample extends App {

//  checkStringAsNumber("1234f")
//  checkMap()
//  getOrElseExample()
  mappingExample()

  def checkStringAsNumber(in: String): Unit = {
    println("Number checking example:")
    toInt(in) match {
      case Some(i) => println(i)
      case None    => println(in + " isn't a number")
    }
  }

  def checkMap(): Unit = {
    println("\nMap checking example:")
    val capitals = Map("Britain" -> "London", "Japan" -> "Tokyo")
    println("show(capitals.get( \"Japan\")) : " + findInMapIfExists(capitals.get("Japan")))
    println("show(capitals.get( \"France\")) : " + findInMapIfExists(capitals.get("France")))
  }

  def findInMapIfExists(x: Option[String]): String = x match {
    case Some(s) => s
    case None    => "?"
  }

  def getOrElseExample(): Unit = {
    println("\ngetOrElse example:")
    val i = toInt("5").get
    val j = toInt("j")

    val a: Option[Int] = Some(i)
    val b: Option[Int] = Some(j.getOrElse(12))
    val c: Option[Int] = None

    println("a.getOrElse(0): " + a.getOrElse(0))
    println("b.getOrElse(10): " + b.get)
    println("c.getOrElse(10): " + c.getOrElse(10))

    println("is a empty? " + a.isEmpty)
    println("is b empty? " + b.isEmpty)
    println("is c empty? " + c.isEmpty)
  }

  def toInt(in: String): Option[Int] =
    try Some(Integer.parseInt(in.trim))
    catch {
      case e: NumberFormatException => None
    }

  def mappingExample(): Unit = {
    val input = List(1, 2, 3, 4, 5, 6)
    input
      .map(element => timesByTwo(element))
      .foreach(println)
  }

  def timesByTwo(a: Int): Int =
    a * 2
}
