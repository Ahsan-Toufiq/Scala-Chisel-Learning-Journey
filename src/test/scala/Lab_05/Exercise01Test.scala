package Lab_05

import chisel3._
import org.scalatest._
import chiseltest._

class ALU_Test extends FreeSpec with ChiselScalatestTester{
    "Lab#05 Exercise#01 Test" in {
        test(new  ALU(12)){
            c=>
            c.io.alu_oper.poke(4.U)
            c.io.arg_x.poke(4.U)
            c.io.arg_y.poke(4.U)
            c.clock.step(100)
        }

    }
}