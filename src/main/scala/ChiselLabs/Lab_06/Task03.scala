package Lab_06

import chisel3._
import chisel3.util._

class shift_reg_with_parallel_load ( val len : Int =1) extends Module {
val io = IO ( new Bundle {
    val out = Vec ( len , Output ( Bool ()))
    val load_in = Vec ( len , Input ( Bool () ) )
    val in = Input ( Bool () )
    val load = Input ( Bool () )
    })

    val temp = RegInit(VecInit(Seq.fill(len)(false.B)))
    val c = RegInit(0.U)
    dontTouch(temp)
    
    for ( i <- (len-1) until 0 by -1){//1 until len-0){
        temp(i) := Mux(io.load , io.load_in(i) , temp(i-1))

    }

    temp(0) := Mux (io.load , io.load_in(0) , io.in)

    
    io.out := temp
}