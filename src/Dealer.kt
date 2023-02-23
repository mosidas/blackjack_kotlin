package blackjack

class Dealer(){
    var hand :Hand = Hand()
    private set

    fun initDeck(n:Int):Deck{
        return Deck(n)
    }

    fun deal(deck:Deck, players:List<Player>){
        for(player in players){
            player.reset()
            player.hands.get(0).hit(deck)
            player.hands.get(0).hit(deck)
        }

        this.hand = Hand()
        this.hand.hit(deck)
        this.hand.hit(deck)
    }

    fun doDealersTurn(deck:Deck, isSoft17:Boolean){
        while(!this.hand.isBust() && (this.hand.score() < 17 ||(this.hand.isSoft17() && isSoft17))){
            this.hand.hit(deck)
        }
    }
}