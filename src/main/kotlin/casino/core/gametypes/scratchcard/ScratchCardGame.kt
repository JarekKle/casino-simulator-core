import main.kotlin.casino.core.domain.Player
import main.kotlin.casino.core.game.Bet
import main.kotlin.casino.core.game.GameType
import main.kotlin.casino.core.game.IGame
import main.kotlin.casino.core.gametypes.scratchcard.ScratchCard

class ScratchCardGame : IGame {

    override val name = GameType.SCRATCHCARD
    override val minPlayers = 1
    override val maxPlayers = 1
    override val supportedBets = listOf(1f, 5f, 10f, 20f)
    override val bets = mutableMapOf<Player, Bet>()

    private lateinit var scratchCard: ScratchCard

    override fun startGame() {
        scratchCard = ScratchCard.standard3x3()
    }

    override fun endGame(): Map<Player, Float> {
        scratchCard.revealAllFields()

        val reward = scratchCard.calculateReward()
        val (player, bet) = bets.entries.first()
        bets.clear()
        return mapOf(player to reward * bet.amount)
    }

    override fun placeBet(player: Player, bet: Bet) {
        bets[player] = bet
    }

    fun scratchField(index: Int) {
        scratchCard.scratchField(index)
    }
}
