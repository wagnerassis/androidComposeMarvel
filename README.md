# androidComposeMarvel
POC para testar habilidades em Kotlin e JetPack Compose

# Marvel HQ Manager

App Android de gerenciamento de HQs da Marvel, desenvolvido com Kotlin, Jetpack Compose e arquitetura MVVM.  

## Descrição

O **Marvel HQ Manager** integra com a API pública da Marvel para listar quadrinhos (comics), permite paginação infinita e oferece recurso de marcar/desmarcar HQs como favoritas, armazenando-as localmente com Room :contentReference[oaicite:0]{index=0}:contentReference[oaicite:1]{index=1}.

## Funcionalidades

- **Listagem de HQs**  
  - Busca quadrinhos via endpoint `GET /v1/public/comics` da Marvel API  
  - Paginação dinâmica, carregando 15 itens por vez à medida que o usuário rola a lista :contentReference[oaicite:2]{index=2}:contentReference[oaicite:3]{index=3}  
- **Favoritos**  
  - Marcar e desmarcar HQs como favoritas  
  - Seção separada para visualizar apenas as HQs favoritas :contentReference[oaicite:4]{index=4}:contentReference[oaicite:5]{index=5}  
- **Arquitetura e boas práticas**  
  - MVVM (ViewModel + LiveData/Flow)  
  - DI com Hilt  
  - UI declarativa com Jetpack Compose  
  - Persistência local com Room  
  - Paginação com Paging 3  
  - Redes com Retrofit + OkHttp + Moshi/Gson  
  - Carregamento de imagens com Coil  

## Tecnologias e Bibliotecas

| Camada             | Biblioteca                           |
|--------------------|--------------------------------------|
| UI                 | Jetpack Compose, Navigation Compose  |
| ViewModel & Flow   | androidx.lifecycle, kotlin-coroutines |
| DI                 | Hilt                                 |
| Rede               | Retrofit2, OkHttp3, Moshi/Gson       |
| Paginação          | Paging 3, Paging-Compose             |
| Imagens            | Coil Compose                         |
| Persistência       | Room                                 |
| Testes             | JUnit, AndroidX Test, Espresso       |

## Pré-requisitos

- Android Studio Giraffe ou superior  
- JDK 17  
- Dispositivo ou emulador Android API 31+

## Configuração

1. **Clonar o repositório**
   git clone https://github.com/seu-usuario/MarvelHQManager.git
   cd MarvelHQManager

2. **Obter chaves da Marvel**
   
Crie uma conta em developer.marvel.com
Copie sua public key e private key

3. **Adicionar as chaves**
No arquivo gradle.properties (crie na raiz, se não existir), adicione:
marvelPublicKey={key}
marvelPrivateKey={key}

4. **Sincronizar o Gradle**
Abra o projeto no Android Studio e clique em Sync Project.

5. **Integração com a Marvel API**
Todas as requisições são autenticadas via query parameters:

ts: timestamp (ou string única por requisição)

apikey: sua public key

hash: MD5 de ts + privateKey + publicKey

Exemplo de URL gerada:

https://gateway.marvel.com/v1/public/comics?ts=1&apikey=72e4c2dce7655ef289addb44433b756c8803d&hash=6008f1003e9056fjfjhdabbe1934b7ec5bfdd1

6. **Build & Run**
No Android Studio, selecione o módulo app e clique em Run > app.
