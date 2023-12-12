package Lab_05

import chisel3._
import org.scalatest._
import chiseltest._

class Adder_Test extends FreeSpec with ChiselScalatestTester {
  "Lab#05 Task#01 Test" in {
    test(new Adder(5)) { ob1 =>

        ob1.io.in0.poke(14.U)
        ob1.io.in1.poke(16.U)
        ob1.io.sum.expect(30.U)
        ob1.clock.step(1)

        ob1.io.in0.poke(16.U)
        ob1.io.in1.poke(16.U)
        ob1.io.sum.expect(32.U)
        ob1.clock.step(1)

        ob1.io.in0.poke(4.U)
        ob1.io.in1.poke(1.U)
        ob1.io.sum.expect(5.U)
        ob1.clock.step(1)
    }
  }
}
