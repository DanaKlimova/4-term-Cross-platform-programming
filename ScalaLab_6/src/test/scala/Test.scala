import main.scala.Main
import org.scalatest.FlatSpec

import scala.collection.mutable.ListBuffer

class Test extends FlatSpec{

  it should "Capitalize" in {
    assert(Main.splitAndCapitalise(new String("Hello, my name is Dana")) === "Hello, My Name Is Dana")
  }

  it should "Return size of list" in {
    assert(Main.sizeOfList(ListBuffer(1, 2, 3, 4, 5)) === 5)
  }

  it should "Return list with x*x*x" in {
    assert(Main.changingList(ListBuffer(1, 2, 3, 4, 5)) === ListBuffer(1, 8, 27, 64, 125))
  }

}
