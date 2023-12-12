package Lab_06

import chisel3._
import chisel3.util._

class My_Queue extends Module {
    val io = IO ( new Bundle {
        val in = Flipped ( Decoupled ( UInt (4.W) ) ) 
        // val in1 = Flipped ( Decoupled ( UInt (4.W) ) ) 
        val out = Decoupled ( UInt (4.W ) ) 
    })
val queue = Queue ( io.in , 5) 
val queue1 = Queue ( queue , 5) 
io.out <> queue1
}