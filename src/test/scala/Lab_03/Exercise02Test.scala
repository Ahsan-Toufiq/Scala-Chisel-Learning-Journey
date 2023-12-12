package Lab_03

import chisel3._
import org.scalatest._
import chiseltest._

class ALU_Test extends FreeSpec with ChiselScalatestTester{
    "Lab#03 Exercise#02 Test" in {
        test(new ALU()) {ob1 =>
        
        ob1.io.in_A.poke(12.U)
        ob1.io.in_B.poke(23.U)
        ob1.io.alu_Op.poke(0.U)
        ob1.clock.step(1)
        //ob1.io.out.expect()
        //ob1.io.sum.expect()
        
        
        }
    }
}
