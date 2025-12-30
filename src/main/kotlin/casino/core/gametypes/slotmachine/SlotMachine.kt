package main.kotlin.casino.core.gametypes.slotmachine

class SlotMachine private constructor(
    val rows: Int,
    val cols: Int,
    private val symbols: List<Symbol>,
    private val payLines: List<PayLine>,
    private val payoutTable: Map<Symbol, Int>
) {

    var board: Array<Array<Symbol>> = emptyArray()
        private set

    companion object {
        fun standard3x3(): SlotMachine {
            val symbols = listOf(
                Symbol.CHERRY,
                Symbol.LEMON,
                Symbol.ORANGE,
                Symbol.BAR,
                Symbol.SEVEN
            )

            val payLines = listOf(
                PayLine(listOf(0 to 0, 0 to 1, 0 to 2)),
                PayLine(listOf(1 to 0, 1 to 1, 1 to 2)),
                PayLine(listOf(2 to 0, 2 to 1, 2 to 2))
            )

            val payoutTable = mapOf(
                Symbol.CHERRY to 2,
                Symbol.LEMON to 3,
                Symbol.ORANGE to 5,
                Symbol.BAR to 10,
                Symbol.SEVEN to 50
            )

            return SlotMachine(
                rows = 3,
                cols = 3,
                symbols = symbols,
                payLines = payLines,
                payoutTable = payoutTable
            )
        }
    }

    fun spin() {
    }

    fun calculateReward(): Int {
        return TODO("Provide the return value")
    }
}