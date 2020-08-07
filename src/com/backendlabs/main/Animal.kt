package com.backendlabs.main

import kotlin.random.Random

interface Felino {
    fun ronronar()
    fun afiarUnhas()
}

abstract class Animal(
    open var quantidadeDeOlhos: Int,
    open var tempoDeGestacao: Int,
    open var quantidadeDeFilhotes: Int
) {

    private var monogamico: Boolean = true

    open fun reproduzir() {
        println("Nasceu em $tempoDeGestacao semanas")
        println("Quantidade possivel: $quantidadeDeFilhotes")
        println("Quantos nasceram: ${Random.nextInt(quantidadeDeFilhotes)}")
    }

    fun viraPoligamico() {
        monogamico = false
    }

    fun isMonogamico() = monogamico

}

data class Cachorro(
    override var quantidadeDeOlhos: Int,
    override var tempoDeGestacao: Int,
    override var quantidadeDeFilhotes: Int,
    var nome: String
) : Animal(
    quantidadeDeOlhos,
    tempoDeGestacao,
    quantidadeDeFilhotes
) {

    init {
        super.viraPoligamico()
    }

    fun reproduzir(cachorro: Cachorro) {
        println("${this.nome} pegou ${cachorro.nome}")
        super.reproduzir()
    }

    override fun toString(): String {
        return "Cachorro(quantidadeDeOlhos=$quantidadeDeOlhos, tempoDeGestacao=$tempoDeGestacao, quantidadeDeFilhotes=$quantidadeDeFilhotes, nome='$nome', monogamico=${super.isMonogamico()})"
    }
}

class Gato(
    override var quantidadeDeOlhos: Int,
    override var tempoDeGestacao: Int,
    override var quantidadeDeFilhotes: Int
) : Felino, Animal(quantidadeDeOlhos, tempoDeGestacao, quantidadeDeFilhotes) {
    override fun ronronar() {
        TODO("Not yet implemented")
    }

    override fun afiarUnhas() {
        TODO("Not yet implemented")
    }
}

data class Leao(
    override var quantidadeDeOlhos: Int,
    override var tempoDeGestacao: Int,
    override var quantidadeDeFilhotes: Int
) : Animal(
    quantidadeDeOlhos, tempoDeGestacao,
    quantidadeDeFilhotes
) {
    override fun reproduzir() {
        super.reproduzir()
        super.viraPoligamico()
    }
}

open class Oviparos(
    override var quantidadeDeOlhos: Int,
    override var tempoDeGestacao: Int,
    override var quantidadeDeFilhotes: Int,
    open var quantidadeDeOvosPorDia: Int
) : Animal(
    quantidadeDeOlhos,
    tempoDeGestacao,
    quantidadeDeFilhotes
) {
    fun botarOvo() {
        println("Vou botar $quantidadeDeOvosPorDia ovos hoje.")
    }
}

class Cobra(
    override var quantidadeDeOlhos: Int,
    override var tempoDeGestacao: Int,
    override var quantidadeDeFilhotes: Int,
    override var quantidadeDeOvosPorDia: Int
) : Oviparos(
    quantidadeDeOlhos,
    tempoDeGestacao,
    quantidadeDeFilhotes,
    quantidadeDeOvosPorDia
)

class Aves(
    override var quantidadeDeOlhos: Int,
    override var tempoDeGestacao: Int,
    override var quantidadeDeFilhotes: Int,
    override var quantidadeDeOvosPorDia: Int
) : Oviparos(
    quantidadeDeOlhos,
    tempoDeGestacao,
    quantidadeDeFilhotes,
    quantidadeDeOvosPorDia
)


class Periquito(
    override var quantidadeDeOlhos: Int,
    override var tempoDeGestacao: Int,
    override var quantidadeDeFilhotes: Int,
    override var quantidadeDeOvosPorDia: Int
) : Oviparos(
    quantidadeDeOlhos,
    tempoDeGestacao,
    quantidadeDeFilhotes,
    quantidadeDeOvosPorDia
)


fun main() {

    val simba = Leao(quantidadeDeFilhotes = 5, quantidadeDeOlhos = 2, tempoDeGestacao = 15)
    val salsicha = Cachorro(quantidadeDeOlhos = 2, tempoDeGestacao = 15, quantidadeDeFilhotes = 7, nome = "Salsicha")
    val faisca = Cachorro(quantidadeDeOlhos = 2, tempoDeGestacao = 15, quantidadeDeFilhotes = 7, nome = "Faísca")

    simba.reproduzir()
    salsicha.reproduzir(faisca)
    println("Salsicha é: $salsicha")
    println("Simba é: $simba")

}