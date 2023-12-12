package Lab_06

import chisel3._
import org.scalatest._
import chiseltest._

class counter_Test extends FreeSpec with ChiselScalatestTester{
   "Lab#06 Task#01 Test" in{
       test(new counter(4,0))
       test(new counter(10,0))
    }      
}