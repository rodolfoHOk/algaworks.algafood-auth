# AlgaFood Authorization Server

> Authorization Server do Curso Especialista Spring Rest da AlgaWorks

## Conteúdo

### Segurança com Spring Security e OAuth2

- Introdução à segurança de REST APIs

- Adicionando segurança na API com Spring Security

- Configurando Spring Security com HTTP Basic

- Configurando autenticação de usuários em memória

- Introdução ao OAuth2

- Soluções para OAuth2: nova stack do Spring Security vs Spring Security OAuth

- Conhecendo o fluxo Resource Owner Password Credentials Grant

- Criando o projeto do Authorization Server com Spring Security OAuth2

- Configurando o fluxo Authorization Server com Password Credentials e Opaque Tokens

- Configurando o endpoint de introspecção de tokens no Authorization Server

- [Configurando o Resource Server com a nova stack do Spring Security](https://github.com/rodolfoHOk/algaworks.algafood-api)

- Conhecendo o fluxo para emitir e usar Refresh Tokens

- Configurando o Refresh Token Grant Type no Authorization Server

- Configurando a validade e não reutilização de Refresh Tokens

- Conhecendo o fluxo Client Credentials

- Configurando o Client Credentials Grant Type no Authorization Server

- Conhecendo o fluxo Authorization Code

- Configurando o Authorization Code Grant Type

- [Testando o fluxo Authorization Code com um client JavaScript](https://github.com/rodolfoHOk/algaworks.foodanalytics-js-client)

- Conhecendo o fluxo Implicit

- Configurando o fluxo Implicit Grant Type

- Mais segurança com PKCE e Authorization Code Grant

- Corrigindo CorsConfig

- Implementando o suporte a PKCE com o fluxo Authorization Code

- Testando o fluxo Authorization Code com PKCE com o método plain

- Testando o fluxo Authorization Code com PKCE com o método SHA-256

- [Testando um client JavaScript com PKCE e Authorization Code](https://github.com/rodolfoHOk/algaworks.foodanalytics-js-client)

- [Decidindo qual fluxo OAuth2 usar](decidindo-fluxo-oauth2.md)

### OAuth2 avançado com JWT e controle de acesso

- Armazenando tokens no Redis: um banco de dados NoSQL

- Configurando o RedisTokenStore

- Entendendo a diferença entre Stateful e Stateless Authentication

- Transparent Tokens: conhecendo o JSON Web Tokens (JWT)

- Gerando JWT com chave simétrica (HMAC SHA-256) no Authorization Server

- [Configurando o Resource Server para JWT assinado com chave simétrica](https://github.com/rodolfoHOk/algaworks.algafood-api)

- Entendendo a diferença entre assinatura com chave simétrica e assimétrica

- Gerando um par de chaves com keytool

- Assinando o JWT com RSA SHA-256 (chave assimétrica)

- Criando bean de propriedades de configuração do KeyStore

- Extraindo a chave pública no formato PEM

- Configurando a validação de JWT no Resource Server com a chave pública

- Revisando o fluxo de aprovação do Authorization Code com JWT

- Autenticando usuário com dados do banco de dados

- [Refatorando serviços de usuários para usar BCrypt](https://github.com/rodolfoHOk/algaworks.algafood-api)

- Adicionando claims customizadas no payload do JWT

- [Obtendo usuário autenticado no Resource Server](https://github.com/rodolfoHOk/algaworks.algafood-api)

- [Definindo e criando as permissões de acesso](https://github.com/rodolfoHOk/algaworks.algafood-api)

- Carregando as permissões concedidas na autenticação

- [Carregando as Granted Authorities e restringindo acesso a endpoints na API](https://github.com/rodolfoHOk/algaworks.algafood-api)

- [Method Security: Restringindo acesso com @PreAuthorize e SpEL](https://github.com/rodolfoHOk/algaworks.algafood-api)

- [Tratando AccessDeniedException no ExceptionHandler](https://github.com/rodolfoHOk/algaworks.algafood-api)

- [Simplificando o controle de acesso em métodos com meta-anotações](https://github.com/rodolfoHOk/algaworks.algafood-api)

- Entendendo os escopos do OAuth2

- [Carregando Granted Authorities dos escopos do OAuth2 no Resource Server](https://github.com/rodolfoHOk/algaworks.algafood-api)

- [Restringindo acesso a endpoints por escopos do OAuth2](https://github.com/rodolfoHOk/algaworks.algafood-api)

- [Restringindo acesso dos endpoints de restaurantes](https://github.com/rodolfoHOk/algaworks.algafood-api)

- [Restringindo acessos de forma contextual (sensível à informação)](https://github.com/rodolfoHOk/algaworks.algafood-api)

- [Restringindo acessos com @PostAuthorize](https://github.com/rodolfoHOk/algaworks.algafood-api)

- [Restringindo acessos ao endpoint de pesquisa de pedidos](https://github.com/rodolfoHOk/algaworks.algafood-api)

- [Restringindo acessos aos endpoints de ... (5)](https://github.com/rodolfoHOk/algaworks.algafood-api)

- Configurando os clientes OAuth2 em um banco de dados SQL

- [Cadastrando clientes OAuth2 no banco de dados e testando a emissão de tokens](https://github.com/rodolfoHOk/algaworks.algafood-api)

- [Corrigindo lógica de restrição de acessos para Client Credentials Flow](https://github.com/rodolfoHOk/algaworks.algafood-api)

- [Gerando links do HAL dinamicamente de acordo com permissões](https://github.com/rodolfoHOk/algaworks.algafood-api)

- Juntando o Resource Server com o Authorization Server no mesmo projeto

- [Mais em AlgaFood API Repository](https://github.com/rodolfoHOk/algaworks.algafood-api)

## Repositórios dos projetos do curso

[Injeção de dependências com Spring IoC](https://github.com/rodolfoHOk/algaworks.esr.injecaodependencias)

[AlgaFood API](https://github.com/rodolfoHOk/algaworks.algafood-api)

[AlgaFood Relatórios com JasperReport](https://github.com/rodolfoHOk/algaworks.algafood-reports)

[AlgaFood Authorization Server](https://github.com/rodolfoHOk/algaworks.algafood-auth)

[AlgaFood JavaScript Client](https://github.com/rodolfoHOk/algaworks.algafood-js-client)

[AlgaFood JavaClient](https://github.com/rodolfoHOk/algaworks.algafood-java-client)

[FoodAnalytics JavaScript Client](https://github.com/rodolfoHOk/algaworks.foodanalytics-js-client)

## Outros arquivos markdown sobre o curso:

[Guia de requisições de autenticação para os clients](client-example.md)

[Guia de uso do Keytool](keytool-guia.md)

[Decidindo qual fluxo OAuth2 usar](decidindo-fluxo-oauth2.md)

[Conteúdo completo do curso ESR](conteudo-curso.md)

## Links Úteis

[Especificação do OAuth 2.0](https://datatracker.ietf.org/doc/html/rfc6749)

[Dependências para resolver problema com Spring Security OAuth2 e Java 11+](https://gist.github.com/thiagofa/ef9a40d495016cb2581add41b5cbde1b)

[RFC 7662 - OAuth 2.0 Token Introspection](https://datatracker.ietf.org/doc/html/rfc7662)

[Configuração de CORS no Authorization Server com CorsFilter](https://gist.github.com/thiagofa/764260dfd8ba21f30f2f79806d734563)

[RFC 7636 - PKCE](https://datatracker.ietf.org/doc/html/rfc7636)

[Implementação de PKCE para Spring Security OAuth2](https://gist.github.com/thiagofa/daca4f4790b5b18fed800b83747127ca)

[Ferramenta online para gerar Code Verifier e Code Challenge (PKCE)](https://tonyxu-io.github.io/pkce-generator/)

[RFC 7519 - JSON Web Token](https://datatracker.ietf.org/doc/html/rfc7519)

[Ferramenta online para debugging de JWT](https://jwt.io/)

[Bcrypt Generator](https://bcrypt-generator.com/)

[DDL da tabela de clientes OAuth2](https://gist.github.com/thiagofa/7b1792745d4de64bd86b230d0e3a381d)
