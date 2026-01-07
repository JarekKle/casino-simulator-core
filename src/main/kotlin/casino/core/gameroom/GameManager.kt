package main.kotlin.casino.core.gameroom

import main.kotlin.casino.core.game.IGame

object GameManager {
    private val activeRooms = mutableMapOf<Int, GameRoom>()
    var id: Int = 0
    fun getRoom(roomId: Int): GameRoom? = activeRooms.get(roomId)
    fun createRoom(game: IGame, playerLimit: Int) {
        activeRooms[id++] = GameRoom(game,playerLimit)
    }
    fun closeRoom(roomId: Int){
        activeRooms.remove(roomId)
    }
}