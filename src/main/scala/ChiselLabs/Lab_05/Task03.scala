package Lab_05
import chisel3._

class InclusiveTypecastedEMux[T <: Data, U <: Data](genT: T, genU: U) extends Module {
  val io = IO(new Bundle {
    val sel = Input(Bool())
    val inT = Input(genT)
    val inU = Input(genU)
    val out = Output(genT.cloneType)
  })

  io.out := Mux(io.sel, io.inT.asTypeOf(genT), io.inU.asTypeOf(genT))
}