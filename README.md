# A3-Estoque
O trabalho consiste em desenvolver o software de controle de estoque para o problema contextualizado.
Atualizado dia 30/05/2025

Integrantes:

. Cauã Capella Pereira - 1072511690 - CauaCapella

. Ian Bertoldi de Medeiros - 10724253206 - ianbmn

. Pedro Henrique Marinho Moraes - 1072121706 - PedroMoraes9009

. Rodrigo Larsen Pacheco - 10725117845 - Alecrim99k

Usuário e senha do BD: Rodrigo Larsen Pacheco e a senha do BD é 1234


##  Requisitos Funcionais (RF)

- **RF01:** Permitir o cadastro de produtos com nome, preço, quantidade, categoria, tamanho e tipo de embalagem.
- **RF02:** Permitir o cadastro de categorias associadas aos produtos.
- **RF03:** Armazenar dados de produtos e categorias em banco de dados MySQL.
- **RF04:** Permitir a listagem de todos os produtos com suas informações completas e categoria.
- **RF05:** Garantir que cada produto pertença a uma categoria válida (relacionamento entre tabelas).
- **RF06:** Exibir menu textual para navegação no terminal.
- **RF07:** Gerar IDs automáticos para produtos e categorias (auto incremento).
- **RF08:** Verificar conexão com o banco de dados e tratar erros de acesso.

---

##  Requisitos Não Funcionais (RNF)

- **RNF01:** Desenvolvido em Java SE com estrutura modular baseada em MVC + DAO.
- **RNF02:** Utilizar banco de dados MySQL 8.0 ou superior com conexão via JDBC.
- **RNF03:** Operações de cadastro e consulta devem ter tempo de resposta inferior a 1 segundo em ambiente local.
- **RNF04:** O código deve seguir boas práticas de programação orientada a objetos.
- **RNF05:** Executável em ambiente local compatível com Windows ou Linux.
- **RNF06:** Os dados devem ser armazenados de forma persistente no banco de dados.
- **RNF07:** O sistema deve ser de fácil manutenção, com camadas separadas.
- **RNF08:** O projeto deve estar versionado e disponível no GitHub.

