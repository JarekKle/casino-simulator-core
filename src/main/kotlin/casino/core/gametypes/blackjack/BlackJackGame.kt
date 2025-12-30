package main.kotlin.casino.core.gametypes.blackjack

import main.kotlin.casino.core.cards.Card
import main.kotlin.casino.core.cards.Deck
import main.kotlin.casino.core.domain.Player
import main.kotlin.casino.core.game.GameType
import main.kotlin.casino.core.game.IGame
import main.kotlin.casino.core.game.IRoundBasedGame

class BlackJackGame: IGame, IRoundBasedGame {
    override val name: GameType = GameType.BLACKJACK
    override val minPlayers: Int = 1
    override val maxPlayers: Int = 6
    override val supportedBets: List<Double> = listOf(0.5, 1.0, 2.0, 5.0, 10.0, 20.0, 50.0, 100.0, 200.0, 500.0)
    override val isGameActive: Boolean = false
    override var isRoundActive: Boolean = false

    private val deck: Deck = Deck.standard52()
    private val playerHands = mutableMapOf<Player, MutableList<Card>>()
    private val dealerHand = mutableListOf<Card>()



}