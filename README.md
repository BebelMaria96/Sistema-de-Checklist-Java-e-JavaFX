Autor: Isabela Maria Gonçalves Cardoso
Email: isabelamaria.art@gmail.com
LinkedIn: https://www.linkedin.com/in/isabela-maria-/
------------------------------------------------------------------------------------------

# CheckList EPI - Sistema de Gestão de EPIs

Um sistema de CheckList simples e eficiente desenvolvido em **JavaFX** para gerenciar atividades e controle de Equipamentos de Proteção Individual (EPIs).
Este projeto utiliza JSON para armazenamento de dados e inclui funcionalidades como registro de atividades, histórico de ações e autenticação
de usuários.

------------------------------------------------------------------------------------------

## 📋 **Funcionalidades**

1. **Login Seguro:**
   - Autenticação baseada em credenciais (e-mail e senha) validadas em um arquivo JSON.
2. **Registro de Atividades:**
   - Usuários podem registrar serviços realizados e os EPIs utilizados.
3. **Histórico de Atividades:**
   - Consulta fácil de todas as atividades registradas pelo usuário.
4. **Logout:**
   - Redirecionamento para a tela de login ao sair do sistema.
5. **Interface Simples e Intuituva:**
   - Design simples com cores claras e botões em gradiente roxo.

------------------------------------------------------------------------------------------

## 🚀 **Tecnologias Utilizadas**

- **JavaFX**: Para a criação da interface gráfica.
- **Jackson**: Biblioteca para manipulação de arquivos JSON.
- **JSON**: Armazenamento de dados persistentes como usuários e atividades.
- **Java SE**: Para lógica e estrutura do projeto.

------------------------------------------------------------------------------------------

## 🖥️ **Como Executar o Projeto**

1. **Requisitos:**
   - Java 11 ou superior instalado.
   - Biblioteca **JavaFX** e **Jackson** configuradas no sistema.

2. **Passo a Passo:**
   1. Clone o repositório:
      ```bash
      git clone https://github.com/SEU-USUARIO/javaChecklistEPI.git
      cd javaChecklistEPI
      ```
   2. Compile o projeto:
      ```bash
      javac --module-path "CAMINHO/DO/JAVAFX" --add-modules javafx.controls,javafx.fxml -d bin src/application/*.java
      ```
   3. Execute o projeto:
      ```bash
      java --module-path "CAMINHO/DO/JAVAFX" --add-modules javafx.controls,javafx.fxml -cp bin application.Main
      ```

---

## 📖 **JSON - Estrutura dos Arquivos**

### **usuarios.json**
```json
[
    {
        "id": 1,
        "name": "João Silva",
        "email": "joao@example.com",
        "password": "1234"
    },
    {
        "id": 2,
        "name": "Maria Oliveira",
        "email": "maria@example.com",
        "password": "5678"
    }
]




