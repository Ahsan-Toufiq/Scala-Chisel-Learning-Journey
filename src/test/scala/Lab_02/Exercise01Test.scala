package Lab_02

import chisel3._
import org.scalatest._
import chiseltest._

class Mux_2to1_CombinationalLogic_Test extends FreeSpec with ChiselScalatestTester{
    "Lab#02 Exercise#01 Test" in{
        test (new Mux_2to1_CombinationalLogic()){ ob1 =>
        ob1.io.in_A.poke(9.U)
        ob1.io.in_B.poke(3.U)
        ob1.io.select.poke(1.B)
        ob1.io.out.expect(3.U)
        ob1.clock.step(1)

        }
    }
}