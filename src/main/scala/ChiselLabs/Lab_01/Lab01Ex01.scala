package Lab_01

import chisel3._

class Counter_SInt ( counterBits : SInt ) extends Module {
    val io = IO (new Bundle {
    val result = Output ( Bool() )
    })

    val max = (1.U << counterBits.asUInt ) - 1.U
    val count = RegInit (0.S (16. W ))
    io . result := 0.B
    
    when ( count === max.asSInt ) {
    count := 0.S
    io . result := 1.B
    } 

    .otherwise {
    count := count + 1.S
    }

    println ( s" counter created with max value $max ")

}