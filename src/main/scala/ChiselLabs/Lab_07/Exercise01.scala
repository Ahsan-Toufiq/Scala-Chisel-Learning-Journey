package Lab_07

import chisel3._
import chisel3.util._

class Priority_arb extends Module {
    val io = IO (new Bundle {
        val in1 =  Flipped ( Decoupled ( UInt (4.W ) ) )
        val in2 =  Flipped ( Decoupled ( UInt (4.W ) ) )
        val out =  Decoupled ( UInt (4.W ) ) 
    })

    val queue = Queue(io.in1 , 5)
    val queue1 = Queue(io.in2 , 5)

    val arb_priority = Module (new Arbiter ( UInt () , 2) )

    arb_priority.io.in (0) <> queue
    arb_priority.io.in (1) <> queue1

    io.out <> arb_priority.io.out
}