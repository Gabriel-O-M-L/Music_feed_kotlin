# API para feed de musica

## IESB Progamação orientada a Objetos 2021

## Ambiente
API roda em kotlin com integração do Ktor pela IDE IntelliJ IdeaC, o intrumento de Build usado foi o Kotlin Groovy ja integrado na IDE, A api usara arquivos do tipo JSON,
O progama de teste para as rotas sera o POSTMAN, um servidor em nuvem que sera utilizado sera o heroku

## Membros
1. Gabriel Oliveira Moura Lima 1912130050
2. Gabriel Bezerra dos Santos 1822130051
3. Frederico Paixão Soares Coqueiro 1912072026
4. Hiel Alves Rocha 1822130018

## Linguagem usada **Koltin**


## Descriçao

A api possue atualmente 6 classes, 3 que serão acessadas diretamente pelo usuario, utilizando funções para, criar objetos, modificar objetos e deletar objetos.
As funções serão acessadas por rotas, enviadas pelo aplicativo POSTMAN

OBS: a classe ControleInterface foi criada somente para demonstrar a utilização do polimorfismo

## Apesar de existir rotas para login e criação de usuario, não há utilidade estabelecida no momento, pois a utilização destas classes esta delegada a funções que não usam de chamadas no servidor. Caso queira entender como sera usado o objeto de usuario, entr nas classes AdministraConta e no pacote recommend

## Rotas
"POST - /profile                         - Cria um usuario" 

"GET - /profile                          - Confere se um Usuario foi encontado" 

"POST - /login                           - Entra em um usuario" 

"PATCH - /editar/interfaceUsuario        - Edita Aspectos visuais de um usuario"

"POST - /artista/criar                   - Criar Artista"

"POST - /album/criar                     - Criar Album"

"POST - /musica/criar                    - Criar Musica"

"PATCH - /artista/editar                 - Editar Artista"

"PATCH - /editar/interfaceArtista        - Edita Aspectos visuais de um artista"

"PATCH - /album/editar                   - Editar ALbum"

"PATCH - /musica/editar                  - Editar Musica"

"DELETE - /artista/deletar               - Deletar Artista"

"DELETE - /album/deletar                 - Deletar Album"

"DELETE - /musica/deletar                - Deletar Musica"

"GET - /artista/listar                   - Listar Artista"

"GET - /album/listar                     - Listar Album"

"GET - /musica/listar                    - Listar Musica"

"POST - /artista/buscar                  - Buscar Artista" 

"POST - /album/buscar                    -  Buscar Album" 

"POST - /musica/buscar                   - Buscar Musica" 

## Sintaxe do JSON para criar objetos

## Usuario:

email: String,

name: String,

senha: String

## ARTISTA:

nome: String,

nacionalidade: String,

foto: String,

tag: String

descricao: String

link: String,

## ALBUM:

nome: String,

link: String,

genero: String,

duracao: String,

produtor: String,

compositores: String

descricao: String,

capa: String,

artistaID: String = ID do artista a ser editado

## MUSICA:

artistaID: String, = ID do artista a ser editado

nome: String,

link: String,

duracao: String,

produtor: String,

descricao: String,

albumID: Int = ID do album a ser ligado a musica

## Sintaxe de login:

email: String,

senha: String

## Sintaxe do JSON para editar objetos

## Usuario

name: String,

foto: String,

idArtista: String

## ARTISTA:

artistaID: String, = ID do artisat a ser editado

nacionalidade: String,

descricao: String,

link: String,

tag: String

## Artista Interface:

nome: String,

foto: String,

idArtista: String

## ALBUM:

nome: String,

link: String,

editID: String, = ID do objeto a ser ligado a o objeto que vai ser editado

objectID: String, = ID do objeto a ser editado

genero: String,

descricao: String,

compositores: String,

duracao: String,

produtor: String,

capa: String

## MUSICA:

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

## Sintaxe do JSON para deletar Objetos

## ARTISTA:
objectID: String = ID do objeto a ser editado

## ALBUM:
objectID: String = ID do objeto a ser editado

## MUSICA:
objectID: String = ID do objeto a ser editado

## Sintaxe da Busca de objeto

## ARTISTA:

nome: String

## ALBUM:

nome: String

## MUSICA:

nome: String

