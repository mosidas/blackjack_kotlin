package blackjack

class Player(n:String,m:Int){
    var hands:MutableList<Hand> = ()
    private set
    var money:Int = m
    private set
    var bet:Int = 0
    private set
    var name:String = n
    private set
    var isSurender:Boolean = false
    private set

    fun addMoney(r:Result){
        when(r){
            Result.Win->this.money += this.bet
            Result.Lose->this.money -= this.bet
            Result.Surrender->this.money -= this.bet/2
        }
    }

    fun betMoney(b:Int){
        this.bet = b
    }

    fun reset(){
        this.isSurender = false
        hands = ()
        hands.add(Hand())
    }

    fun isGameOver():Boolean{
        return money == 0
    }

    fun canSplit():Boolean{
        var h1 = Hand()
        h1.add(hands.get(0).toList().get(0))

        var h2 = Hand()
        h2.add(hands.get(0).toList().get(1))

        return hands.size == 1 && h1.score() == h2.score() && money >= bet * 2
    }

    fun split(deck:Deck){
        hands.add(Hand())
        hands.get(1).add(hands.get(0).toList().get(1));
        hands.get(0).toList().removeAt(1);
        hands.get(0).hit(deck);
        hands.get(1).hit(deck);
    }

    fun surrender(){
        isSurender = true
    }
}