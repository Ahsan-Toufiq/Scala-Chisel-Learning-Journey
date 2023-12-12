package Lab_08

import chisel3._
import org.scalatest.FreeSpec
import chiseltest._

class MemoryAssignment_Test extends FreeSpec with ChiselScalatestTester {
  "Lab#08 TAsk#01 Test" in {
    test(new MemoryAssignment()) { ob1 =>
      
      ob1.io.requestor(0).valid.poke(true.B)
      ob1.io.requestor(0).bits.poke(42.U)
      ob1.io.requestor(1).valid.poke(false.B)
      ob1.io.requestor(2).valid.poke(false.B)
      ob1.io.requestor(3).valid.poke(false.B)
      ob1.io.writeaddr.poke(3.U)
      ob1.clock.step(1)

      ob1.io.requestor(0).valid.poke(false.B)
      ob1.io.requestor(1).valid.poke(false.B)
      ob1.io.requestor(2).valid.poke(false.B)
      ob1.io.requestor(3).valid.poke(true.B)
      ob1.io.readaddr.poke(1.U)
      
      ob1.clock.step(1)
    }
  }
}
