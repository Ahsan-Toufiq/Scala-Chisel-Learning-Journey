package Lab_03

import chisel3._
import org.scalatest._
import chiseltest._

class decoder_with_valid_Test extends FreeSpec with ChiselScalatestTester{
    "Lab#03 Task#03 Test" in {
        test(new decoder_with_valid){ ob1 =>
        
        ob1.io.in.poke("b00".U)
        ob1.clock.step(1)

        ob1.io.in.poke("b01".U)
        ob1.clock.step(1)

        ob1.io.in.poke("b10".U)
        ob1.clock.step(1)

        ob1.io.in.poke("b11".U)
        ob1.clock.step(1)

        }
    }
}