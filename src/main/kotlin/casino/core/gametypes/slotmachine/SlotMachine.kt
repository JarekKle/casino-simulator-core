package main.kotlin.casino.core.gametypes.slotmachine

class SlotMachine private constructor(
    val rows: Int,
    val cols: Int,
    private val symbols: List<Symbol>,
    private val payLines: List<PayLine>,
    private val paytable: List<PaytableEntry>
) {

    var board: Array<Array<Symbol>> = emptyArray()
        private set

    companion object {

        fun standard5x3HorizontalLines(): SlotMachine {
            val rows = 3
            val cols = 5

            val payLines = (0 until rows).map { row ->
                PayLine(
                    positions = (0 until cols).map { col -> row to col }
                )
            }

            val symbols = listOf(
                Symbol.CHERRY,
                Symbol.LEMON,
                Symbol.ORANGE,
                Symbol.BAR,
                Symbol.SEVEN
            )

            val paytable = buildPaytable(symbols)

            return SlotMachine(
                rows = rows,
                cols = cols,
                symbols = symbols,
                payLines = payLines,
                paytable = paytable
            )
        }

        private fun buildPaytable(symbols: List<Symbol>): List<PaytableEntry> {
            val lineCounts = listOf(3, 4, 5)
            val multipliers = listOf(2.0, 3.0, 5.0, 7.0, 9.0)

            val table = mutableListOf<PaytableEntry>()

            for (symbol in symbols) {
                for ((index, count) in lineCounts.withIndex()) {
                    table.add(
                        PaytableEntry(
                            symbol = symbol,
                            count = count,
                            multiplier = multipliers[index]
                        )
                    )
                }
            }
            return table
        }
    }

    fun spin() {
        board = Array(rows) {
            Array(cols) {
                randomSymbol()
            }
        }
    }
    fun calculateMultiplier(): Double {
        var totalMultiplier = 0.0

        for (payLine in payLines) {
            val symbolsOnLine = payLine.positions.map { (r, c) ->
                board[r][c]
            }

            val firstSymbol = symbolsOnLine.first()

            val matchCount = symbolsOnLine
                .takeWhile { it == firstSymbol }
                .count()

            val entry = paytable
                .filter {
                    it.symbol == firstSymbol && it.count <= matchCount
                }
                .maxByOrNull { it.count }

            if (entry != null) {
                totalMultiplier += entry.multiplier
            }
        }
        return totalMultiplier
    }


    private fun randomSymbol(): Symbol =
        symbols.random()

}