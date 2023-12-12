package Lab_02

import chisel3._
import org.scalatest._
import chiseltest._

class MuxLookup_Test extends FreeSpec with ChiselScalatestTester {
    " Lab#02 Listing#2.9 Test" in {
        test (new MuxLookup()) { ob1 =>
        ob1.io.in0.poke(0.B)
        ob1.io.in1.poke(1.B)
        ob1.io.in2.poke(0.B)
        ob1.io.in3.poke(1.B)
        ob1.io.in4.poke(0.B)
        ob1.io.in5.poke(1.B)
        ob1.io.in6.poke(0.B)
        ob1.io.in7.poke(1.B)

        ob1.io.sel.poke("b110".U)

        ob1.io.out.expect(0.B)
        ob1.clock.step(1)

        ob1.io.in0.poke(0.B)
        ob1.io.in1.poke(1.B)
        ob1.io.in2.poke(0.B)
        ob1.io.in3.poke(1.B)
        ob1.io.in4.poke(0.B)
        ob1.io.in5.poke(1.B)
        ob1.io.in6.poke(0.B)
        ob1.io.in7.poke(1.B)

        ob1.io.sel.poke("b101".U)

        ob1.io.out.expect(1.B)
        ob1.clock.step(1)
        }
    }
}
