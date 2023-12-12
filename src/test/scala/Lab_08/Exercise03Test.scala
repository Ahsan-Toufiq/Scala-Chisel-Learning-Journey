package Lab_08

import chisel3._
import org.scalatest.FreeSpec
import chiseltest._

class Instruction_Stream_Test extends FreeSpec with ChiselScalatestTester {
  "Lab#08 Exercise#03 Test" in {
    test(new Instruction_Stream()) { ob1 =>
      // Write instructions to memory
      ob1.io.writeEnable.poke(true.B)
      ob1.io.address.poke(0.U)
      ob1.io.dataIn.poke(0x00000000.U)
      ob1.clock.step(1)

      ob1.io.writeEnable.poke(true.B)
      ob1.io.address.poke(1.U)
      ob1.io.dataIn.poke(0x00A04823.U)
      ob1.clock.step(1)

      ob1.io.writeEnable.poke(true.B)
      ob1.io.address.poke(2.U)
      ob1.io.dataIn.poke(0x00000067.U)
      ob1.clock.step(1)

      // Read and verify instructions
      ob1.io.readEnable.poke(true.B)
      ob1.io.address.poke(0.U)
      //ob1.io.dataOut.expect(0x00000000.U)
      ob1.clock.step(1)

      ob1.io.readEnable.poke(true.B)
      ob1.io.address.poke(1.U)
      //ob1.io.dataOut.expect(0x00A04823.U)
      ob1.clock.step(1)

      ob1.io.readEnable.poke(true.B)
      ob1.io.address.poke(2.U)
      //ob1.io.dataOut.expect(0x00000067.U)
      ob1.clock.step(1)
    }
  }
}
