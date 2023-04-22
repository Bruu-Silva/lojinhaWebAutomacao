# Lojinha Web Automação

Este é um repositório que contém a automação de alguns testes Web de um software denominado "Lojinha". Os subtópicos abaixo descrevem algumas decisões tomadas na estruturação do projeto.

## Tecnologias Utilizadas

 -   Java  https://www.oracle.com/java/technologies/javase/jdk19-archive-downloads.html
 -   JUnit  https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api
 - Selenium Java https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.9.0
 - Chrome Driver https://chromedriver.storage.googleapis.com/index.html?path=112.0.5615.49/
-   Maven  https://maven.apache.org

## Testes Automatizados

Testes para validar as partições de equivalência relacionadas ao valor do produto na lojinha, que estão vinculados diretamente à regra de negócio que diz que o valor do produto deve estar entre R$ 0,01 e R$ 7.000,00.

## Notas Gerais

-   Sempre utilizo a anotação "Before Each" para capturar os dados referente a abertura do browser que será utilizado posteriormente nos métodos de teste.
-   Utilizei o padrão de design PageObject para ajudar a aprimorar a manutenção dos testes e reduzir a duplicação de código.
-   Neste projeto, fiz uso do JUnit 5, o que proporcionou a possibilidade de usar a anotação "DisplayName" para dar descrições em português para os testes.
