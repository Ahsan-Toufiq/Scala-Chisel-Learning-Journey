// package Lab_07

// import chisel3._
// import org.scalatest.FreeSpec
// import chiseltest._

// class Manchester_Encoding_Test extends FreeSpec with ChiselScalatestTester {
//   "Lab#07 Task#02 Test" in {
//     test(new Manchester_Encoding()) { ob1 =>
//       // Test case 1
//       ob1.io.in.poke(0.U)
//       ob1.io.start.poke(false.B)
//       ob1.clock.step(1)
//       ob1.io.out.expect("b00000000".U)
//       ob1.io.flag.expect(0.U)

//       // Test case 2
//       ob1.io.in.poke(0.U)
//       ob1.io.start.poke(true.B)
//       ob1.clock.step(1)
//       ob1.io.out.expect("b00000000".U)
//       ob1.io.flag.expect(0.U)

//       // Test case 3
//       ob1.io.in.poke(1.U)
//       ob1.clock.step(1)
//       ob1.io.in.poke(0.U)
//       ob1.clock.step(1)
//       ob1.io.in.poke(1.U)
//       ob1.clock.step(1)
//       ob1.io.in.poke(0.U)
//       ob1.clock.step(1)
//       ob1.io.out.expect("b00001010".U)
//       ob1.io.flag.expect(0.U)

//       // Test case 4
//       ob1.io.in.poke(0.U)
//       ob1.clock.step(1)
//       ob1.io.in.poke(1.U)
//       ob1.clock.step(1)
//       ob1.io.in.poke(1.U)
//       ob1.clock.step(1)
//       ob1.io.in.poke(1.U)
//       ob1.clock.step(1)
//       ob1.io.in.poke(1.U)
//       ob1.clock.step(1)
//       ob1.io.in.poke(1.U)
//       ob1.clock.step(1)
//       ob1.io.in.poke(1.U)
//       ob1.clock.step(1)
//       ob1.io.in.poke(0.U)
//       ob1.clock.step(1)
//       ob1.io.out.expect("b01111110".U)
//       ob1.io.flag.expect(1.U)
//     }
//   }
// }
