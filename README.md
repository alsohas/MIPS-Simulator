# Mips Simulator

Pipelining has not been implemented.
32 bit addressable memory is available.
Currently 16 registers are supported with an additional `$zero` register.

Currently supported instructions are: `add`, `sub`, `or`, `and`, `sw`, `lw`
Formatting for `r type` instructions is as follows, make sure there are no commas: `op $r1 $r2 $r3` 
Formatting for `i type` instructions is as follows, make sure there are no commas: `op $r1 offset($r2)`.

The simulator can only operate on integers. Registers must be manually loaded through the graphical interface and once done, user must hit `Set Registers` button. Then the instruction file which can be any text file which has the compatible instructions needs to be loaded. 