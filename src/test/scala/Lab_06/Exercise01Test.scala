package Lab_06

import chisel3._
import org.scalatest._
import chiseltest._

class shift_register_Test extends FreeSpec with ChiselScalatestTester {
    "Lab#06 Exercise#01 Test" in {
        test(new shift_register((1))) { ob1 =>

            ob1.io.in.poke(1.B)
            ob1.io.parallelLoad.poke(1.B)
            ob1.io.parallelData.poke(7.U)
            //ob1.io.in(3).poke(0.U)
            ob1.clock.step(1)
            }
    }
}