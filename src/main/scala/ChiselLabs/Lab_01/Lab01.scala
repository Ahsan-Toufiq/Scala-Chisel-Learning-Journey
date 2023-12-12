package Lab_01

import chisel3._

class Counter ( counterBits : Int ) extends Module {
    val io = IO(new Bundle{
    val max = (1 << counterBits ) - 1
    var count = 0
    
    if( count == max ) {
    count = 0
    }
    else {
    count = count + 1
    }
    println ( s" counter created with max value $max ")
})
}
