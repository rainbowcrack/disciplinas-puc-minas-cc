    .text
    .globl main

main:
    # le o num do teclado
    addi t0, zero, 5     
    add t1, zero, t0    
    ecall
    add t2, zero, t0     

    # verifica se eh multiplo de 4 (n and 3 == 0)
    andi t3, t2, 3       # t3 = t2 and 3
    beq t3, zero, MULT_4 # se t3 == 0, eh multiplo de 4

    # nao eh multiplo de 4 entao imprime 'N' (ASCII 78)
    addi t4, zero, 78   
    add t0, zero, t4     
    addi t1, zero, 11   
    ecall
    j END

MULT_4:
    # eh multiplo imprime 'S' (ASCII 83)
    addi t4, zero, 83    
    add t0, zero, t4
    addi t1, zero, 11    
    ecall

END:
    # Imprime newline (ASCII 10)
    addi t4, zero, 10
    add t0, zero, t4
    addi t1, zero, 11
    ecall

    # Finaliza o programa
    addi t1, zero, 10    
    ecall
