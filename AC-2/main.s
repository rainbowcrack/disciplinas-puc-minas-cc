.text
.globl main

main:
    li a7, 5
    ecall
    addi t0, a0, 0

    li a7, 5
    ecall
    addi t1, a0, 0

    li t2, 3
    sll t3, t0, t2

    li t4, 2
    sll t5, t0, t4

    add t6, t3, t5

    li t2, 6
    sll t3, t1, t2

    li t4, 1
    sll t5, t1, t4

    add t7, t3, t5

    add t8, t6, t7

    li t2, 2
    sll t9, t8, t2

    li a7, 1
    addi a0, t9, 0
    ecall

    li a7, 10
    ecall
