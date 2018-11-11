.data
vetor: .word 1, 2, 3, 4, 5 
.text
la  $t4, vetor
addi $t0, $zero, 7
addi $t1, $t0, 7
add $t3, $t0, $t1

lw  $t5, 4($t4)
addi $v0, $zero, 1
add $a0, $zero, $t5
syscall	