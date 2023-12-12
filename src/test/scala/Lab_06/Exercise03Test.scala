package Lab_06

import chisel3._
import org.scalatest._
import chiseltest._

class TwoShotTimer_Test extends FreeSpec with ChiselScalatestTester {
  "Lab#06 Exercise#03 Test" in {
    test(new TwoShotTimer) { ob1 =>
      
      ob1.io.din.poke(21.U)
      ob1.io.reload.poke(1.B)
      ob1.clock.step(1)
    }
  }
}