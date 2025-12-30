package main.kotlin.casino.core.cards

class Deck(private val initialCards: MutableList<Card>) {
    private val drawPile: MutableList<Card> = initialCards.toMutableList()
    private val discardPile: MutableList<Card> = mutableListOf()
    companion object {
        fun standard52(): Deck {
            val cards = mutableListOf<Card>()
            for (suit in Suit.entries)
                for (rank in Rank.entries)
                    if (rank!= Rank.JOKER && suit != Suit.WILD)
                        cards.add(Card(rank, suit))
            return Deck(cards)
        }
    }

    fun shuffle(){}
    fun discard(card: Card): Card{
        return TODO("Provide the return value")
    }
    fun draw(): Card{
        return TODO("Provide the return value")
    }
    fun reset(){}

}