package main.kotlin.casino.core.gametypes.scratchcard

import main.kotlin.casino.core.domain.Player
import main.kotlin.casino.core.game.Bet
import main.kotlin.casino.core.game.GameType
import main.kotlin.casino.core.game.IGame

class ScratchCardGame: IGame{
    override val name: GameType = GameType.SCRATCHCARD
    override val minPlayers: Int = 1
    override val maxPlayers: Int = 1
    override val supportedBets: List<Float> = listOf(1f, 5f, 10f, 20f)
    override val bets: MutableMap<Player, Bet> = mutableMapOf()
    override var isGameActive: Boolean = false

    private lateinit var scratchCard: ScratchCard

    override fun startGame(players: List<Player>) {
        require(players.size == maxPlayers) {"Number of players must be $maxPlayers"}
        require(bets.isNotEmpty()) { "Bet must be placed before starting the game" }
        scratchCard = ScratchCard.standard3x3()
        isGameActive = true

    }
    override fun endGame(){
        require(isGameActive) { "Game is not active" }

        scratchCard.revealAllFields()
        val reward = scratchCard.calculateReward()
        val (player, bet) = bets.entries.first()
        val payout = reward * bet.amount
        player.addBalance(payout)
        bets.clear()
        isGameActive = false
    }
    override fun placeBet(player: Player, amount: Float){
        require(!isGameActive) { "Cannot place a bet while the game is active" }
        require(supportedBets.contains(amount)) { "Unsupported bet amount, possible bets: $supportedBets" }
        require(!bets.containsKey(player)) { "Bet already placed for player: $player" }

        player.subtractBalance(amount)
        bets[player] = Bet(amount)
    }

    fun scratchField(index: Int){
        require(isGameActive) { "Game is not active" }
        scratchCard.scratchField(index)
    }
}