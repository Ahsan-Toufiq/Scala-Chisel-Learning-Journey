package Lab_07

import chisel3._
import org.scalatest.FreeSpec
import chiseltest._

class My_Queue_Test extends FreeSpec with ChiselScalatestTester {
  "Lab#07 Task#01 Test" in {
    test(new My_Queue()) { ob1 =>
      // Test Case 1
      ob1.io.f1.poke(0.B)
      ob1.io.f2.poke(0.B)
      ob1.io.r1.poke(0.B)
      ob1.io.r2.poke(0.B)
      ob1.clock.step(1)
      ob1.io.out.expect(0.U)

      // Test Case 2
      ob1.io.f1.poke(1.B)
      ob1.io.f2.poke(0.B)
      ob1.io.r1.poke(0.B)
      ob1.io.r2.poke(0.B)
      ob1.clock.step(1)
      ob1.io.out.expect(0.U)

      // Test Case 3
      ob1.io.f1.poke(0.B)
      ob1.io.f2.poke(1.B)
      ob1.io.r1.poke(0.B)
      ob1.io.r2.poke(0.B)
      ob1.clock.step(1)
      ob1.io.out.expect(0.U)

      // Test Case 4
      ob1.io.f1.poke(1.B)
      ob1.io.f2.poke(1.B)
      ob1.io.r1.poke(0.B)
      ob1.io.r2.poke(0.B)
      ob1.clock.step(1)
      ob1.io.out.expect(0.U)

      // Test Case 5
      ob1.io.f1.poke(0.B)
      ob1.io.f2.poke(0.B)
      ob1.io.r1.poke(1.B)
      ob1.io.r2.poke(0.B)
      ob1.clock.step(1)
      ob1.io.out.expect(0.U)

      // Test Case 6
      ob1.io.f1.poke(1.B)
      ob1.io.f2.poke(0.B)
      ob1.io.r1.poke(1.B)
      ob1.io.r2.poke(0.B)
      ob1.clock.step(1)
      ob1.io.out.expect(0.U)

      // Test Case 7
      ob1.io.f1.poke(0.B)
      ob1.io.f2.poke(1.B)
      ob1.io.r1.poke(1.B)
      ob1.io.r2.poke(0.B)
      ob1.clock.step(1)
      ob1.io.out.expect(3.U)

      // Test Case 8
      ob1.io.f1.poke(1.B)
      ob1.io.f2.poke(1.B)
      ob1.io.r1.poke(1.B)
      ob1.io.r2.poke(0.B)
      ob1.clock.step(1)
      ob1.io.out.expect(3.U)

      // Test Case 9
      ob1.io.f1.poke(0.B)
      ob1.io.f2.poke(0.B)
      ob1.io.r1.poke(0.B)
      ob1.io.r2.poke(1.B)
      ob1.clock.step(1)
      ob1.io.out.expect(0.U)

      // Test Case 10
      ob1.io.f1.poke(1.B)
      ob1.io.f2.poke(0.B)
      ob1.io.r1.poke(0.B)
      ob1.io.r2.poke(1.B)
      ob1.clock.step(1)
      ob1.io.out.expect(0.U)

      // Test Case 11
      ob1.io.f1.poke(0.B)
      ob1.io.f2.poke(1.B)
      ob1.io.r1.poke(0.B)
      ob1.io.r2.poke(1.B)
      ob1.clock.step(1)
      ob1.io.out.expect(0.U)

      // Test Case 12
      ob1.io.f1.poke(1.B)
      ob1.io.f2.poke(1.B)
      ob1.io.r1.poke(0.B)
      ob1.io.r2.poke(1.B)
      ob1.clock.step(1)
      ob1.io.out.expect(0.U)

      // Test Case 13
      ob1.io.f1.poke(0.B)
      ob1.io.f2.poke(0.B)
      ob1.io.r1.poke(1.B)
      ob1.io.r2.poke(1.B)
      ob1.clock.step(1)
      ob1.io.out.expect(7.U)

      // Test Case 14
      ob1.io.f1.poke(1.B)
      ob1.io.f2.poke(0.B)
      ob1.io.r1.poke(1.B)
      ob1.io.r2.poke(1.B)
      ob1.clock.step(1)
      ob1.io.out.expect(7.U)

      // Test Case 15
      ob1.io.f1.poke(0.B)
      ob1.io.f2.poke(1.B)
      ob1.io.r1.poke(1.B)
      ob1.io.r2.poke(1.B)
      ob1.clock.step(1)
      ob1.io.out.expect(7.U)

      // Test Case 16
      ob1.io.f1.poke(1.B)
      ob1.io.f2.poke(1.B)
      ob1.io.r1.poke(1.B)
      ob1.io.r2.poke(1.B)
      ob1.clock.step(1)
      ob1.io.out.expect(0.U)
    }
  }
}
