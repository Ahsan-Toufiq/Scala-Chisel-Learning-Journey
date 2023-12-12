package Lab_01

import chisel3._
import org.scalatest._
import chiseltest._

class Lab01Ex03Test extends FreeSpec with ChiselScalatestTester{
    "Lab#01 Exercise#03 Test" in {
        test (new CounterMaxParam(5,11)) {ob1 =>
        ob1.clock.step(20)
        }
    }
}