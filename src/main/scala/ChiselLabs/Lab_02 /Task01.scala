package Lab_02

import chisel3._
import chisel3.util._

class LM_IO_Interface_Task02 extends Bundle {
val s0 = Input ( Bool () )
val s1 = Input ( Bool () )
val s2 = Input ( Bool () )
val out = Output ( UInt (32. W ) )
}

class Mux_5to1 extends Module {
    val io = IO (new LM_IO_Interface_Task02 )

    io.out := Mux1H(Array(io.s2,io.s1,io.s0),Seq(32.U,16.U,8.U))

}
