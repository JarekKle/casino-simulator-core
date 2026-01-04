package main.kotlin.casino.core.gametypes.scratchcard


data class Field(
    val symbol: Symbol,
    var isScratched: Boolean = false
)
