package main.scala

object Main {
  def main(args: Array[String]): Unit = {
    //TASK1
    val value = 10
    val result = value match {
      case _ if value % 5 == 0 => value * 2
      case _ if value % 6 == 0 => value / 3
      case _ => value
    }

    println("Исходное значение: " + value + ", измененное: " + result)

    //TASK2
    val feather = new Feather()
    val pen = new Pen()
    val pencil = new Pencil()

    println(fixStationery(feather))
    println(fixStationery(pen))
    println(fixStationery(pencil))
    println(fixStationery(1))


  }

  //TASK1


  //TASK2
  def fixStationery(any: Any): String = {
    val message = any match {
      case any: Feather => any.douse
      case any: Pen     => any.removeCap
      case any: Pencil  => any.sharpen
      case _            => "This is not sharpen"
    }
    message
  }
}

case class Feather() {
  def douse: String = {
    "Douse your feather"
  }
}

case class Pen() {
  def removeCap: String = {
    "Remove cap from pen"
  }
}

case class Pencil() {
  def sharpen: String = {
    "Sharpen your pencil"
  }
}