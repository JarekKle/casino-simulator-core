package main.kotlin.casino.core.gametypes.scratchcard

class ScratchCard private constructor(
    val rows: Int,
    val cols: Int,
    private val fields: List<Field>
) {

    companion object {
        fun standard3x3(): ScratchCard {
            val prizesPool = listOf(0, 0, 0, 10, 10, 20, 50, 100, 200)
                .shuffled()

            val fields = prizesPool.map { prize ->
                Field(prize)
            }

            return ScratchCard(
                rows = 3,
                cols = 3,
                fields = fields
            )
        }
    }

    fun scratchField(index: Int) {
    }

    fun revealAllFields() {
    }

    fun calculateReward(): Int {
        return TODO("Provide the return value")
    }

    fun getFields(): List<Field>{
        return fields
    }
}