package main.kotlin.casino.core.gametypes.roulette

import main.kotlin.casino.core.game.GameType
import main.kotlin.casino.core.game.IGame
import main.kotlin.casino.core.game.IRoundBasedGame

class RouletteGame: IGame, IRoundBasedGame {
    override val name: GameType = GameType.ROULETTE
    override val minPlayers: Int = 1
    override val maxPlayers: Int = 1
    override val supportedBets: List<Double> = listOf(0.5, 1.0, 2.0, 5.0, 10.0, 20.0, 50.0, 100.0, 200.0, 500.0)
    override val isGameActive: Boolean = false
    override var isRoundActive: Boolean = false
}