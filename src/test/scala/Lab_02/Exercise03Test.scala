package Lab_02

import chisel3._
import org.scalatest._
import chiseltest._

class Mux_1H_4to2Encoder_Test extends FreeSpec with ChiselScalatestTester{
    "Lab#02 Exercise#03 Test" in {
        test (new Mux_1H_4to2Encoder()) { ob1 => 
        ob1.io.sel.poke("b0000".U)
        ob1.io.out.expect("b00".U)
        ob1.clock.step(1)

        ob1.io.sel.poke("b0001".U)
        //ob1.io.out.expect("b01".U)
        ob1.clock.step(1)

        ob1.io.sel.poke("b0010".U)
        //ob1.io.out.expect("b01".U)
        ob1.clock.step(1)

        ob1.io.sel.poke("b0011".U)
        //ob1.io.out.expect("b10".U)
        ob1.clock.step(1)

        
        ob1.io.sel.poke("b0100".U)
        //ob1.io.out.expect("b01".U)
        ob1.clock.step(1)

        ob1.io.sel.poke("b0101".U)
        //ob1.io.out.expect("b10".U)
        ob1.clock.step(1)

        ob1.io.sel.poke("b0110".U)
        //ob1.io.out.expect("b10".U)
        ob1.clock.step(1)

        ob1.io.sel.poke("b0111".U)
        //ob1.io.out.expect("b11".U)
        ob1.clock.step(1)

        ob1.io.sel.poke("b1000".U)
        //ob1.io.out.expect("b01".U)
        ob1.clock.step(1)

        ob1.io.sel.poke("b1001".U)
        //ob1.io.out.expect("b10".U)
        ob1.clock.step(1)

        ob1.io.sel.poke("b1010".U)
        //ob1.io.out.expect("b10".U)
        ob1.clock.step(1)

        ob1.io.sel.poke("b1011".U)
        //ob1.io.out.expect("b11".U)
        ob1.clock.step(1)

        ob1.io.sel.poke("b1100".U)
        //ob1.io.out.expect("b10".U)
        ob1.clock.step(1)

        ob1.io.sel.poke("b1101".U)
        //ob1.io.out.expect("b11".U)
        ob1.clock.step(1)

        ob1.io.sel.poke("b1110".U)
        //ob1.io.out.expect("b11".U)
        ob1.clock.step(1)
        
        ob1.io.sel.poke("b1111".U)
        //ob1.io.out.expect("b11".U)
        ob1.clock.step(1)

        

        }
    }
}