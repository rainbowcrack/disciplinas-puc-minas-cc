
    .text
    .globl main

main:
     # le o inteiro do teclado em t0
    addi a7, zero, 5  
    ecall
    add t0, a0, zero   

    # testa o bit menos significativo para ver par ou impar
    # XXXX0 eh par, XXXX1 eh impar
    andi t1, t0, 1
    beq t1, zero, IS_PAR 

    # caso impar
    addi a0, zero, 73   # ASCII de i
    addi a7, zero, 11  
    ecall
    j END

IS_PAR:
    addi a0, zero, 80   # ASCII de p
    addi a7, zero, 11   
    ecall

END:
    # imprime newline
    addi a0, zero, 10   # ASCII newline
    addi a7, zero, 11 
    ecall

    # fim
    addi a7, zero, 10  
    ecall
