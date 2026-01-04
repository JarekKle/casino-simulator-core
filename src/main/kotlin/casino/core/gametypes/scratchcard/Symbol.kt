package main.kotlin.casino.core.gametypes.scratchcard

enum class Symbol(val reward: Int) {
    CHERRY(1),
    LEMON(2),
    STAR(5),
    DIAMOND(10),
    SKULL(0)
}