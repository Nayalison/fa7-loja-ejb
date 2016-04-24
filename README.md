# fa7-loja-ejb
Especificação da API
A API Rest é capaz de cadastrar os produtos (CRUD) com os seguintes dados:
* nome (String)
* preço (double)
Os dados dos produtos são acessados pelas URLs:
* /loja-web/loja/produtos/
* /loja-web/loja/produtos/:id

A API também da suporte para ao cadastro de compras com os seguintes dados:
* produto (id)
* cliente (id)
* valor (double)
Os dados das compras são acessados pelas URLs:
* /loja-web/loja/compras/
* /loja-web/loja/compras/:id

Ambos, produto e compra, pussuem ids gerados automaticamente.

A implementação foi feita com RestFul, EJB 3.x (e JPA).
