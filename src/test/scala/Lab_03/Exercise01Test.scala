package Lab_03

import chisel3._
import org.scalatest._
import chiseltest._

class Decoder_4to2_Switch_Test extends FreeSpec with ChiselScalatestTester{
    "Lab#03 Exercise#01 Test" in {
        test(new Decoder_4to2_Switch()) {ob1 =>
        ob1.io.in .poke("b0000".U)
        // ob1.io.out.expect("b0000".U)
        ob1.clock.step(1)

        ob1.io.in .poke("b0001".U)
        // ob1.io.out.expect("b0000".U)
        ob1.clock.step(1)
        
        ob1.io.in .poke("b0010".U)
        // ob1.io.out.expect("b01".U)
        ob1.clock.step(1)
        
        ob1.io.in .poke("b0100".U)
        // ob1.io.out.expect("b10".U)
        ob1.clock.step(1)
        
        ob1.io.in .poke("b1000".U)
        // ob1.io.out.expect("b11".U)
        ob1.clock.step(1)
        
        }
    }
}