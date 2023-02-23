package blackjack

class Deck{
    private var deck : MutableList<Card> = ()

    constructor(deckNumber:Int){
        this.deck = ()

        var suits = Suit.values()
        var numbers = 1..13
        for(n in 1..deckNumber){
            for(suit in suits){
                for(num in numbers){
                    var card = Card(suit, num)
                    this.deck.add(card)
                }
            }
        }
        this.deck.shuffle()
    }

    fun pop():Card{
        var card = this.deck.get(0)
        this.deck.removeAt(0)
        return card
    }

    fun size():Int{
        return this.deck.size
    }
}