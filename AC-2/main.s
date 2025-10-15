.text
.globl main

main:
    addi a7, zero, 5
    ecall
    addi t0, a0, 0      # x

    addi a7, zero, 5
    ecall
    addi t1, a0, 0      # y

    slli t2, t0, 3      # 8x
    slli t3, t0, 2      # 4x
    add t4, t2, t3      # 12x

    slli t5, t1, 6      # 64y
    slli t6, t1, 1      # 2y
    add s0, t5, t6      # 66y

    add s1, t4, s0      # 12x soma 66y

    slli s1, s1, 2      # (12x soma 66y) mul 4

    addi a7, zero, 1
    addi a0, s1, 0
    ecall

    addi a7, zero, 10
    ecall
