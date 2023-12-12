package Lab_02

import chisel3._
import org.scalatest._
import chiseltest._

class Mux_1H_Test extends FreeSpec with ChiselScalatestTester{
    "Lab#02 Listing#2.10 Test" in {
        test (new Mux_1H()) { ob1 => 
        ob1.io.in0.poke(5.U)
        ob1.io.in1.poke(15.U)
        ob1.io.in2.poke(25.U)
        ob1.io.in3.poke(35.U)
        ob1.io.sel.poke(1.U)
        ob1.io.out.expect(5.U)
        ob1.clock.step(1)

        ob1.io.in0.poke(5.U)
        ob1.io.in1.poke(15.U)
        ob1.io.in2.poke(25.U)
        ob1.io.in3.poke(35.U)
        ob1.io.sel.poke(2.U)
        ob1.io.out.expect(15.U)
        ob1.clock.step(1)

        ob1.io.in0.poke(5.U)
        ob1.io.in1.poke(15.U)
        ob1.io.in2.poke(25.U)
        ob1.io.in3.poke(35.U)
        ob1.io.sel.poke(4.U)
        ob1.io.out.expect(25.U)
        ob1.clock.step(1)

        ob1.io.in0.poke(5.U)
        ob1.io.in1.poke(15.U)
        ob1.io.in2.poke(25.U)
        ob1.io.in3.poke(35.U)
        ob1.io.sel.poke(8.U)
        ob1.io.out.expect(35.U)
        ob1.clock.step(1)

        ob1.io.in0.poke(5.U)
        ob1.io.in1.poke(15.U)
        ob1.io.in2.poke(25.U)
        ob1.io.in3.poke(35.U)
        ob1.io.sel.poke(3.U)
        //ob1.io.out.expect(5.U)
        ob1.clock.step(1)
        }
    }
}