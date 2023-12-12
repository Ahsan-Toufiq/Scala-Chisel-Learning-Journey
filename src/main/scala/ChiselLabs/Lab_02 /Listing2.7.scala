package Lab_02

import chisel3._

class Mux_4to1_Priority_IO extends Bundle {
    val in = Input ( UInt (4. W ) )
    val s1 = Input ( Bool () )
    val s2 = Input ( Bool () )
    val s3 = Input ( Bool () )
    val out = Output ( Bool () ) // UInt (1. W))
}

class Mux_4to1_Priority extends Module {
    val io = IO (new Mux_4to1_Priority_IO() )
    io.out := Mux ( io.s3 , io.in(3) , 
    Mux( io.s2 , io.in(2) , 
    Mux( io.s1 , io.in(1) , io.in(0) ) ) )
}