package Lab_08

import chisel3._
import chisel3.util._

class TwoBankedMemory extends Module {
  val width: Int = 8
  val numBanks: Int = 2

  val io = IO(new Bundle {
    val enable = Input(Bool())
    val write = Input(Bool())
    val addr = Input(UInt(10.W))
    val mask = Input(Vec(numBanks, Bool()))
    val dataIn = Input(Vec(numBanks, UInt(width.W)))
    val dataOut = Output(Vec(numBanks, UInt(width.W)))
  })

  val mem = Seq.fill(numBanks)(SyncReadMem(1024, UInt(width.W)))

  for (i <- 0 until numBanks) {
    when(io.write && io.enable && io.mask(i)) {
      mem(i).write(io.addr, io.dataIn(i))
    }
  }

  io.dataOut := VecInit(mem.map(_.read(io.addr, io.enable)))
}