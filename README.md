**Api Ponto Inteligente**

O "Projeto Ponto Inteligente" é uma aplicação desenvolvida em Java, utilizando o framework Spring Boot. Essa plataforma visa facilitar o gerenciamento do tempo de trabalho dos funcionários, oferecendo recursos para registrar e monitorar as horas trabalhadas.

A estrutura do projeto é baseada em duas entidades principais: Empresa e Funcionário. A entidade Empresa armazena informações essenciais da empresa, como razão social e CNPJ. Já a entidade Funcionário contém detalhes individuais de cada colaborador, como nome, e-mail, senha, CPF, valor da hora de trabalho, quantidade de horas de trabalho diárias e tempo de almoço.

Para fornecer acesso e manipulação dos dados, o sistema disponibiliza uma API RESTful. Essa API possibilita a criação, edição e exclusão de empresas, além de permitir a consulta de todas as empresas cadastradas. Além disso, oferece funcionalidades para o gerenciamento dos funcionários vinculados a uma empresa específica.

As tecnologias utilizadas no desenvolvimento incluem:

Spring Boot: Um framework que facilita a criação de aplicativos Java.
Maven: Uma ferramenta de gerenciamento de projetos que auxilia na compilação, distribuição e documentação de um software.
Jakarta Persistence (JPA): Uma API de persistência que fornece um meio para gerenciar dados em aplicativos Java.
Hibernate: Um framework de mapeamento objeto-relacional (ORM) que simplifica o acesso e manipulação de dados em um banco de dados.
Banco de dados em memória H2: Um banco de dados leve que pode ser executado em memória, ideal para desenvolvimento e testes.
Jackson: Uma biblioteca para serialização e desserialização de objetos Java em formato JSON.
Essas tecnologias em conjunto proporcionam uma base sólida para o desenvolvimento de um sistema eficiente e escalável de gestão de tempo e recursos humanos
