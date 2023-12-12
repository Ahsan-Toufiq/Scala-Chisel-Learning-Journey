package Lab_06

import chisel3._
import org.scalatest._
import chiseltest._

class shift_reg_with_parallel_load_Test extends FreeSpec with ChiselScalatestTester{
   "Lab#06 Task#03 Test" in{ 
       test(new shift_reg_with_parallel_load(4)){ob1 =>
       
       ob1.io.in.poke(1.B)
       ob1.io.load.poke(1.B)
       ob1.io.load_in(0).poke(0.B)
       ob1.io.load_in(1).poke(1.B)
       ob1.io.load_in(2).poke(1.B)
       ob1.io.load_in(3).poke(1.B)
       
       //ob1.clock.step(1)
       ob1.clock.step(1)
       ob1.io.in.poke(1.B)
       ob1.io.load.poke(0.B)
       ob1.io.load_in(0).poke(0.B)
       ob1.io.load_in(1).poke(0.B)
       ob1.io.load_in(2).poke(0.B)
       ob1.io.load_in(3).poke(0.B)
       
       ob1.clock.step(1)
       ob1.clock.step(1)
       ob1.clock.step(1)
       }
    }
}