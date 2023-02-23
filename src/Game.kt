package blackjack

class Game(gameSettings:GameSettings){
    val gameSettings = gameSettings
    var deck :Deck = Deck(gameSettings.deckCount)
    private set
    val players : MutableList<Player> = initPlayers(gameSettings.playerCount, gameSettings.defaultMoney)
    val dealder : Dealer = Dealer()


    fun initPlayers(n:Int,m:Int):MutableList<Player>{
        var ps:MutableList<Player> = ()
        for(i in 1..n){
            ps.add(Player("プレイヤー" + (i + 1),m))
        }

        return ps
    }

    fun activePlayers():MutableList<Player>{
        return players.filter{!it.isGameOver()}.toMutableList()
    }

}

enum class Result{
    Win,
    Lose,
    Draw,
    Surrender
}