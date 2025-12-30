package main.kotlin.casino.core.gameroom

import main.kotlin.casino.core.game.IGame

object GameManager {
    private val activeRooms = mutableMapOf<String, GameRoom>()
    fun getRoom(roomId: Int): GameRoom {
        return TODO("Provide the return value")
    }
    fun createRoom(game: IGame, playerLimit: Int) {}
    fun closeRoom(id: String) {}
}