// package Lab_07

// import chisel3._
// import chisel3.util._

// class Manchester_Encoding extends Module {
//   // Define State as a Chisel Enum
//   sealed trait State
//   case object IDLE extends State
//   case object PROCESS extends State

//   val io = IO(new Bundle {
//     val in = Input(UInt(1.W))
//     val start = Input(Bool())
//     val out = Output(UInt(8.W))
//     val flag = Output(UInt(1.W))
//   })

//   // Define registers
//   val stateReg = RegInit(IDLE: State)
//   val dataReg = RegInit(0.U(8.W))

//   // FSM logic
//   switch(stateReg) {
//     is(IDLE) {
//       when(io.start) {
//         stateReg := PROCESS
//       }
//     }

//     is(PROCESS) {
//       when(io.in === 1.U) {
//         dataReg := Cat(dataReg(6, 0), 1.U)
//       }.elsewhen(io.in === 0.U) {
//         dataReg := Cat(dataReg(6, 0), 0.U)
//       }

//       when(dataReg(7, 0) === "b01111110".U) {
//         stateReg := IDLE
//         io.flag := 1.U
//       }.otherwise {
//         io.flag := 0.U
//       }
//     }

//   }

//   // Output
//   io.out := dataReg
// }
