package Lab_05

import chisel3._
import org.scalatest._
import chiseltest._

class eMux_Test extends FreeSpec with ChiselScalatestTester {
    "Lab#05 Exercise#02 Test" in {
        test(new eMux(UInt(32.W))) { ob1 =>

            ob1.io.in1.poke(10.U)
            ob1.io.in2.poke(11.U)
            ob1.io.sel.poke(1.B)

            }
    }
}

