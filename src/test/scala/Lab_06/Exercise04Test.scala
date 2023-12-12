package Lab_06

import chisel3._
import org.scalatest.FreeSpec
import chiseltest._

class My_Queue_Test extends FreeSpec with ChiselScalatestTester{
   "Lab#06 Exercise#04 Test" in{
       test(new My_Queue ()){c =>
          c.io.in.bits.poke(2.U)
          c.io.in.valid.poke(1.B)
          c.clock.step(5) 
          c.io.out.bits.expect(2.U)
          c.io.out.valid.expect(1.B)
          c.io.out.ready.expect(0.B)
    }
    }      
}