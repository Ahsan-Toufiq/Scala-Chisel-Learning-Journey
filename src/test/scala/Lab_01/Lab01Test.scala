package Lab_01

import chisel3._
import org.scalatest._
import chiseltest._

class Lab01Test extends FreeSpec with ChiselScalatestTester {
    "Lab 01 Test" in {
        test(new Counter(1))
    }  
}
