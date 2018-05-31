package main.scala

import scala.collection.mutable.ListBuffer


object Main {

  //TASK1
  def splitAndCapitalise(string: String) : String = {
    val resultString: String = string.split(' ').map(_.capitalize).mkString(" ")
    resultString
  }

  //TASK2
  def sizeOfList(list : ListBuffer[Int]) : Int = {
    val sizeOfList = list.foldLeft(0) { (acc, i) => acc + 1}
    sizeOfList
  }

  //TaASK3
  def changingList (list : ListBuffer[Int]) : ListBuffer[Int] = {
    val changedList: ListBuffer[Int] = list.map(x => x * x * x)
    changedList
  }

  def main(args: Array[String]): Unit = {

  }

}
