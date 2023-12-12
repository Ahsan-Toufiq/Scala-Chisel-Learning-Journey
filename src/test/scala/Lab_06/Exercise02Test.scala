package Lab_06

import chisel3._
import org.scalatest._
import chiseltest._

class Counter_Test extends FreeSpec with ChiselScalatestTester {
  "Lab#06 Exercise#02 Test" in {
    test(new Counter(13)) { ob1 =>
      
      ob1.clock.step(1)
    }
  }
}