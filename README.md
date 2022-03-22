# web-scraping

## Descrição

### O que é um Web Scraping?

Um software de coleta de dados da Web que permite a extração de dados de um site para estruturar essa informação para ser analisada futuramente.

Ex.: Você pode criar um software que coleta todos os títulos de notícias de vários sites para depois utilizar esses dados para alguma análise posterior.

### O que vocês devem fazer?

Vocês deverão fazer um programa que leia um arquivo .HTML e colete todas as URLs que estejam dentro de tags.

Essas URLs devem ser coletadas e salvas dentro de um arquivo CSV separadas por ponto e vírgula, ex.:
"http: //google.com;http: //fiveacademy.com;http: //microsoft.com"

No entanto, vocês devem fazer esse programa utilizando conceitos de multi-thread, ou seja, é obrigatório que uma thread seja responsável pela leitura de um arquivo para a extração da URL e outra thread seja responsável em receber essa URL e salvar em um arquivo CSV.

Apenas se faz necessário a criação de 2 threads.
