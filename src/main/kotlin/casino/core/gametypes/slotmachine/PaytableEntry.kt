package main.kotlin.casino.core.gametypes.slotmachine

data class PaytableEntry(
    val symbol: Symbol,
    val count: Int,
    val multiplier: Double
)
