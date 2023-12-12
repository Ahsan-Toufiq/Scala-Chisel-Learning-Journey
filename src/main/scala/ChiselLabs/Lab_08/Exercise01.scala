package Lab_08

import chisel3._
import chisel3.util._

class MaskedReadWriteSmem extends Module {
  val width: Int = 8
  val io = IO(new Bundle {
    val enable = Input(Bool())
    val write = Input(Bool())
    val addr = Input(UInt(10.W))
    val mask = Input(Vec(4, Bool()))
    val dataIn = Input(Vec(4, UInt(width.W)))
    val dataOut = Output(Vec(4, UInt(width.W)))
  })

  // Create a 32-bit wide memory that is byte-masked
  val mem = SyncReadMem(1024, Vec(4, UInt(width.W)))

  // Write with mask
  when(io.write && io.enable) {
    val newData = Wire(Vec(4, UInt(width.W)))
    for (i <- 0 until 4) {
      newData(i) := Mux(io.mask(i), io.dataIn(i), mem.read(io.addr)(i))
    }
    mem.write(io.addr, newData)
  }

  io.dataOut := mem.read(io.addr, io.enable)
}