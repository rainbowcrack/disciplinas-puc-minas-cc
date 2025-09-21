import matplotlib.pyplot as plt
import pandas as pd

# Lê o arquivo CSV
df = pd.read_csv('bolha.csv')

# Cria os gráficos
plt.figure(figsize=(12, 6))

plt.subplot(1, 3, 1)
plt.plot(df['Tamanho'], df['Tempo (ms)'], marker='o')
plt.title('Tempo de Execução - Bolha')
plt.xlabel('Tamanho do Vetor')
plt.ylabel('Tempo (ms)')

plt.subplot(1, 3, 2)
plt.plot(df['Tamanho'], df['Comparacoes'], marker='o', color='orange')
plt.title('Comparações - Bolha')
plt.xlabel('Tamanho do Vetor')
plt.ylabel('Comparações')

plt.subplot(1, 3, 3)
plt.plot(df['Tamanho'], df['Movimentacoes'], marker='o', color='green')
plt.title('Movimentações - Bolha')
plt.xlabel('Tamanho do Vetor')
plt.ylabel('Movimentações')

plt.tight_layout()
plt.savefig('grafico_bolha.png')
plt.show()
