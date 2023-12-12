package Lab_02

import chisel3._
import org.scalatest._
import chiseltest._

class Mux_2to1_IO_Test extends FreeSpec with ChiselScalatestTester {
    "Lab#02 Listing 2.2 Test" in {
        test (new Mux_2to1()){ ob1 =>
        ob1.clock.step(4)
        ob1.io.in_A.poke(208.U)
        ob1.io.in_B.poke(101.U)
        ob1.io.select.poke(1.B)
        ob1.io.out.expect(208.U)
        ob1.clock.step(5)
        ob1.io.select.poke(0.B)
        ob1.io.in_A.poke(28.U)
        ob1.io.in_B.poke(10.U)
        ob1.clock.step(2)
        }
    }
}