package Lab_05

import chisel3._
import org.scalatest._
import chiseltest._

class InclusiveTypecastedEMux_Test extends FreeSpec with ChiselScalatestTester {
  "Lab#05 Task#03 Test" in {
    
    test(new InclusiveTypecastedEMux(UInt(32.W),SInt(32.W))) { ob1 =>
        
        ob1.io.sel.poke(0.B)
        ob1.io.inT.poke(11.U)
        ob1.io.inU.poke(134.S)

        ob1.clock.step(1)

        ob1.io.sel.poke(1.B)
        ob1.io.inT.poke(11.U)
        ob1.io.inU.poke(134.S)
        ob1.clock.step(1)
    
    }
  }
}