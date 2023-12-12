package Lab_03

import chisel3._
import org.scalatest._
import chiseltest._

class BranchControl_Test extends FreeSpec with ChiselScalatestTester{
    "Lab#03 Task#01 Test" in {
        test(new BranchControl()){ ob1 =>
        
        ob1.io.fnct3.poke("b000".U)
        ob1.io.branch.poke(1.B)
        ob1.io.arg_x.poke(37.U)
        ob1.io.arg_y.poke(37.U)
        ob1.clock.step(1)

        ob1.io.fnct3.poke("b000".U)
        ob1.io.branch.poke(1.B)
        ob1.io.arg_x.poke(37.U)
        ob1.io.arg_y.poke(38.U)
        ob1.clock.step(1)
        
        ob1.io.fnct3.poke("b000".U)
        ob1.io.branch.poke(0.B)
        ob1.io.arg_x.poke(37.U)
        ob1.io.arg_y.poke(37.U)
        ob1.clock.step(1)
        }
    }
}