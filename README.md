# AlgaFood Authorization Server - Curso Especialista Spring Rest da AlgaWorks

## Conteúdo (histórico de commits em ordem cronológica):

### 21 - Segurança com Spring Security e OAuth2

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

- [Decidindo qual fluxo OAuth2 usar](decidindoFluxoOAuth2.md)

### 22 - OAuth2 avançado com JWT e controle de acesso

- Armazenando tokens no Redis: um banco de dados NoSQL

- Configurando o RedisTokenStore

- Entendendo a diferença entre Stateful e Stateless Authentication

- Transparent Tokens: conhecendo o JSON Web Tokens (JWT)

- Gerando JWT com chave simétrica (HMAC SHA-256) no Authorization Server

- [Configurando o Resource Server para JWT assinado com chave simétrica](https://github.com/rodolfoHOk/algaworks.algafood-api)

- Entendendo a diferença entre assinatura com chave simétrica e assimétrica

- Gerando um par de chaves com keytool

- Assinando o JWT com RSA SHA-256 (chave assimétrica)

- Extraindo a chave pública no formato PEM

- [Configurando a validação de JWT no Resource Server com a chave pública](https://github.com/rodolfoHOk/algaworks.algafood-api)

- Revisando o fluxo de aprovação do Authorization Code com JWT

- 

## AlgaFood API Repository

### GitHub

https://github.com/rodolfoHOk/algaworks.algafood-api

## Keytool (Ferramenta para gerar par de chaves para usar no token assimétrico)

### Gerando um arquivo JKS com um par de chaves

CMD Exemplo: keytool -genkeypair -alias algafood -keyalg RSA -keypass 123456 -keystore algafood.jks -storepass 123456 -validity 3650

### Listando as entradas de um arquivo JKS

CMD Exemplo: keytool -list -keystore algafood.jks

### Gerando o certificado

CMD Exemplo: keytool -export -rfc -alias algafood -keystore algafood.jks -file algafood-cert.pem

### Gerando a chave pública

CMD Exemplo: openssl x509 -pubkey -noout -in algafood-cert.pem > algafood-pkey.pem

## Links Úteis

### Especificação do OAuth 2.0

https://datatracker.ietf.org/doc/html/rfc6749

### Dependências para resolver problema com Spring Security OAuth2 e Java 11+

https://gist.github.com/thiagofa/ef9a40d495016cb2581add41b5cbde1b

### RFC 7662 - OAuth 2.0 Token Introspection

https://datatracker.ietf.org/doc/html/rfc7662

### Configuração de CORS no Authorization Server com CorsFilter 

https://gist.github.com/thiagofa/764260dfd8ba21f30f2f79806d734563

### RFC 7636 - PKCE

https://datatracker.ietf.org/doc/html/rfc7636

### Implementação de PKCE para Spring Security OAuth2 

https://gist.github.com/thiagofa/daca4f4790b5b18fed800b83747127ca

### Ferramenta online para gerar Code Verifier e Code Challenge (PKCE)

https://tonyxu-io.github.io/pkce-generator/

### RFC 7519 - JSON Web Token

https://datatracker.ietf.org/doc/html/rfc7519

### Ferramenta online para debugging de JWT

https://jwt.io/
