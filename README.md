# Projeto JPA - Mapeamento Objeto-Relacional Simplificado

Este projeto demonstra o uso básico do **Java Persistence API (JPA)** com **Hibernate** para realizar operações de persistência em banco de dados MySQL.  
A aplicação está estruturada como um **módulo IntelliJ IDEA** chamado `a266_parte1`.

---

## 📦 Estrutura do Módulo `a266_parte1`

```
a266_parte1/
 ├── src/
 │   └── main/
 │       ├── java/
 │       │   ├── aplicacao/
 │       │   │   └── Programa.java
 │       │   └── dominio/
 │       │       └── Pessoa.java
 │       └── resources/
 │           └── META-INF/
 │               └── persistence.xml
 ├── pom.xml
```

---

## 🛠️ Pré-requisitos

- **Java JDK** instalado
- **IntelliJ IDEA** configurado
- **MySQL** instalado e rodando
- Dependências JPA e Hibernate configuradas via **Maven**

---

## 🗄️ Configuração do Banco de Dados

Antes de executar a aplicação, crie o banco de dados no MySQL com o seguinte comando:

```sql
CREATE DATABASE aulajpa;
```

> O nome do banco deve ser exatamente **aulajpa**, pois será referenciado no arquivo `persistence.xml`.

---

## ⚙️ Arquivo `persistence.xml`

Localizado em `src/main/resources/META-INF/persistence.xml`, este arquivo configura a unidade de persistência:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence
             http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd"
             version="2.1">

    <persistence-unit name="exemplo-jpa">
        <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
        <class>dominio.Pessoa</class>

        <properties>
            <!-- Conexão com MySQL -->
            <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/aulajpa"/>
            <property name="javax.persistence.jdbc.user" value="root"/>
            <property name="javax.persistence.jdbc.password" value="sua_senha"/>
            <property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>

            <!-- Configurações do Hibernate -->
            <property name="hibernate.dialect" value="org.hibernate.dialect.MySQL8Dialect"/>
            <property name="hibernate.hbm2ddl.auto" value="update"/>
            <property name="hibernate.show_sql" value="true"/>
        </properties>
    </persistence-unit>
</persistence>
```

> ⚠️ Substitua `root` e `sua_senha` pelos dados reais de acesso ao seu MySQL.

---

## 🚀 Como Executar no IntelliJ IDEA

1. Crie o banco de dados `aulajpa` no MySQL.
2. Abra o projeto no IntelliJ IDEA.
3. Verifique se o módulo `a266_parte1` está configurado corretamente.
4. Confirme que o `persistence.xml` está localizado em `src/main/resources/META-INF/`.
5. Execute a classe `Programa` diretamente pelo IntelliJ (botão **Run** ▶️).
6. Acompanhe no console as operações realizadas:
   - Inserção de registros.
   - Remoção de uma entidade.
   - Consulta de uma entidade pelo ID.

---

## 📌 Observações

- O **ID** é gerado automaticamente pelo banco de dados (auto-incremento).
- Operações de escrita (insert, update, delete) exigem uma **transação ativa**.
- Apenas entidades **gerenciadas** pelo `EntityManager` podem ser removidas diretamente.

---
