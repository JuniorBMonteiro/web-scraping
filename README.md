# web-scraping

## Descrição

Nesse exercício de Java Aprofundado você vai precisar um simples Web Scraping utilizando seus conhecimentos aprendidos na trilha de Java Aprofundado.

### O que é um Web Scraping?

Um software de coleta de dados da Web que permite a extração de dados de um site para estruturar essa informação para ser analisada futuramente.

Ex.: Você pode criar um software que coleta todos os títulos de notícias de vários sites para depois utilizar esses dados para alguma análise posterior.

### O que vocês devem fazer?

Vocês deverão fazer um programa que leia um arquivo .HTML e colete todas as URLs que estejam dentro de tags.

Essas URLs devem ser coletadas e salvas dentro de um arquivo CSV separadas por ponto e vírgula, ex.:
"http: //google.com;http: //fiveacademy.com;http: //microsoft.com"

No entanto, vocês devem fazer esse programa utilizando conceitos de multi-thread, ou seja, é obrigatório que uma thread seja responsável pela leitura de um arquivo para a extração da URL e outra thread seja responsável em receber essa URL e salvar em um arquivo CSV.

Apenas se faz necessário a criação de 2 threads.

## Desafio Plus

- Aumentar o número de threads de leitura e de threads de escrita do arquivo CSV, com o ponto de atenção de que pode haver problemas de concorrência ao tentar escrever em um arquivo sem antes ter salvo em outras threads
