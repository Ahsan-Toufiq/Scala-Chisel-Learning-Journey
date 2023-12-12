package practice

import chisel3._

class FullAdder extends Module{
    val io = IO(new Bundle{
        val a = Input(Bool())
        val b = Input(Bool())
        val cin = Input(Bool())
        val sum = Output(Bool())
        val cout = Output(Bool())
    })
    io.sum := (io.a ^ io.b) ^ io.cin
    io.cout := (io.a & io.b) | ((io.a ^ io.b) & io.cin)
}