package practice

import chisel3._
import org.scalatest._
import chiseltest._

class ANDtest extends FreeSpec with ChiselScalatestTester {

    "And Gate Test" in {
        test(new AND()){c =>
        c.io.a.poke(7.S)
        c.io.b.poke(1.S)
        c.clock.step(1)
        //c.io.c.expect(-2.S)
        }
    }
}