package blackjack

class Card(val suit: Suit, val number: Int){

    fun toText():String{
        var mark = when(this.suit){
            Suit.Heart -> "♡"
            Suit.Crab -> "♣"
            Suit.Spade -> "♠"
            Suit.Diamond -> "♦"
        }

        var number = when(this.number){
            1-> "A"
            11-> "J"
            12-> "Q"
            13-> "K"
            else-> this.number.toString()

        }
        return mark + number
    }
}

enum class Suit {
    Heart,
    Crab,
    Spade,
    Diamond
}