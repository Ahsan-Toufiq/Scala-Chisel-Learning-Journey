package Lab_02

import chisel3._
import org.scalatest._
import chiseltest._

class Mux_5to1_Test extends FreeSpec with ChiselScalatestTester {
    "Lab#02 Task#01 Test" in {
        test (new Mux_5to1()) { ob1 =>
        ob1.io.s0.poke(1.B)
        ob1.io.s1.poke(0.B)
        ob1.io.s2.poke(0.B)
        ob1.io.out.expect(8.U)
        ob1.clock.step(1)

        ob1.io.s0.poke(0.B)
        ob1.io.s1.poke(1.B)
        ob1.io.s2.poke(0.B)
        ob1.io.out.expect(16.U)
        ob1.clock.step(1)

        ob1.io.s0.poke(0.B)
        ob1.io.s1.poke(0.B)
        ob1.io.s2.poke(1.B)
        ob1.io.out.expect(32.U)
        ob1.clock.step(1)

        ob1.io.s0.poke(1.B)
        ob1.io.s1.poke(1.B)
        ob1.io.s2.poke(0.B)
        ob1.io.out.expect(24.U)
        ob1.clock.step(1)
        }
    }
}