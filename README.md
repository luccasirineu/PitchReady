# 🎤 PitchMind

O **PitchReady** é uma aplicação que utiliza IA do Google para gerar pitches de 1 minuto a partir de uma descrição fornecida pelo usuário. O objetivo é facilitar a criação de apresentações rápidas e impactantes para ideias de projetos, produtos ou startups.

---

## 🚀 Funcionalidades

- ✅ Geração de pitch com IA (Google Gemini API)
- ✅ Armazenamento de histórico de pitches gerados
- ✅ Integração entre backend Java (Spring Boot) 
- ✅ API RESTful 

---

## 🛠️ Tecnologias Utilizadas

### Backend
- **Java 17**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA**
- **MySQL**
- **Google Gemini API (via REST)**
- **SLF4J com LoggerFactory** para logging
- **Arquitetura MVC (Controller, Service, Model, Repository, DTOs)**

---

## 🧱 Arquitetura

- **Camadas bem definidas:** Controller → Service → Repository
- **DTOs** para abstração da comunicação entre cliente e servidor
- **Entity `Pitch`** salva no banco com descrição, resposta gerada e data/hora
- **Persistência com JPA** e conexão com MySQL
- **Logger (SLF4J)** substitui prints para melhor rastreabilidade
- **Requisições HTTP com `RestTemplate`** para consumir a API da Gemini

---

