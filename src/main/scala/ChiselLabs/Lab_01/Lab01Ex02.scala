package Lab_01
import chisel3._    

class CounterResetToZero ( counterBits : UInt ) extends Module {
    val io = IO(new Bundle{
    val result = Output(UInt(3.W))
    })
    val max = 8.U//(1.U << counterBits ) - 1.U
    val count = RegInit (0.U(3.W))
    
    when( (count(2))  === 1.U ) {
    count := 0.U
    }
    .otherwise {
    count := count + 1.U
    }
    io.result := count    
}
