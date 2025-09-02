# 🏥 Sistema de Clínica Médica

Projeto desenvolvido como atividade da disciplina de **Programação Orientada a Objetos (POO)** no **IFPR - Campus Cascavel**.  
O sistema simula o funcionamento básico de uma clínica médica, permitindo o cadastro e gerenciamento de pacientes, médicos e consultas.

---

## 📌 Tecnologias Utilizadas
- **Java** (versão 8+)  
- **JDBC** (conexão com banco de dados relacional)  
- **Java Swing** (interface gráfica)  
- **MySQL** (banco de dados utilizado nos testes)  

---

## 🏢 Arquitetura
O sistema segue o padrão **MVC (Model-View-Controller)** e utiliza **DAO (Data Access Object)** para separar a lógica de acesso ao banco de dados.

- **Model:** classes que representam as entidades (Paciente, Médico, Consulta, etc.)  
- **View:** telas em **Java Swing** para interação com o usuário  
- **Controller:** controle da lógica de negócio, intermediando Model e View  
- **DAO:** camada de persistência com consultas SQL e operações CRUD  

---

## ⚙️ Funcionalidades
- Cadastro, edição e exclusão de pacientes  
- Cadastro de médicos e suas especialidades  
- Agendamento e gerenciamento de consultas  
- Listagem de registros em tabelas  
- Interface gráfica simples e funcional com Swing  

---

## 💼 Estrutura do Projeto

```bash
/src
├── model
│    ├── Paciente.java
│    ├── Medico.java
│    └── Consulta.java
├── view
│    ├── TelaPaciente.java
│    ├── TelaMedico.java
│    └── TelaConsulta.java
├── controller
│    ├── PacienteController.java
│    ├── MedicoController.java
│    └── ConsultaController.java
└── dao
├── PacienteDAO.java
├── MedicoDAO.java
└── ConsultaDAO.java

```

## 💻 Como Executar
1. Clone este repositório:  
   ```bash
   git clone https://github.com/ifpr-fushisuno/ifpr-poo-atv.git
   ```

2. Importe o projeto em uma IDE Java (Eclipse, IntelliJ ou NetBeans).
3. Configure o banco de dados MySQL:

   ```sql
   CREATE DATABASE clinica;
   ```
4. Ajuste as credenciais no arquivo de conexão JDBC (ex.: `ConnectionFactory.java`).
5. Execute a aplicação.

---

## 📖 Autor

Projeto desenvolvido por **Kainã (fushisuno), Ana Caroline (ACPedrosa), Nicole Paloschi (nicolepaloschi)**

Disciplina de **POO - Programação Orientada a Objetos**
**IFPR - Campus Cascavel**
