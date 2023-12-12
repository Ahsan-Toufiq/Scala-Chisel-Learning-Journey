package practice
import chisel3._
import org.scalatest._
import chiseltest._

class MUXtest extends FreeSpec with ChiselScalatestTester{
    "MUX Test" in {
        test(new MUX()){ ob1 =>
        ob1.io.a.poke(8.U)
        ob1.io.b.poke(12.U)
        ob1.io.sel.poke(5.U)
        ob1.clock.step(100)
        ob1.io.out.expect(11.U)
        }
    }
}