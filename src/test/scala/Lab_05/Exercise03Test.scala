package Lab_05

import chisel3._
import org.scalatest._
import chiseltest._

class Operator_Test extends FreeSpec with ChiselScalatestTester {
    "Lab#05 Exercise#03 Test" in {
        test(new Operator(4,UInt(32.W))(_ + _)) { ob1 =>

            ob1.io.in(0).poke(1.U)
            ob1.io.in(1).poke(2.U)
            ob1.io.in(2).poke(3.U)
            ob1.io.in(3).poke(4.U)
        }
    }
}