import constants.Tier
import model.Player

fun main(args: Array<String>) {
    val player1 = Player("user1", Tier.IRON, 4)
    val player2 = Player("user2", Tier.IRON, 3)
    val player3 = Player("user3", Tier.EMERALD, 1)
    val player4 = Player("user4", Tier.GRAND_MASTER, 126)
    val player5 = Player("user5", Tier.GOLD, 3)
    val player6 = Player("user6", Tier.DIAMOND, 50)
    val player7 = Player("user7", Tier.PLATINUM, 1)
    val player8 = Player("user8", Tier.PLATINUM, 4)
    val player9 = Player("user9", Tier.DIAMOND, 120)
    val player10 = Player("user10", Tier.EMERALD, 3)

    val matchMaker = MatchMaker()
    matchMaker.add(player1)
    matchMaker.add(player2)
    matchMaker.add(player3)
    matchMaker.add(player4)
    matchMaker.add(player5)
    matchMaker.add(player6)
    matchMaker.add(player7)
    matchMaker.add(player8)
    matchMaker.add(player9)
    matchMaker.add(player10)

    matchMaker.commit()

    var teamAsum = matchMaker.teamA.sumOf { it.maxTierPoint }
    var teamBsum = matchMaker.teamB.sumOf { it.maxTierPoint }

    val matchedResult = """
        
        [Team A]
        User ID: ${matchMaker.teamA[0].userId}  Max Tier: ${matchMaker.teamA[0].maxTier}  Score: ${matchMaker.teamA[0].maxTierPoint}
        User ID: ${matchMaker.teamA[1].userId}  Max Tier: ${matchMaker.teamA[1].maxTier}  Score: ${matchMaker.teamA[1].maxTierPoint}
        User ID: ${matchMaker.teamA[2].userId}  Max Tier: ${matchMaker.teamA[2].maxTier}  Score: ${matchMaker.teamA[2].maxTierPoint}
        User ID: ${matchMaker.teamA[3].userId}  Max Tier: ${matchMaker.teamA[3].maxTier}  Score: ${matchMaker.teamA[3].maxTierPoint}
        User ID: ${matchMaker.teamA[4].userId}  Max Tier: ${matchMaker.teamA[4].maxTier}  Score: ${matchMaker.teamA[4].maxTierPoint}
        Total Score: $teamAsum
        
        [Team B]
        User ID: ${matchMaker.teamB[0].userId}  Max Tier: ${matchMaker.teamB[0].maxTier}  Score: ${matchMaker.teamB[0].maxTierPoint}
        User ID: ${matchMaker.teamB[1].userId}  Max Tier: ${matchMaker.teamB[1].maxTier}  Score: ${matchMaker.teamB[1].maxTierPoint}
        User ID: ${matchMaker.teamB[2].userId}  Max Tier: ${matchMaker.teamB[2].maxTier}  Score: ${matchMaker.teamB[2].maxTierPoint}
        User ID: ${matchMaker.teamB[3].userId}  Max Tier: ${matchMaker.teamB[3].maxTier}  Score: ${matchMaker.teamB[3].maxTierPoint}
        User ID: ${matchMaker.teamB[4].userId}  Max Tier: ${matchMaker.teamB[4].maxTier}  Score: ${matchMaker.teamB[4].maxTierPoint}
        Total Score: $teamBsum
    """.trimIndent()

    println(matchedResult)



//    println(player1)
//    println(player2)

//    val p1TierPoint = matchMaker.calculateTierPoint(player1)
//    println(p1TierPoint)
//    val p2TierPoint = matchMaker.calculateTierPoint(player2)
//    println(p2TierPoint)
//    val p3TierPoint = matchMaker.calculateTierPoint(player3)
//    println(p3TierPoint)
//    val p4TierPoint = matchMaker.calculateTierPoint(player4)
//    println(p4TierPoint)
//    val p5TierPoint = matchMaker.calculateTierPoint(player5)
//    println(p5TierPoint)
//    val p6TierPoint = matchMaker.calculateTierPoint(player6)
//    println(p6TierPoint)
//    val p7TierPoint = matchMaker.calculateTierPoint(player7)
//    println(p7TierPoint)
//    val p8TierPoint = matchMaker.calculateTierPoint(player8)
//    println(p8TierPoint)
//    val p9TierPoint = matchMaker.calculateTierPoint(player9)
//    println(p9TierPoint)
//    val p10TierPoint = matchMaker.calculateTierPoint(player10)
//    println(p10TierPoint)
}