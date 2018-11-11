.data
array:	.word 6,5,-2,3,2,1
.text

main:
li	$a0, 0			# carrega begin em $a0 para passar como parametro
li	$a1, 20			# carrega end em $a1 para passar como parametro
li	$a2, -1
li	$a3, -1
jal quickSort		# chama quickSort

li 	$v0, 10			# system call for exit
syscall				# Exit!


quickSort:
.data
	end:	.word 0
	begin:	.word 0 
	pivot:	.word 0
	left:	.word 0 
	right:	.word 0
.text


#salva na pilha de execucao
addiu	$sp,$sp,-20		# Aloca espaço na pilha para 1 palavra (8 bytes)
sw	$a0, 0($sp)			# salva begin
sw	$a1, 4($sp)			# salva left
sw	$a2, 8($sp)			# salva right
sw	$a3, 12($sp)		# salva end	
sw	$ra, 16($sp)		# salva endereco da chamada
#fim salvamento na pilha


sw	$a0, begin			# guarda begin na memoria
sw	$a1, end			# guarda end na memoria

lw	$s0, begin			# $s0 = begin
lw	$s1, end			# $s1 = end

sub	 $t9, $s1, $s0		# $s9 = end - begin
bgtz $t9, e				# if(end - begin > 0) e
j fim					# else -> fim


e:	lw	$s2, array($s0)		# $s2 = array[begin]
sw	$s2, pivot			# pivot = array[begin]

addi $s3, $s0, 4		# left = begin + 1
sw	$s3, left

lw	$s4, end			# right = end
sw	$s4, right



while:
bge $s3, $s4, a			# if(left >= right) a
lw	$s5, array($s3)		# $s5 = array[left]
ble	$s5, $s2, incLeft	# if(array[left] <= pivot) incLeft
						# else

lw	$s6, array($s4)		# $s6 = array[right]
lw	$s5, array($s3)		# $s5 = array[left]

sw	$s5, array($s4)		# array[right] = array[left]
sw	$s6, array($s3)		# array[left] = array[right]

addi $s4, $s4, -4		# right--
sw	$s4, right

lw	$s5, array($s3)		# $s5 = array[left]
lw	$s6, array($s4)		# $s6 = array[right]
j while

a:	lw	$s5, array($s3)		# $s5 = array[left]
lw	$s6, array($s4)		# $s6 = array[right]
bgt	$s5, $s2, decLeft	# if(array[left] > pivot) decLeft

c:	lw	$s7, array($s0)		# $s7 = array[begin]
lw	$s5, array($s3)		# $s5 = array[left]

sw	$s7, array($s3)		# array[left] = array[begin]
sw	$s5, array($s0)		# array[begin] = array[left]

lw	$s7, array($s0)		# $s7 = array[begin]
lw	$s5, array($s3)		# $s5 = array[left]


#chama quickSort primeira parte
lw	$a0, begin		# $a0 = begin primeira
lw	$a1, left		# $a1 = left
lw	$a2, right		# $a2 = right
lw	$a3, end		# $a3 = end

addi $a1, $a1, -4	# $a1 = left-1
addi $t0, $a1, 4	# $t0 = left

jal quickSort		# chama quickSort
#fim recursao primeira parte


sw	$a0, begin			# guarda begin na memoria
sw	$a1, left			# guarda left na memoria
sw	$a2, right			# guarda right na memoria
sw	$a3, end			# guarda end na memoria


#chama quickSort segunda parte
lw	$a0, right		# $a0 = right segunda
lw	$a1, end		# $a1 = end
lw	$a2, begin		# $a2 = begin
lw	$a3, left		# $a3 = left

jal quickSort		# chama quickSort
#fim recursao segunda parte



fim:
lw	$ra, 16($sp)	# endereco
lw	$a3, 12($sp)	# end
lw	$a2, 8($sp)		# right
lw	$a1, 4($sp)		# left
lw	$a0, 0($sp)		# begin

sw	$zero, 16($sp)	# endereco
sw	$zero, 12($sp)	# end
sw	$zero, 8($sp)	# right
sw	$zero, 4($sp)	# left
sw	$zero, 0($sp)	# begin

addiu $sp, $sp, 20 	# desaloca espaço na pilha para (20 bytes)

jr $ra


incLeft:
addi $s3, $s3, 4
sw	$s3, left
j while

decLeft:
addi $s3, $s3, -4
sw	$s3, left
j c