package Lab_02

import chisel3._
import org.scalatest._
import chiseltest._

class barrel_shift_Test extends FreeSpec with ChiselScalatestTester{
    "Lab#02 Task#02 Test" in {
            
        test (new barrel_shift()) { ob1 =>
        ob1.io.in(0).poke(1.B)
        ob1.io.in(1).poke(1.B)
        ob1.io.in(2).poke(0.B)    
        ob1.io.in(3).poke(1.B)

        ob1.io.sel(0).poke(0.B)
        ob1.io.sel(1).poke(0.B)

        ob1.io.shift_type.poke(1.B)

        ob1.io.out(0).expect(1.B)
        ob1.io.out(1).expect(1.B)
        ob1.io.out(2).expect(1.B)
        ob1.io.out(3).expect(1.B)
        }
    }
}