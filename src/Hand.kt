package blackjack

class Hand(){
    private var cards: MutableList<Card> = ()

    fun add(card:Card){
        this.cards.add(card)
    }

    fun hit(deck:Deck){
        add(deck.pop())
    }

    fun toList():MutableList<Card>{
        return this.cards
    }

    fun isBust():Boolean{
        return score() > 21
    }

    fun isSoft17():Boolean{
        return score() == 17 && this.cards.any{it.number == 1}
    }

    fun score():Int{
        var score = this.cards.filter{ it.number <= 10 }.map{ it.number }.sum() +
         (this.cards.filter{it.number > 10}.count() * 10)

        if(this.cards.any{it.number == 1} && score + 10 <= 21){
            score += 10
        }
        return score
    }
}