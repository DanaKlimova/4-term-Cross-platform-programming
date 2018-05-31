package main.scala

import scala.annotation.tailrec
import scala.collection.mutable.{ListBuffer, Stack}


object Main {
  def main(args: Array[String]): Unit = {
    val myStack = Stack[Int](10, 9, 8, 7, 6, 5, 4, 3, 2, 1)
    println("Второй элемент стека без использования хвостовой рекурсии: " + getSecondStackElement(myStack))
    println("Второй элемент стека с использованием хвостовой рекурсии: " + getSecondStackElementTailrec(myStack))

    val start = 10
    val end = 500

    println("Диапазон чисел, вычесленных без помощи хвостовой рекурсии: " + getListOfNumbers(start, end).mkString(" "))
    println("Диапазон чисел, вычесленных с помощью хвостовой рекурсии: " + getListOfNumbersTailrec(start, end).mkString(" "))
  }

  def getSecondStackElementTailrec(myStack: Stack[Int]): Int = {
    val sizeOfStack = myStack.length
    val stack = myStack.padTo(myStack.length, 0)

    @tailrec
    def searching(myStack: Stack[Int], sizeOfStack: Int): Int = {
      if (sizeOfStack != 2) {
        myStack.pop()
        searching(myStack, sizeOfStack - 1)
      }
      else
        myStack.head
    }

    searching(stack, sizeOfStack)
  }

  def getSecondStackElement(myStack: Stack[Int]): Int = {
    myStack(myStack.length - 2)
  }


  //TASK 2
  def getListOfNumbersTailrec(start: Int, end: Int): ListBuffer[Int] = {
    val numbers = ListBuffer[Int]()
    val first = Math.round(Math.sqrt(start)).toInt + 1
    numbers += first
    val last = Math.round(Math.sqrt(end)).toInt

    def findNumbers(numbers: ListBuffer[Int], last: Int): ListBuffer[Int] = {
      if (numbers.last >= last)
        numbers
      else {
        numbers += numbers.last + 1
        findNumbers(numbers, last)
      }
    }

    findNumbers(numbers, last)
  }

  def getListOfNumbers(start: Int, end: Int): Range = {
    val first = Math.round(Math.sqrt(start)).toInt + 1
    val last = Math.round(Math.sqrt(end)).toInt
    first to last
  }
}
