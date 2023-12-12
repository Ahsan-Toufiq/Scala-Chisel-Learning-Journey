package Lab_06

import chisel3._

class shift_register(val init: Int = 1) extends Module {
  val io = IO(new Bundle {
    val parallelLoad = Input(Bool())
    val parallelData = Input(UInt(4.W))
    val in = Input(Bool())
    val out = Output(UInt(4.W))
  })

  val state = RegInit(init.U(4.W))

  when(io.parallelLoad) {
    state := io.parallelData
  }.otherwise {
    val nextState = (state << 1) | io.in
    state := nextState
  }

  io.out := state
}
