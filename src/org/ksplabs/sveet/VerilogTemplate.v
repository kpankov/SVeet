module pwm (clk, pwm, pulse_width_control);
input clk;
input [9:0] pulse_width_control;
output pwm; 

wire pwm;
wire counter_full, counter_eq_pw_control;
wire [9:0] counter, pw_control;

ten_bit_counter ten_bit_counter_1 (
                           .ck(clk),
                           .Q(counter));
register register_1(
			.ck(clk),
			.en(counter_full),
			.D(pulse_width_control),
			.Q(pw_control));
   structural_comparitor comparitor_1 (    // flip between explicit and implicit structural prototypes
// implicit_structural_comparitor comparitor_1 (	// by commenting out the one not wanted
			.A(counter),
			.B(pw_control),
			.A_eq_3FF(counter_full),
			.A_eq_B(counter_eq_pw_control));
sc_ff sc_ff_1 (
			.set(counter_full),
			.clear(counter_eq_pw_control),
			.ck(clk),
			.Q(pwm));

endmodule



module register(
			ck, en, D, Q);
input ck, en;
input [9:0] D;
output [9:0] Q;

reg [9:0] Q;

always @ (posedge ck)
	if (en==1) Q <= D;
	else Q <= Q;
endmodule

module structural_comparitor( A, B, A_eq_3FF, A_eq_B);
input [9:0] A, B;
output A_eq_3FF, A_eq_B;

wire [9:0] xnor_out;

	and and_0 (A_eq_3FF, A[9],A[8],A[7],A[6],A[5],A[4],A[3],A[2],A[1],A[0]);

    xnor xnor_0 (xnor_out[0], A[0], B[0] );
    xnor xnor_1 (xnor_out[1], A[1], B[1] );
    xnor xnor_2 (xnor_out[2], A[2], B[2] );
    xnor xnor_3 (xnor_out[3], A[3], B[3] );
    xnor xnor_4 (xnor_out[4], A[4], B[4] );
    xnor xnor_5 (xnor_out[5], A[5], B[5] );
    xnor xnor_6 (xnor_out[6], A[6], B[6] );
    xnor xnor_7 (xnor_out[7], A[7], B[7] );
    xnor xnor_8 (xnor_out[8], A[8], B[8] );
    xnor xnor_9 (xnor_out[9], A[9], B[9] );

	and and_1 (A_eq_B, xnor_out[9],xnor_out[8],xnor_out[7],
						xnor_out[6],xnor_out[5],xnor_out[4],
						xnor_out[3],xnor_out[2],xnor_out[1],
						xnor_out[0]);
endmodule

module implicit_structural_comparitor( A, B, A_eq_3FF, A_eq_B);
input [9:0] A, B;
output A_eq_3FF, A_eq_B;

assign A_eq_3FF = & A;
assign A_eq_B = &(A ^~ B);

endmodule


module ten_bit_counter (ck, Q);
input ck;
output [9:0] Q;

reg [9:0] Q;

always @(posedge ck)
	Q=Q+1;
endmodule


module sc_ff (set, clear, ck, Q);
input set, clear, ck;
output Q;

 wire D, Q;

 assign D = (~clear & Q) | set;

 DFF dff_1 (.D(D), .CLK(ck), .CLRN(1'b1), .PRN(1'b1), .Q(Q));


//reg Q;

//always @ (posedge ck)
//if (set==1) Q <= 1'b1;
//	else if (clear == 1) Q <= 1'b0;
//	else Q <= Q;
	
endmodule	
