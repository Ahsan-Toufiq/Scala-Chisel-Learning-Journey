package Lab_01

import chisel3._
import org.scalatest._
import chiseltest._

class Lab01Task02Test extends FreeSpec with ChiselScalatestTester {
    "Lab#01 Task#02 Test" in {
        test (new CounterUpDOwn(6)) {ob1 =>
        ob1.clock.step(36)
        ob1.io.result.expect(1.B)
        }
    }
}