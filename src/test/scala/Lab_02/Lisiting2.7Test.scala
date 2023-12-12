    package Lab_02

    import chisel3._
    import org.scalatest._
    import chiseltest._

class Mux_4to1_Priority_Test extends FreeSpec with ChiselScalatestTester{
    "Lab#02 Listing#2.7 Test" in {
        test (new Mux_4to1_Priority()) { ob1 =>

       //     ob1.clock.step(2)

            ob1.io.in.poke("b0111".U)
            ob1.io.s1.poke(0.B)
            ob1.io.s2.poke(1.B)
            ob1.io.s3.poke(1.B)
            ob1.io.out.expect(0.B)
            
            ob1.clock.step(1)

            ob1.io.in.poke("b0100".U)
            ob1.io.s1.poke(0.B)
            ob1.io.s2.poke(1.B)
            ob1.io.s3.poke(0.B)
            ob1.io.out.expect(1.B)

            ob1.clock.step(1)

            ob1.io.in.poke("b1101".U)
            ob1.io.s1.poke(1.B)
            ob1.io.s2.poke(0.B)
            ob1.io.s3.poke(0.B)
            ob1.io.out.expect(0.B)

            ob1.clock.step(1)

            ob1.io.in.poke("b0001".U)
            ob1.io.s1.poke(0.B)
            ob1.io.s2.poke(0.B)
            ob1.io.s3.poke(0.B)
            ob1.io.out.expect(1.B)

            ob1.clock.step(1)
        }
    }
}