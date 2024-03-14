**Api Ponto Inteligente**

Esta é uma aplicação em construção baseada em Java, desenvolvida usando o framework Spring Boot e Maven para gerenciamento de dependências. A aplicação está sendo projetada para gerenciar um sistema de ponto inteligente de uma empresa.  

Recursos criados ate o momento
Gerenciamento de Empresas: A aplicação permite a criação de novas empresas. Cada empresa é identificada unicamente pelo seu CNPJ. O sistema garante que não possam existir duas empresas com o mesmo CNPJ.

**Tecnologias Utilizadas**
Java: A aplicação é escrita em Java, uma linguagem de programação de alto nível, baseada em classes e orientada a objetos, que foi projetada para ter o mínimo possível de dependências de implementação.  
Spring Boot: Este é um framework usado para criar aplicações Spring autônomas de nível de produção que podem ser simplesmente executadas. Ele simplifica a configuração de aplicações Spring.  
Maven: Esta é uma poderosa ferramenta de gerenciamento de projetos que se baseia no POM (modelo de objeto de projeto). É usado para construção de projetos, dependência e documentação.
H2 Database: Este é um banco de dados em memória escrito em Java. Ele é rápido, de código aberto e fornece uma interface de usuário baseada em navegador.
Exceções Personalizadas: O projeto inclui exceções personalizadas para lidar com situações específicas, proporcionando uma melhor experiência de depuração e manutenção do código.

**Estrutura do Código**
A base de código é estruturada em vários pacotes, cada um servindo a um propósito distinto:  
com.alexandrepapas.pontointeligente.Entities: Este pacote contém as classes de entidade usadas na aplicação, como Empresa.  
com.alexandrepapas.pontointeligente.services: Este pacote contém classes de serviço que contêm lógica de negócios, como EmpresaService.  
com.alexandrepapas.pontointeligente.repositories: Este pacote contém as interfaces de repositório para interagir com o banco de dados, como EmpresaRepository e FuncionarioRepository.  
com.alexandrepapas.pontointeligente.Controllers: Este pacote contém as classes de controlador que lidam com solicitações HTTP, como EmpresaController.
com.alexandrepapas.pontointeligente.exceptions: Este pacote contém as classes de exceção personalizadas que são usadas para lidar com situações específicas. 

O ponto de entrada da aplicação é a classe PontoInteligenteApplication.  

Como Executar
Para executar a aplicação, execute o método main na classe PontoInteligenteApplication. Isso iniciará a aplicação Spring Boot.  Por favor, note que você precisará ter Java e Maven instalados em sua máquina para executar esta aplicação.
