package Lab_02

import chisel3._
import chisel3.util._

class barrel_shift extends Module {
    val io = IO (new Bundle {
    val in = Vec (4 , Input ( Bool () ) )
    val sel = Vec (2 , Input ( Bool () ) )
    val shift_type = Input ( Bool () )
    val out = Vec (4 , Output ( Bool () ) )
    })

    io.out(0) := MuxLookup(Cat(io.sel(0),io.sel(1)),false.B,Array(
        (0.U)  -> io.in(0),
        (1.U)  -> io.in(1),
        (2.U)  -> io.in(2),
        (3.U)  -> io.in(3))
    )

    io.out(1) := MuxLookup(Cat(io.sel(0),io.sel(1)),false.B,Array(
        (0.U)  -> io.in(0),
        (1.U)  -> io.in(1),
        (2.U)  -> io.in(2),
        (3.U)  -> Mux(io.shift_type,io.in(3),0.B))
    )

    io.out(2) := MuxLookup(Cat(io.sel(0),io.sel(1)),false.B,Array(
        (0.U)  -> io.in(0),
        (1.U)  -> io.in(1),
        (2.U)  -> Mux(io.shift_type,io.in(2),0.B),
        (3.U)  -> Mux(io.shift_type,io.in(3),0.B))
    )

    io.out(3) := MuxLookup(Cat(io.sel(0),io.sel(1)),false.B,Array(
        (0.U)  -> io.in(0),
        (1.U)  -> Mux(io.shift_type,io.in(1),0.B),
        (2.U)  -> Mux(io.shift_type,io.in(2),0.B),
        (3.U)  -> Mux(io.shift_type,io.in(3),0.B))
    )
}