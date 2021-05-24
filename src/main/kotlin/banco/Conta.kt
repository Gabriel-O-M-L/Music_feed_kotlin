package banco

class Conta {
    var userId: Int? = null
    var nome: String? = null
    var senha: String? = null
    var artistasMutableList = mutableListOf<Int>()
    var musicasMutableList = mutableListOf<Int>()
    var albunsMutableList = mutableListOf<Int>()
}