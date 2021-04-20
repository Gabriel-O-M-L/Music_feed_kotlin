# API para feed de musica

## IESB Progamação orientada a Objetos 2021

## Ambiente
Api roda em kotlin com integração do Ktor pela IDE IntelliJ IdeaC, o intrumento de Build usado foi o Kotlin Groovy ja integrado na IDE, A api usara arquivos do tipo JSON,
O progama de teste para as rotas sera o POSTMAN

## Membros
1. Gabriel Oliveira Moura Lima 1912130050
2. Gabriel Bezerra dos Santos 1822130051
3. Frederico Paixão Soares Coqueiro 1912072026
4. Hiel Alves Rocha 1822130018

## Linguagem usada **Koltin**


## Descriçao

A api possue atualmente 6 classes, 3 que serão acessadas diretamente pelo usuario, utilizando funções para, criar objetos, modificar objetos e deletar objetos.
As funções serão acessadas por rotas, enviadas pelo aplicativo POSTMAN

## Rotas
"POST - /artista/criar                   - Criar Artista"

"POST - /album/criar                     - Criar Album"

"POST - /musica/criar                    - Criar Musica"

"PATCH - /artista/editar                 - Editar Artista"

"PATCH - /album/editar                   - Editar ALbum"

"PATCH - /musica/editar                  - Editar Musica"

"DELETE - /artista/deletar               - Deletar Artista"

"DELETE - /album/deletar                 - Deletar Album"

"DELETE - /musica/deletar                - Deletar Musica"

"GET - /artista/listar                   - Listar Artista"

"GET - /album/listar                     - Listar Album"

"GET - /musica/listar                    - Listar Musica"

## Sintaxe do JSON para criar objetos

##ARTISTA:

nome: String,

nacionalidade: String,

foto: String,

descricao: String

##ALBUM:

nome: String,

link: String,

genero: String,

duracao: String,

produtor: String,

compositores: String

descricao: String,

capa: String,

artistaID: Int

##MUSICA:

artistaID: Int,

nome: String,

link: String,

duracao: String,

produtor: String,

descricao: String,

albumID: Int

## Sintaxe do JSON para editar objetos

##ARTISTA:

nome: String,

artistaID: Int,

nacionalidade: String,

descricao: String,

foto: String,

link: String

##ALBUM:

nome: String,

link: String,

editID: Int, = ID do objeto a ser ligado a o objeto que vai ser editado

objectID: Int, = ID do objeto a ser editado

genero: String,

descricao: String,

compositores: String,

duracao: String,

produtor: String,

capa: String

##MUSICA:

nome: String,

link: String,

editID: Int,

objectID: Int,

genero: String,

descricao: String,

compositores: String,

duracao: String,

produtor: String,

capa: String

## Sintaxe do JSON para deletar Objetos

#ARTISTA:
objectID: Int

#ALBUM:
objectID: Int

#MUSICA:
objectID: Int

