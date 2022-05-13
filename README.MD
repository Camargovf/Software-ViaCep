<img src="http://rafaelcastro.com.br/wp-content/uploads/2020/05/viacep.png" width="950px" alt="ViaCep" class="center">


<h1 align="center">🎯 Sobre a API</h1>

A API é capaz de realizar as operações para controle de clientes e funcionários e consumir a Api externa (ViaCEP) - verificando a incidência de cep(região).

<h1 align="center">📦 Desenvolvimento</h1>

Realizado com framework SpringBoot em Java 11, gestor de dependência com Maven - uso de DevTools para agilidade durante a produção de desenvolvimento. Hibernate e JPA para persistir os dados no banco de dados MySQL, Lombok para perfomance e diminuir boiler plate code. Auxílio do ModelMapper para criação do DTO. Flyway para migração e versionamento de Query (registro) para maior domínio sobre scripts SQL. Possibilidade de negociação de conteúdo (XML/JSON) com fasterxml e com interface amigável na documentação do projeto e dos devidos endpoints com Swagger.

<h1 align="center"> 💻 Requisitos de inicialização do projeto</h1>

Essas instruções permitirão que você obtenha uma cópia do projeto em operação na sua máquina local para fins de desenvolvimento.

Consulte *Implantação* para saber como implantar o projeto.

### 📋 Pré-requisitos

De que coisas você precisa para instalar o software e como instalá-lo?

- [Maven](http://maven.apache.org)
- [JDK](https://www.oracle.com/java/technologies/downloads/)

<h3>Unix</h3>

`
sudo apt install openjdk-11-jre-headless
`

 <h1 align="center">📍 Rodando a aplicação</h1>

```
bash

 Clone este repositório
$ git clone https://github.com/Camargovf/RestAPi-ViaCep

 Acesse a pasta do projeto no terminal/cmd
$ cd README-nomeprojeto

 Vá para a pasta nomeprojeto
$ cd project-nomeprojeto

 Instale as dependências
$ mvn install
$ mvn clean package

 Execute a aplicação em modo de desenvolvimento
$ javac -nomedoprojeto.jar

 O servidor iniciará na porta:8080 - acesse http://localhost:8080 \
 
```

<h1 align="center">✔️ Configurando Flyway</h1>

Primeiro coloque o flyway como: false. 
Após rodar o banco de dados e criar através do Springboot, apenas
coloque a configuração para: true.

Seus scripts terão migrado!

```

mvn flyway:migrate

```

<div align="center">
<img src="https://i.postimg.cc/FsCyWP5n/Captura-de-Tela-2022-05-12-s-21-51-20.png" width="700px" />
</div>

<h1 align="center">✔️ Vericando projeto ON</h1>

A tela da sua aplicação deve estar:

<div align="center">
<img src="https://i.postimg.cc/vHxppdnp/Captura-de-Tela-2022-05-12-s-13-21-30.png" width="680px" />
</div>

<h1 align="center">🧩 Consumindo API </h1>


<h3> CURL - Clientes</h3>

```
curl -X GET "http://localhost:8080/clientes" -H "accept: /"


```
<h3> CURL - Funcionários</h3>

```
curl -X GET "http://localhost:8080/funcionarios" -H "accept: /"


```
<h3> CURL - Adress (endereço(</h3>

```

curl -X GET "http://localhost:8080/adress" -H "accept: /"

```

<h1 align="center">📌 Documentação </h1>

A documentação foi realizada com Swagger com interface amigável para documentação e testes dos endpoints.

<div align="center">
<img src="https://i.postimg.cc/Bn8xdxJZ/Captura-de-Tela-2022-05-12-s-21-52-05.png" width="700px" />
</div>


<h1 align="center">🔨 Funcionalidades do projeto </h1>

- `Funcionalidade 1` `salvarCliente`: Cadastra um cliente com suas devidas informações no sistema.

- `Funcionalidade 2` `salvarFuncionario`: Cadastra um funcionário e seu respectivo cargo no sistema.

- `Funcionalidade 3` `consumirEndereço`: Utiliza api externa ViaCep.

- `Funcionalidade 4` `listafuncionario`: Lista um funcionário por id.

- `Funcionalidade 5` `listacliente: Lista um funcionário por id.

- `Funcionalidade 6` `paginasfuncionario`: Lista um funcionário com a quantidade de páginas e quantidade de itens de cada página.

- `Funcionalidade 7` `atualizarFuncionario`: Atualiza os dados refentes: funcionário.

- `Funcionalidade 8` `desligarFuncionario`: Exclui um funcionário do sistema.
- 
- `Funcionalidade 9` `verificaocorrencias`: Verifica a incidências de cep iguais no sistema.


<h1 align="center">🛠️ Construído com as tecnologias  </h1>


* [Springboot](https://spring.io/projects/spring-boot)
* [Maven](http://maven.apache.org)
* [Lombok](https://projectlombok.org/download)
* [ModelMapper](http://modelmapper.org/)
* [FasterXML](https://javadoc.io/doc/com.fasterxml.jackson.core/jackson-databind/latest/index.html)
* [FlyWay](https://flywaydb.org)
* [Swagger](https://swagger.io/)
* [Hibernate](https://hibernate.org/)
* [MySQL](https://dev.mysql.com/downloads/workbench/)
* [DevTools](https://www.quickdev.org/?gclid=Cj0KCQjwsdiTBhD5ARIsAIpW8CLGWx99TFjAY-Xgu5fSe-Kno98jVPCa0ZxdyOvnbCZT3bDrFZgbxF0aAs3sEALw_wcB)

<h1 align="center">📚 Features em desenvolvimento</h1>

- [ ] Docker
- [x] Flyway
- [ ] Deploy Google Cloud (GCP)
- [ ] TDD JUnit
- [ ] Spring Security

<h1 align="center">💪 Como contribuir com o projeto </h1>

1. Faça um *fork* do projeto.
3. Crie uma nova branch com as suas alterações: `git checkout -b nomedoarquivo`
4. Salve as alterações e crie uma mensagem de commit contando o que você fez: `git commit -m "atualização"`
5. Envie as suas alterações: `git push origin nomedoarquivo`

<h1 align="center">🎁 Considerações Finais</h1>

* A todos que diariamente me permitem desenvolver.

 <h1 align="center">✒️  Desenvolvedor </h1>

| [<img src="https://avatars.githubusercontent.com/u/59845047?v=4" width=115><br><sub>Valdeir Camargo</sub>](https://github.com/Camargovf)
| :---: | 

