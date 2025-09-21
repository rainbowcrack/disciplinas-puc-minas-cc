import pandas as pd
import matplotlib.pyplot as plt

# Lê o CSV gerado pelo Java
df = pd.read_csv("resultados_selecao.csv")

# Gráfico de tempo de execução
plt.figure(figsize=(10, 6))
plt.plot(df["Tamanho"], df["Tempo(ms)"], marker='o', label="Tempo de Execução (ms)")
plt.title("Tempo de Execução - Ordenação por Seleção")
plt.xlabel("Tamanho do Vetor")
plt.ylabel("Tempo (ms)")
plt.grid(True)
plt.legend()
plt.savefig("tempo_execucao.png")
plt.show()

# Gráfico de comparações e movimentações
plt.figure(figsize=(10, 6))
plt.plot(df["Tamanho"], df["Comparacoes"], marker='s', label="Comparações")
plt.plot(df["Tamanho"], df["Movimentacoes"], marker='^', label="Movimentações")
plt.title("Comparações vs Movimentações - Ordenação por Seleção")
plt.xlabel("Tamanho do Vetor")
plt.ylabel("Quantidade")
plt.grid(True)
plt.legend()
plt.savefig("comparacoes_movimentacoes.png")
plt.show()
