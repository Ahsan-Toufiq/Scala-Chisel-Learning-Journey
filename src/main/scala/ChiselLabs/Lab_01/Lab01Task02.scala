package Lab_01
import chisel3._

class CounterUpDOwn (max : Int) extends Module{
    val io = IO(new Bundle{
        val result = Output(Bool())
        val out = Output(UInt(8.W))
    })
    val count = RegInit(0.U(8.W))
    // "check" indicates weather to count forward or backwards
    val check = RegInit(0.U(1.W))
    io.result := 0.B
    io.out := 0.B

    when ((check === 0.U) ){
        when (count === max.asUInt-1.U){
            check := 1.U
        }
        count := count + 1.U
        io.out := count
    }
    .elsewhen ((check === 1.U)){
        when(count === 1.U){
            check := 0.U
            //io.result := 1.B
        }
        count := count - 1.U
        io.out := count
    }
        
    .otherwise{
        count := count + 5.U
        io.result := 1.B
        io.out := count
    }
    when(count === 0.U){
        io.result := 1.B
    }
}
