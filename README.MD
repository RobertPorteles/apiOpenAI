# 🤖 Atendimento Virtual com OpenAI (Java)

Este projeto é uma aplicação Java que simula um atendimento de suporte técnico. Ele utiliza a API da OpenAI para responder perguntas relacionadas à tecnologia de forma cordial e objetiva. O usuário fornece seu nome e uma pergunta, e o sistema retorna a resposta gerada pela IA.

## 🚀 Tecnologias Utilizadas

- **Java 17+**
- **API da OpenAI**
- **`HttpURLConnection`** para chamadas HTTP
- **`BufferedReader`** para leitura da resposta da API
- **`java.time.Instant`** para registrar data e hora
- **`javax.swing.JOptionPane`** para entrada simples via interface gráfica

---

## 🧠 Funcionamento

1. **Atendimento**: O sistema inicia capturando o nome do cliente e a pergunta a ser feita à IA.
2. **Integração com OpenAI**: O `OpenAIService` envia a pergunta para a API da OpenAI e obtém a resposta.
3. **Exibição dos Resultados**: O sistema exibe o atendimento completo, incluindo ID único, nome do cliente, data/hora da interação, pergunta e resposta da IA.

---

## 🗂 Estrutura do Projeto

```plaintext
src/
├── controllers/
│   └── AtendimentoController.java
├── entities/
│   └── Atendimento.java
├── services/
│   └── OpenAIService.java
└── Main.java

🧪 Exemplo de Execução
Digite o seu nome:
> Robert

Digite a sua pergunta:
> O que é rede TCP/IP?

Processando a pergunta, por favor aguarde...

ATENDIMENTO GERADO COM SUCESSO!

ID..........: 45efb542-0b3b-4bdf-a936-b4c517f2c3a1  
CLIENTE.....: Robert  
DATA E HORA.: 2025-05-07T14:32:01.545Z  
PERGUNTA....: O que é rede TCP/IP?  
RESPOSTA....: TCP/IP é um conjunto de protocolos que permite a comunicação entre dispositivos em redes, como a internet.
