package main.kotlin.casino.core.gametypes.scratchcard

class ScratchCard private constructor(
    val rows: Int,
    val cols: Int,
    private val fields: List<Field>,
) {

    companion object {
        fun standard3x3(): ScratchCard {
            val symbolWeights: Map<Symbol, Int> = mapOf(
                Symbol.CHERRY to 10,
                Symbol.LEMON to 8,
                Symbol.STAR to 7,
                Symbol.DIAMOND to 3,
                Symbol.SKULL to 15
            )
            val symbolPool = symbolWeights.flatMap { (symbol, weight) ->
                List(weight) { symbol }
            }

            val fields = symbolPool
                .shuffled()
                .take(9)
                .map{Field(it)}


            return ScratchCard(3, 3, fields)
        }
    }

    fun scratchField(index: Int) {
        require(index in fields.indices) { "Invalid field index" }
        fields[index].isScratched = true
    }

    fun revealAllFields() {
        fields.forEach { it.isScratched = true }
    }

    fun calculateReward(): Int {
        val revealedSymbols = fields
            .filter { it.isScratched }
            .groupingBy { it.symbol }
            .eachCount()

        val winningSymbol = revealedSymbols
            .filter { it.value >= 3 }
            .keys
            .maxByOrNull { it.reward }

        return winningSymbol?.reward ?: 0
    }
    fun getFields(): List<Field> = fields
}