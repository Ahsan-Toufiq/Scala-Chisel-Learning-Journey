package practice
import chisel3._

class MUX extends Module{
    val io = IO(new Bundle{
        val a = Input(UInt(4.W))
        val b = Input(UInt(4.W))
        val sel = Input(UInt(3.W))
        val out = Output(UInt(5.W))
    })
    when (io.sel === 0.U) {
        io.out := io.a & io.b ;
    }
    .elsewhen (io.sel === 1.U) {
        io.out := io.a | io.b
    }
    .elsewhen (io.sel === 2.U) {
        io.out := io.a ^ io.b
    }
    .elsewhen (io.sel === 3.U) {
        io.out := ~(io.a & io.b)
    }
    .elsewhen (io.sel === 4.U) {
        io.out := ~(io.a | io.b)
    }
    .elsewhen (io.sel === 5.U) {
        io.out := ~(io.a ^ io.b)
    }
    .otherwise {
        io.out := (0.U)
    }    

}