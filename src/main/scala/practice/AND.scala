package practice 

import chisel3._

class AND extends Module{
	val io = IO(new Bundle{
		val a = Input(SInt(4.W))
		val b = Input(SInt(2.W))
		val c = Output(SInt(4.W))
		val d = Output(SInt())

	})
	io.c := io.a -% io.b
	io.d := io.a +& io.b 
}