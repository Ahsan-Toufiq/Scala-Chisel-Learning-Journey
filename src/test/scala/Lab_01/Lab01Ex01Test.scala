package Lab_01

import chisel3._
import org.scalatest._
import chiseltest._

class Lab01Ex01Test extends FreeSpec with ChiselScalatestTester{
    "Lab#01 Exercise#01 Test" in{
        test(new Counter_SInt(2.S)){ob1 =>
        ob1.clock.step(50)
        ob1.io.result.expect(1.B)}
    }

} 
