package main.kotlin.casino.core.gametypes.roulette


class Roulette private constructor(private val tiles: List<Tile>) {
    var lastResult: Tile = Tile(0, Color.GREEN)

    companion object {
        fun standardEuropean(): Roulette {
            val tiles = mutableListOf<Tile>()
            tiles.add(Tile(0, Color.GREEN))
            val redNumbers = setOf(
                1, 3, 5, 7, 9, 12, 14, 16, 18,
                19, 21, 23, 25, 27, 30, 32, 34, 36
            )
            for (number in 1..36) {
                val color = if (redNumbers.contains(number))
                    Color.RED
                else
                    Color.BLACK

                tiles.add(Tile(number, color))
            }
            return Roulette(tiles)
        }
    }

    fun spin(): Tile {
        lastResult = tiles.random()
        return lastResult
    }
}