import model.Player
import kotlin.math.roundToInt
import kotlin.random.Random

class MatchMaker {
    companion object {
        private const val TEAM_SIZE = 5
    }

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
        players.shuffled().map { player ->
            player.maxTierPoint = calculateTierPoint(player)
        }
//        players = ArrayList(players.sortedWith(compareByDescending { it.maxTierName.code }))
//        val randomBoolean = Random.nextBoolean()
//        val (teamA, teamB) = players.partition { player ->
//            val reminder = players.indexOf(player) % 2
//            if (randomBoolean) reminder == 0 else reminder != 0
//        }
//        this.teamA = teamA as ArrayList<Player>
//        this.teamB = teamB as ArrayList<Player>

        partitionByNearlyEqualSums()
    }

    fun calculateTierPoint(player: Player): Int {
        val tierCalculated: Double = player.maxTierName.code * player.maxTierName.tierRatio
        // println("calculateTierPoint:tierCalculated:${tierCalculated}")
        var levelCalculated: Double = player.maxTierLevel.toDouble()
        // if (!player.maxTierName.isLevelPoint) {
        levelCalculated = 5 - levelCalculated
        // }
        levelCalculated *= player.maxTierName.levelRatio
        // println("calculateTierPoint:levelCalculated:${levelCalculated}")
        val tierPoint = tierCalculated + levelCalculated
        return tierPoint.roundToInt()
    }

    private fun partitionByNearlyEqualSums() {
        val teamA: ArrayList<Player> = ArrayList()
        val teamB: ArrayList<Player> = ArrayList()

        // NOTE: 내림차 순으로 정렬한다.
        players = ArrayList(players.sortedWith(compareBy({ it.maxTierPoint }, { Random.nextBoolean() })))

        var indexA = 0
        var indexB = 0

        // NOTE: players의 가장 마지막 Index부터 시작한다.
        var playersIndex = players.size - 1

        var sumA = 0
        var sumB = 0

        while (indexA < TEAM_SIZE && indexB < TEAM_SIZE) {
            if (sumA < sumB) {
                // teamA[indexA] = players[playersIndex]
                teamA.add(indexA, players[playersIndex])
                indexA++
                sumA += players[playersIndex].maxTierPoint
            } else {
                // teamB[indexB] = players[playersIndex]
                teamB.add(indexB, players[playersIndex])
                indexB++
                sumB += players[playersIndex].maxTierPoint
            }
            playersIndex--
        }

        // NOTE: 이미 한쪽 팀의 구성이 완료된 상태일 경우 무조건 반대 팀의 정원으로 채운다.
        while (playersIndex >= 0) {
            if (indexA < TEAM_SIZE) {
                teamA.add(indexA++, players[playersIndex])
            } else {
                teamB.add(indexB++, players[playersIndex])
            }
            playersIndex--
        }

        if (Random.nextBoolean()) {
            this.teamA = teamA
            this.teamB = teamB
        } else {
            this.teamA = teamB
            this.teamB = teamA
        }
    }
}