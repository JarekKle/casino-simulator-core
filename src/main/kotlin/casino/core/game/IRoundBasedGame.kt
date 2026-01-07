package main.kotlin.casino.core.game

import main.kotlin.casino.core.domain.Player

interface IRoundBasedGame {
    fun startRound(){}
    fun endRound(){}
}