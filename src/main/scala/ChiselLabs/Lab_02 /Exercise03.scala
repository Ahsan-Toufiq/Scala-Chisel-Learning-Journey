package Lab_02

import chisel3._
import chisel3.util._

class Mux_1H_4to2Encoder extends Module {
    val io = IO(new Bundle{
        val sel = Input(UInt(4.W))
        val out = Output (UInt(2.W))
    })
    println(io.sel.asBools)
    val Out = Mux1H(io.sel.asBools, Seq(0.U,1.U,2.U,3.U))
    io.out := Out
}