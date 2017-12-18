// Single line comment

/**
 * Multi-line 
 * comment
 */

module test (ONE, TWO, THREE)

assign a = b;

always @(posedge CLK)
begin
    var_binary = 8'b01010101;
    var_hex = 32'hdeadbeef;
    var_octal = 8'b01010101;

end

always @(negedge CLK_2)
begin
    var_binary = 8'b01010101;
    var_hex = 32'hdeadbeef;
    var_octal = 8'b01010101;
    var_more = 32'habadbabe;

end

endmodule