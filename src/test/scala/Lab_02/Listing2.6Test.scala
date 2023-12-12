package Lab_02

import chisel3._
import org.scalatest._
import chiseltest._

class Mux_8to1_Test extends FreeSpec with ChiselScalatestTester {
    "Lab#02 Listing#2.6 Test" in {
        test (new Mux_8to1_EqualP()) { ob1 => 
        
        ob1.io.in.poke("b11011111".U)
        ob1.io.s0.poke(1.B)
        ob1.io.s1.poke(0.B)
        ob1.io.s2.poke(1.B)
        ob1.io.out.expect(0.B)
        
        ob1.clock.step(2)

        ob1.io.in.poke("b00000010".U)
        ob1.io.s0.poke(1.B)
        ob1.io.s1.poke(0.B)
        ob1.io.s2.poke(0.B)
        ob1.io.out.expect(1.B)

        ob1.clock.step(3)
        
        }

    }
}