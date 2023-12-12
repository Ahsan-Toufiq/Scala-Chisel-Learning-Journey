package Lab_06

import chisel3 . _
import chisel3 . util . _

import chisel3._
import chisel3.util._

class UpDownCounter(val max: Int = 10) extends Module {
    val io = IO(new Bundle {
    val out = Output(UInt(log2Ceil(max).W))
    val up_down = Input(Bool())
  })

   val counter = RegInit(0.U(log2Ceil(max).W))

   when(io.up_down) {
    counter := counter + 1.U
  
  }.otherwise {
    counter := counter - 1.U
  }

  when(counter === (max - 1).U && io.up_down) {
    counter := 0.U
  
  }.elsewhen(counter === 0.U && !io.up_down) {
    counter := (max - 1).U
  }

  io.out := counter
}