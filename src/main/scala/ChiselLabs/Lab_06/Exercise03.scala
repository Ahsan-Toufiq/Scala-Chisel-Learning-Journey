package Lab_06

import chisel3._
import chisel3.util._


class TwoShotTimer extends Module {
  val io = IO(new Bundle {
    val reload = Input(Bool())
    val din = Input(UInt(8.W))
    val out = Output(Bool())
  })

  val idle :: firstShot :: secondShot :: Nil = Enum(3)
  val state = RegInit(idle)

  val timer_count = RegInit(0.U(8.W))
  val done = timer_count === 0.U
  val next = WireInit(0.U)

  switch(state) {
    is(idle) {
      when(io.reload) {
        state := firstShot
        next := io.din
      }
    }
    is(firstShot) {
      when(!done) {
        next := timer_count - 1.U
      }.otherwise {
        state := secondShot
        next := io.din
      }
    }
    is(secondShot) {
      when(!done) {
        next := timer_count - 1.U
      }.otherwise {
        state := idle
        next := 0.U
      }
    }
  }

  timer_count := next

  io.out := state === secondShot && done
}
