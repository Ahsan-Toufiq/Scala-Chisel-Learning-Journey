package Lab_08

import chisel3._
import org.scalatest.FreeSpec
import chiseltest._

class TwoBankedMemory_Test extends FreeSpec with ChiselScalatestTester {
  "Lab#08 Exercise#02 Test" in {
    test(new TwoBankedMemory()) { ob1 =>

      ob1.io.enable.poke(true.B)
      ob1.io.write.poke(true.B)
      ob1.io.addr.poke(42.U)
      ob1.io.mask(0).poke(true.B)
      ob1.io.mask(1).poke(false.B)
      ob1.io.dataIn(0).poke(10.U)
      ob1.io.dataIn(1).poke(20.U)

      ob1.clock.step(1)

      ob1.io.dataOut(0).expect(10.U)
      ob1.io.dataOut(1).expect(0.U)
    }
  }
}
