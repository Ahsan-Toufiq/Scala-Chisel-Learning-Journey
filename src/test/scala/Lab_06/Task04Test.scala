package Lab_06

import chisel3._
import org.scalatest._
import chiseltest._

class UpDownCounter_Test extends FreeSpec with ChiselScalatestTester{
   "Lab#06 Task#04 Test" in{ 
       test(new UpDownCounter(13)){ob1 =>

       ob1.clock.step(31)
       }
    }
}