# API Users

Projeto com fins de estudo focado no gerenciamento de usuários (CRUD)

## 🛠️ Tecnologias Utilizadas

* **Java 21**
* **Spring Boot 3**
* **Lombok**
* **Gradle (Groovy DSL)**

## 🔧 Como Executar o Projeto

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/FelipeDeSousa06/API-Usuario.git
    ```
   
2. **Execute o projeto (Necessário ter o Java instalado: java -version)**
    ```bash
   // Windows
   .\gradlew bootRun
   
   // Linux / MacOS
   ./gradlew bootRun
    ``` 

3. **Faça requisições**\
   Faça requisições no navegador ou no Postman\
   Faça requisições pelo terminal: curl http://localhost:8081/ ou curl.exe http://localhost:8081/
   

4. **Endpoints**
    ```bash
   // Listar todos os usuários
    http://localhost:8081/
   
   // Buscar um usuário por ID
   http://localhost:8081/{id}
    ```