package main.kotlin.casino.core.gametypes.blackjack

import main.kotlin.casino.core.cards.Card
import main.kotlin.casino.core.cards.Deck
import main.kotlin.casino.core.domain.Player
import main.kotlin.casino.core.game.Bet
import main.kotlin.casino.core.game.GameType
import main.kotlin.casino.core.game.IGame
import main.kotlin.casino.core.game.IRoundBasedGame

class BlackJackGame: IGame, IRoundBasedGame {
    override val name: GameType = GameType.BLACKJACK
    override val minPlayers: Int = 1
    override val maxPlayers: Int = 6
    override val supportedBets: List<Float> = listOf(1.0f, 5.0f, 10.0f, 20.0f)
    override val bets: MutableMap<Player, Bet> = mutableMapOf()
    override val isGameActive: Boolean = false
    override var isRoundActive: Boolean = false

    private val deck: Deck = Deck.standard52()
    private val playerHands = mutableMapOf<Player, MutableList<Card>>()
    private val dealerHand = mutableListOf<Card>()



}