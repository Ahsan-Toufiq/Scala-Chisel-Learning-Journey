package Lab_06

import chisel3._
import org.scalatest._
import chiseltest._

class XOR_counter_Test extends FreeSpec with ChiselScalatestTester{
   "Lab#06 Task#02 Test" in{ 
       test(new XOR_counter(125)){ob1 =>
       ob1.clock.step(200)
       }
    }
}  