    .text
    .globl main

main:
    # le o segredo
    addi t0, zero, 5      
    add t1, zero, t0      
    ecall
    add t2, zero, t0       # t2 = segredo

LOOP:
    # le um num
    addi t0, zero, 5      
    add t1, zero, t0
    ecall
    add t3, zero, t0       # t3 = num lido

    # se for 0, fim
    beq t3, zero, FIM

    # XOR t4 = t3 xor t2
    xor t4, t3, t2

    # resultado
    add t0, zero, t4
    addi t1, zero, 1
    ecall

    # newline
    addi t0, zero, 10
    addi t1, zero, 11
    ecall

    j LOOP

FIM:
    addi t1, zero, 10
    ecall
