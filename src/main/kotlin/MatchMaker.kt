import constants.Tier
import model.Player
import kotlin.math.round
import kotlin.math.roundToInt
import kotlin.random.Random

class MatchMaker {
    private var players: ArrayList<Player> = ArrayList()
    var teamA: ArrayList<Player> = ArrayList()
    var teamB: ArrayList<Player> = ArrayList()

    fun add(player: Player) {
        players.add(player)
    }

    fun commit() {
        calculateAll()
    }

    fun calculateAll() {
        players.map { player ->
            player.maxTierPoint = calculateTierPoint(player)
        }
        players = ArrayList(players.sortedWith(compareByDescending { it.maxTierName.code }))
        val randomBoolean = Random.nextBoolean()
        val (teamA, teamB) = players.partition { player ->
            val reminder = players.indexOf(player) % 2
            if (randomBoolean) reminder == 0 else reminder != 0
        }
        this.teamA = teamA as ArrayList<Player>
        this.teamB = teamB as ArrayList<Player>
    }

    fun calculateTierPoint(player: Player): Int {
        val tierCalculated: Double = player.maxTierName.code * player.maxTierName.tierRatio
        // println("calculateTierPoint:tierCalculated:${tierCalculated}")
        var levelCalculated: Double = player.maxTierLevel.toDouble()
        if (!player.maxTierName.isLevelPoint) {
            levelCalculated = 5 - levelCalculated
        }
        levelCalculated *= player.maxTierName.levelRatio
        // println("calculateTierPoint:levelCalculated:${levelCalculated}")
        val tierPoint = tierCalculated + levelCalculated
        return tierPoint.roundToInt()
    }
}