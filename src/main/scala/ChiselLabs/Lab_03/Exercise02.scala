package Lab_03

import chisel3._
import chisel3.util._

object ALUOP {
    // ALU Operations , may expand / modify in future
    val ALU_ADD    = 0. U (4. W )
    val ALU_SUB    = 1. U (4. W )
    val ALU_AND    = 2. U (4. W )
    val ALU_OR     = 3. U (4. W )
    val ALU_XOR    = 4. U (4. W )
    val ALU_SLT    = 5. U (4. W )
    val ALU_SLL    = 6. U (4. W )
    val ALU_SLTU   = 7. U (4. W )
    val ALU_SRL    = 8. U (4. W )
    val ALU_SRA    = 9. U (4. W )
    val ALU_COPY_A = 10. U (4. W )
    val ALU_COPY_B = 11. U (4. W )
    val ALU_XXX    = 15. U (4. W )
}

trait Config {
    // word length configuration parameter
    val WLEN = 32
    // ALU operation control signal width
    val ALUOP_SIG_LEN = 4

    val XLEN = 32
}

import ALUOP._

class ALUIO extends Bundle with Config {
    val in_A   = Input ( UInt ( WLEN . W ) )
    val in_B   = Input ( UInt ( WLEN . W ) )
    val alu_Op = Input ( UInt ( ALUOP_SIG_LEN . W ) )
    val out    = Output ( UInt ( WLEN . W ) )
    val sum    = Output ( UInt ( WLEN . W ) )
}

class ALU extends Module with Config {
    val io  = IO(new ALUIO)
    val sum = 0.U
    switch(io.alu_Op(0)){
        is (1.B){
            sum := io.in_A - io.in_B
        }
        is (0.B){
            sum := io.in_A + io.in_B
        }
    }

    val cmp = 0.U
    switch(io.in_A ( XLEN -1) === io.in_B ( XLEN -1)){
        is (1.B){
            cmp := sum ( XLEN -1)
        }
        is (0.B){
            switch (io.alu_Op(1)){
                is(1.B){
                    cmp := io.in_B ( XLEN -1)
                }
                is(0.B){
                    cmp := io.in_A ( XLEN -1)
                }
            }
        }
    }

    val shamt  = io.in_B (4 ,0).asUInt
    val shin = 0.U
    switch(io.alu_Op(3)){
        is(1.B){
            shin := io.in_A
        }
        is(0.B){
            shin := Reverse(io.in_A)
        }
    }
    //val shin   = Mux ( io.alu_Op (3) , io.in_A , Reverse ( io.in_A ) )
    val shifter = ( Cat ( io.alu_Op (0) && shin ( XLEN -1) , shin ).asSInt>>shamt ) (XLEN -1 , 0)
    val shift1 = Reverse ( shifter )
    var out = 0.U

    switch ( io.alu_Op === ALU_ADD || io.alu_Op === ALU_SUB){
        is(1.B) {
            out = sum 
        }
        is(0.B){
            switch(io.alu_Op === ALU_SLT || io.alu_Op === ALU_SLTU){
                is(1.B){
                     out = cmp
                }
                is(0.B){
                    switch(io.alu_Op === ALU_SRA || io.alu_Op === ALU_SRL){
                        is(1.B){
                            out = shifter
                        }
                        is(0.B){
                            switch(io.alu_Op === ALU_SLL){
                                is(1.B){
                                    out = shift1
                                }
                                is(0.B){
                                    switch(io.alu_Op === ALU_AND){
                                        is(1.B){
                                            out = io.in_A & io.in_B
                                        }
                                        is(0.B){
                                            switch(io.alu_Op === ALU_OR){
                                                is(1.B){
                                                    out = io.in_A | io.in_B
                                                }
                                                is(0.B){
                                                    switch(io.alu_Op === ALU_XOR){
                                                        is(1.B){
                                                            out = io.in_A ^ io.in_B
                                                        }
                                                        is(0.B){
                                                            switch(io.alu_Op === ALU_COPY_A){
                                                                is(1.B){
                                                                    out = io.in_A
                                                                }
                                                                is(0.B){
                                                                    switch(io.alu_Op === ALU_COPY_A){
                                                                        is(1.B){
                                                                            out = io.in_B
                                                                        }
                                                                        is(0.B){
                                                                            out = 0.U                                                                    
                                                                        }  
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    io.out := out
    io.sum := sum
}