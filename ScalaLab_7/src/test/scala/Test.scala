import main.scala.{Feather, Main, Pen, Pencil}
import org.scalatest._
class Test extends FlatSpec{

  it should "Douse your feather" in {
    assert(Main.fixStationery(new Feather) === "Douse your feather")
  }

  it should "Remove cap from pen" in {
    assert(Main.fixStationery(new Pen()) === "Remove cap from pen")
  }

  it should "Sharpen your pencil" in {
    assert(Main.fixStationery(new Pencil()) === "Sharpen your pencil")
  }

  it should "This is not sharpen" in {
    assert(Main.fixStationery(1) === "This is not sharpen")
  }
}
