package Lab_05

import chisel3._
import chisel3.util._

class Transaction_in[T <: Data](gen: T) extends Bundle {
  val address = UInt(10.W)
  val data = gen.cloneType
}

class Transaction_out[T <: Data](gen: T) extends Bundle {
  val address = UInt(10.W)
  val data = gen.cloneType
}

class Router[T <: Data](gen: T) extends Module {
  val io = IO(new Bundle {
    val in = Input(new Transaction_in(gen))
    val out = Output(new Transaction_out(gen))
  })
  io.out := io.in
}
