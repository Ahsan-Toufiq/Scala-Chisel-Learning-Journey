package Lab_08

import chisel3._
import chisel3.util._
//import chisel3.iotesters._

class Instruction_Stream extends Module {
  val io = IO(new Bundle {
    val writeEnable = Input(Bool())
    val address = Input(UInt(8.W))
    val dataIn = Input(UInt(32.W))
    val readEnable = Input(Bool())
    val dataOut = Output(UInt(32.W))
  })

  val memory = SyncReadMem(256, UInt(32.W))

  when(io.writeEnable) {
    memory.write(io.address, io.dataIn)
  }

  io.dataOut := 0.U
  when(io.readEnable) {
    io.dataOut := memory.read(io.address)
  }
}
