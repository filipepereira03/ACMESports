# ACMESports

ACMESports é um projeto de faculdade para a disciplina de Programação Orientada a Objetos. Trata-se de uma aplicação Java que gerencia atletas e medalhas em um evento esportivo. A aplicação permite registrar atletas e medalhas, atribuir medalhas aos atletas e recuperar várias informações sobre atletas, medalhas e países.

## Recursos

- Registre atletas com seu número, nome e país.
- Registre medalhas com seu código, tipo, se são individuais ou não, e sua modalidade.
- Atribua uma medalha a um atleta.
- Recupere dados do atleta por número ou nome.
- Recupere dados da medalha por código.
- Recupere dados por país.
- Recupere atletas por tipo de medalha.
- Recupere atletas por modalidade.
- Exiba o atleta com mais medalhas.

## Como funciona

A aplicação lê dados de entrada de um arquivo chamado `dadosin.txt` e escreve dados de saída para um arquivo chamado `dadosout.txt`. O arquivo de entrada deve conter os dados para atletas e medalhas em um formato específico. O arquivo de saída conterá os resultados das operações realizadas pela aplicação.

## Classes

- `ACMESports`: A classe principal da aplicação. Contém métodos para registrar atletas e medalhas, atribuir medalhas aos atletas e recuperar várias tipos de informações.
- `Atleta`: Representa um atleta. Um atleta tem um número, um nome e um país.
- `Medalha`: Representa uma medalha. Uma medalha tem um código, um tipo, um booleano indicando se é individual ou não, e uma modalidade.
- `Plantel`: Gerencia os atletas. Contém métodos para registrar um atleta, recuperar um atleta por número ou nome, recuperar atletas por país ou tipo de medalha, e encontrar o atleta com mais medalhas.
- `Medalheiro`: Gerencia as medalhas. Contém métodos para registrar uma medalha, recuperar uma medalha por código, e recuperar medalhas por modalidade.

## Como executar

Para executar a aplicação, você precisa ter o Java instalado em sua máquina. Você pode executar a aplicação a partir da linha de comando navegando até o diretório que contém o arquivo `ACMESports.java` e executando os seguintes comandos:

```bash
javac ACMESports.java
java ACMESports
```

Certifique-se de que o arquivo `dadosin.txt` esteja no mesmo diretório que o arquivo `ACMESports.java`. A aplicação criará o arquivo `dadosout.txt` no mesmo diretório.
