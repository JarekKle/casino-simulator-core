package main.kotlin.casino.core.game

import main.kotlin.casino.core.domain.Player

interface IRoundBasedGame {
    var isRoundActive: Boolean
    fun startRound(){}
    fun endRound(){}
}