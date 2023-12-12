package Lab_01

import chisel3._
import org.scalatest._
import chiseltest._

class Lab01Ex02Test extends FreeSpec with ChiselScalatestTester {
    "Lab#01 Exercise#02 Test" in {
        test (new CounterResetToZero(3.U)){ob1=>
        ob1.clock.step(19)
        //ob1.io.result.expect(0.U)
        }
    }  
}
