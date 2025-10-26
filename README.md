# 🧰 Sistema de Gestão de Ordens de Serviço

### 📘 Sobre o Projeto
Este sistema foi desenvolvido como parte da disciplina **Programação Orientada a Objetos (POO)** do curso de **Ciência da Computação**.

O projeto simula o funcionamento de uma **empresa de manutenção técnica**, permitindo gerenciar **clientes, técnicos, equipamentos, serviços e ordens de serviço (OS)** — desde a abertura até o encerramento, aplicando os principais conceitos de **POO**.

---

### 🧩 Funcionalidades Principais
- Cadastro de **clientes**, **técnicos** e **equipamentos**  
- Criação e acompanhamento de **ordens de serviço (OS)**  
- Registro de **serviços realizados** e cálculo do custo total  
- Atualização do **status da OS** (PENDENTE, ENCAMINHADO, CONCLUIDO, CANCELADO)  
- Registro de **avaliação e feedback do cliente**  
- Geração de **relatórios de ordens e serviços**  
- Aplicação prática de **associação, agregação, composição e encapsulamento**

---

### ⚙️ Estrutura do Sistema

O sistema é composto pelas seguintes classes e relacionamentos:

#### 🧱 Classes Principais
- **`Cliente`** – representa os clientes da empresa, com informações de contato e histórico de ordens.  
- **`Tecnico`** – responsável pela execução dos serviços, vinculado a ordens de serviço.  
- **`Equipamento`** – armazena informações sobre os equipamentos que necessitam de manutenção.  
- **`Servico`** – descreve cada serviço realizado (descrição, custo e duração).  
- **`OrdemServico`** – núcleo do sistema; gerencia cliente, técnico, equipamentos e serviços associados.  
- **`Avaliacao`** – registra a opinião do cliente após o encerramento da OS.  
- **`Relatorio`** – gera relatórios detalhados das ordens e serviços realizados.  

#### 🧩 Classes de Apoio
- **`ControleOrdemServico`** – centraliza a criação, busca e atualização de ordens.  
- **`OrdemEquipamento`** e **`OrdemServicoItem`** – fazem o vínculo entre as entidades, representando composições.  
- **`StatusAtual` (enum)** – define o estado da OS: `PENDENTE`, `ENCAMINHADO`, `CONCLUIDO`, `CANCELADO`.  

#### 💡 Interface
- **`Registravel`** – interface implementada por classes que podem ser registradas no sistema (`Cliente`, `Tecnico`, `OrdemServico`), garantindo que todas possuam o método `registrar()`.

---

### 🧠 Conceitos de POO Aplicados
- **Encapsulamento:** todos os atributos são privados, acessados apenas por getters e setters.  
- **Composição:** uma `OrdemServico` possui `Servico(s)` e `Equipamento(s)` que só existem dentro dela.  
- **Associação:** `OrdemServico` está ligada a um `Cliente` e a um `Tecnico`.  
- **Agregação:** o `ControleOrdemServico` gerencia várias instâncias de `OrdemServico`.  
- **Interface:** `Registravel` padroniza o método `registrar()` nas classes que representam entidades do sistema.  
- **Enumeração:** `StatusAtual` organiza os estados possíveis da OS, melhorando a legibilidade e a manutenção do código.

---

### 🚀 Fluxo de Execução
1. O cliente é cadastrado no sistema.  
2. Um técnico é registrado e vinculado às ordens.  
3. Equipamentos são adicionados ao cadastro.  
4. Uma nova **Ordem de Serviço** é criada, associando cliente, técnico e equipamentos.  
5. Serviços são adicionados à ordem.  
6. O status da OS é atualizado conforme o progresso.  
7. Após a conclusão, o cliente avalia o atendimento.  
8. O relatório final é gerado.

---

### 🧮 Funcionalidades Extras
- 🔹 **Geração automática de número de OS**  
- 🔹 **Registro de feedback do cliente**  
- 🔹 **Controle de status e histórico de alterações**

---

### 📊 Diagrama UML

O diagrama a seguir representa toda a estrutura do sistema, incluindo as classes, atributos, métodos, interface, enum e seus relacionamentos:

![Diagrama UML do Sistema de Ordem de Serviço](./assets/Ordem_de_Servico.png)

**Destaques do diagrama:**
- Relação **1:N** entre `Cliente` e `OrdemServico`  
- Relação **1:N** entre `Tecnico` e `OrdemServico`  
- Relação **1:N** entre `OrdemServico` e `Servico`  
- Relação de **composição** entre `OrdemServico` → `Servico` e `OrdemServico` → `Equipamento`  
- Implementação da interface `Registravel` em diversas classes  
- Enum `StatusAtual` associado a `OrdemServico`

---

### 👥 Equipe de Desenvolvimento
| Integrantes |

| **Jaqueline Silva** | **Mariana Rafaela** | **Andressa Evilin** |

---

### 🌟 Observação
O sistema foi projetado para demonstrar o uso prático dos **princípios da Programação Orientada a Objetos**, simulando o gerenciamento de ordens de serviço em um contexto real de manutenção técnica.

---
