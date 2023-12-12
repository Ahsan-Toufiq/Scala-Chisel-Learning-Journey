package Lab_05

import chisel3._
import org.scalatest._
import chiseltest._

class Router_Test extends FreeSpec with ChiselScalatestTester {
  "Lab#05 Task#02 Test" in {
    test(new Router(UInt(32.W))) { ob1 =>
      ob1.io.in.address.poke(42.U)
      ob1.io.in.data.poke(123.U)
      ob1.clock.step(1)
    }
  }
}