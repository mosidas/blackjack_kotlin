package blackjack

import kotlin.text.toInt

class BlackjackCui() {
    fun play(){
        showTitle()

        getGameSettings()

    }

    fun showTitle(){
        println("++++++++++++++++++++++++++");
        println("++++++++++++++++++++++++++");
        println("+++++++ Blackjack  +++++++");
        println("++++++++++++++++++++++++++");
        println("++++++++++++++++++++++++++");
    }

    fun getGameSettings(): GameSettings {
        var pc = getPlayerNumber()
        var dc = getDeckNumber()
        var s17 = getHitSoft17()
        var dm = getDefaultMoney()

        return GameSettings(pc, dc, s17, dm)
    }

    fun getPlayerNumber():Int{
        while(true){
            print("プレイヤー数:1～8 →")
            var ret = readLine()?.toIntOrNull()

            when(ret){
                null->println("1～8の整数値を入力してください")
                in 1..8->return ret
                else->println("1～8の整数値を入力してください")
            }
        }
    }

    fun getDeckNumber():Int{
        while(true){
            print("デッキ数:1～8 →")
            var ret = readLine()?.toIntOrNull()

            when(ret){
                null->println("1～8の整数値を入力してください")
                in 1..8->return ret
                else->println("1～8の整数値を入力してください")
            }
        }
    }

    fun getHitSoft17():Boolean{
        while(true){
            print("ソフト17(1:ヒットする  2:スタンドする):→")
            var ret = readLine()?.toIntOrNull()

            when(ret){
                null->println("1か2を入力してください")
                1->return true
                2->return false
                else->println("1か2を入力してください")
            }
        }
    }

    fun getDefaultMoney():Int{
        while(true){
            print("最初の所持金:10～100000 →")
            var ret = readLine()?.toIntOrNull()

            when(ret){
                null->println("10～100000の整数値を入力してください")
                in 10..100000->return ret
                else->println("10～100000の整数値を入力してください")
            }
        }
    }

    fun getContinue():Int{
        return 1

    }
}