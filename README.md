# Atividade CRUD - Fábrica de Software
## Felipe dos Santos Maniezo de Freitas - 24224651-2
### Problemática
Você foi contratado para desenvolver um sistema de gerenciamento para um jogo de RPG (Role-Playing Game). O sistema deve permitir o gerenciamento de Personagens e Itens Mágicos. Cada personagem pode carregar vários itens mágicos, e cada item mágico está vinculado a um personagem.
### Features
-   Cadastrar Personagem;

-   Cadastrar Item Mágico;

-   Listar Personagem;

-   Buscar Personagem por Identificador;

-   Atualizar Nome de Guerreiro por Identificador;

-   Remover Personagem;

-   Listar Itens Mágicos;

-   Buscar Item Mágico por Identificador;

-   Adicionar Item Mágico ao Personagem;

-   Listar Itens Mágicos por Personagem;

-   Remover Item Mágico do Personagem;

-   Buscar Amuleto do Personagem;
### Endpoints

Para acessar documentação da atividade é necessário executar projeto e acessar o url: [SWAGGER-DOC](http://localhost:8080/swagger-ui/index.html#/)
**Documentação Swagger:**

![Swagger-Endpoints](https://images2.imgbox.com/b7/bd/U8IXyRPT_o.png)

**Lista de EndPoints**

    localhost:8080/personagens
	/{id}
	/{id}
		/itens
			?tipo=TipoItem<ARMA, ARMADURA ou AMULETO>
	/itens
	/{idp}
		/item
			/{idi}
	

    localhost:8080/item
	/{id}

