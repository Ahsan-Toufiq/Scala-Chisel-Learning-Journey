package Lab_05

import chisel3._

class Operator[T <: Data](n: Int, generic: T)(op: (T, T) => T) extends Module {
  require(n > 0) // " reduce only works on non - empty Vecs "

  val io = IO(new Bundle {
    val in = Input(Vec(n, generic))
    val out = Output(Vec(n, generic))
  })

  for (i <- 0 until n) {
    io.out(i) := io.in(i)
  }

  for (i <- 1 until n) {
    io.out(i) := op(io.out(i - 1), io.in(i))
  }
}
