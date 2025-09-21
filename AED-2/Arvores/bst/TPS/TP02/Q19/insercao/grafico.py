import pandas as pd
import matplotlib.pyplot as plt

df = pd.read_csv("resultados_insercao.csv")

# Tempo de execução
plt.figure(figsize=(10,6))
plt.plot(df["Tamanho"], df["Tempo(ms)"], marker='o', label="Tempo (ms)")
plt.title("Tempo de Execução - Inserção")
plt.xlabel("Tamanho do Vetor")
plt.ylabel("Tempo (ms)")
plt.grid(True)
plt.legend()
plt.savefig("tempo_insercao.png")
plt.show()

# Comparações e movimentações
plt.figure(figsize=(10,6))
plt.plot(df["Tamanho"], df["Comparacoes"], marker='s', label="Comparações")
plt.plot(df["Tamanho"], df["Movimentacoes"], marker='^', label="Movimentações")
plt.title("Comparações vs Movimentações - Inserção")
plt.xlabel("Tamanho do Vetor")
plt.ylabel("Quantidade")
plt.grid(True)
plt.legend()
plt.savefig("comparacoes_movimentacoes_insercao.png")
plt.show()
