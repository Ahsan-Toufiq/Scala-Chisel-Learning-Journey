package Lab_08

import chisel3._
import org.scalatest._
import chiseltest._

class MaskedReadWriteSmem_Test extends FreeSpec with ChiselScalatestTester {
  "Lab#08 Exercise#01 Test" in {
    test(new MaskedReadWriteSmem()) { ob1 =>
    
      ob1.io.enable.poke(true.B)
      ob1.io.write.poke(true.B)
      ob1.io.addr.poke(42.U)
      ob1.io.mask(0).poke(true.B)
      ob1.io.mask(1).poke(false.B)
      ob1.io.mask(2).poke(true.B)
      ob1.io.mask(3).poke(false.B)
      ob1.io.dataIn(0).poke(10.U)
      ob1.io.dataIn(1).poke(20.U)
      ob1.io.dataIn(2).poke(30.U)
      ob1.io.dataIn(3).poke(40.U)

      ob1.clock.step(1)

      ob1.io.dataOut(0).expect(10.U)
      ob1.io.dataOut(1).expect(0.U)
      ob1.io.dataOut(2).expect(30.U)
      ob1.io.dataOut(3).expect(0.U)

      ob1.clock.step(1)
    }
  }
}
