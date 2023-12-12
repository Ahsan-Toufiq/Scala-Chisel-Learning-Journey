package Lab_06

import chisel3 . _
import chisel3 . util . _

class Counter ( val max : Int , val min : UInt = 0.U) extends Module {
    val io = IO ( new Bundle {
    val out = Output(UInt(log2Ceil(max).W))
    })
    
    val counter = RegInit (0.U(log2Ceil(max).W ) )
    // If the max count is of power 2 and the min value = 0 ,
     
    // then we can skip the comparator and the Mux
    val count_buffer = if( isPow2 ( max ) && ( min == 0.U) ) counter + 1. U
    else Mux ( counter === max.asUInt , min.asUInt , counter + 1. U )
    counter := count_buffer

    counter := count_buffer

    io . out := counter
}