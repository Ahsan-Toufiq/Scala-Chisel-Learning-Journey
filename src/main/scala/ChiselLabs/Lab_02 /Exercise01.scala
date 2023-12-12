package Lab_02

import chisel3._

class Mux_2to1_CombinationalLogic extends Module {
    val io = IO(new Mux_2to1_IO())
    io.out := 0.U

    when (io.select === 0.B){
        io.out := io.in_A 
    }
    .elsewhen (io.select === 1.B){
        io.out := io.in_B
    }
}