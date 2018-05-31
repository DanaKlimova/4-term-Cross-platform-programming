import main.scala.Main
import org.scalatest.FlatSpec

import scala.collection.mutable.Stack

class Test extends FlatSpec{

  it should "Second element of stack" in {
    assert(Main.getSecondStackElement(Stack(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)) ===
      Main.getSecondStackElementTailrec(Stack(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)))
  }

  it should "Return range of numbers" in {
    assert(Main.getListOfNumbers(10, 500) === Main.getListOfNumbersTailrec(10, 500))
  }



}
