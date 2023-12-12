package practice

import chisel3._
import org.scalatest._
import chiseltest._

class FullAdderTest extends FreeSpec with ChiselScalatestTester{
    "Full Adder Test" in {
        test(new FullAdder()){ob1 =>
        ob1.io.a.poke(1.B)
        ob1.io.b.poke(1.B)
        ob1.io.cin.poke(1.B)
        ob1.clock.step(1)
        ob1.io.sum.expect(1.B)
        ob1.io.cout.expect(1.B)
        }
    }
}