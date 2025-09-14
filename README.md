# 🏦 Sistema de Controle Bancário - Saques e Depósitos

Sistema bancário que gerencia transações simultâneas de saques e depósitos com controle de concorrência avançado.

## 🎯 Funcionalidades

- 20 transações bancárias simultâneas
- Controle de concorrência para operações críticas
- Sistema de semáforos para gerenciar acessos
- Transações aleatórias (saques e depósitos)
- Logs com timestamps precisos
- Cálculos de saldo em tempo real

## 🚀 Como executar

### Pré-requisitos
- JDK 8 ou superior
- Git instalado

### Passo a passo
1. Clone o repositório:
```bash
git clone https://github.com/GabrielGit10110/SimulacaoTransacoes
```

2. Acesse o diretório do projeto:
```bash
cd SimulacaoTransacoes
```

3. Compile o código:
```bash
javac -d bin src/controller/*.java src/utils/*.java src/view/*.java
```

4. Execute a aplicação:
```bash
java -cp bin view.Banco
```

## 💰 Tipos de Transações

- **🟢 Depósito**: Adiciona valor à conta
- **🔴 Saque**: Remove valor da conta

## 🛠️ Tecnologias utilizadas
- Java SE
- Programação multithread
- Semáforos para controle de concorrência
- Sincronização de transações
- Geração de valores aleatórios
- Sistema de logging com timestamps
- JDK 8+

## 📋 Exemplo de saída

```
[20:48:15] 🔄 Conta: 16 saque de R$ 580,41 em processamento...
[20:48:15] ✅ Conta: 14 depósito realizado com sucesso!
[20:48:15] ✅ Conta: 16 saque realizado com sucesso!
[20:48:15] 🔄 Conta: 19 depósito de R$ 814,84 em processamento...
[20:48:15] 🔄 Conta: 17 saque de R$ 337,42 em processamento...
[20:48:15] ✅ Conta: 19 depósito realizado com sucesso!
[20:48:15] ✅ Conta: 17 saque realizado com sucesso!

```

## ⚙️ Características do Sistema

- **Valores aleatórios**: Transações entre R$ 10,00 e R$ 1000,00
- **Controle de concorrência**: Impede operações conflitantes
- **Logs detalhados**: Timestamps e status de cada operação
- **Processamento simultâneo**: Múltiplas threads processando transações

## 🔒 Sistema de Semáforos

- **Semáforo de saque**: Permite apenas 1 saque por vez
- **Semáforo de depósito**: Permite apenas 1 depósito por vez  
- **Processamento paralelo**: 1 saque + 1 depósito simultaneamente

## 👨‍💻 Desenvolvido por
[GabrielGit10110](https://github.com/GabrielGit10110)

---

**Nota**: Este sistema demonstra conceitos avançados de programação concorrente em Java, com controle preciso de transações bancárias críticas usando semáforos para garantir a consistência dos dados e prevenir condições de corrida.
