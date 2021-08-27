import constants.Lane
import constants.Tier
import model.Player

fun main(args: Array<String>) {
    val player1 = Player("1일8똥#9857", Tier.DIAMOND, 4, mutableListOf(Lane.JUNGLE))
    val player2 = Player("안녕하세요#7178", Tier.EMERALD, 4, mutableListOf(Lane.SUPPORT, Lane.TOP))
    val player3 = Player("Ez 귀여운블란이#0000", Tier.DIAMOND, 2, mutableListOf(Lane.JUNGLE))
    val player4 = Player("탑에서 혜지챔쓰는 김정은#6666", Tier.PLATINUM, 3, mutableListOf(Lane.TOP, Lane.MID, Lane.ADC, Lane.SUPPORT, Lane.JUNGLE))
    val player5 = Player("TWILIGHT7#KR1", Tier.PLATINUM, 4, mutableListOf(Lane.MID, Lane.JUNGLE))
    val player6 = Player("윈스터언#KR1", Tier.DIAMOND, 3, mutableListOf(Lane.MID, Lane.ADC))
    val player7 = Player("Hide on bus#8616", Tier.PLATINUM, 3, mutableListOf(Lane.MID, Lane.SUPPORT))
    val player8 = Player("잼민이랑말안섞음#1988", Tier.EMERALD, 3, mutableListOf(Lane.TOP, Lane.ADC, Lane.SUPPORT))
    val player9 = Player("펭sure#KR1", Tier.DIAMOND, 4, mutableListOf(Lane.TOP, Lane.MID))
    val player10 = Player("탑신병자김신건#KR1", Tier.PLATINUM, 2, mutableListOf(Lane.TOP, Lane.SUPPORT))

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
        
        [참가멤버]
        1. ID: ${player1.userId} / 최대티어: ${player1.maxTier} / 라인: ${player1.lanes} (점수: ${player1.maxTierPoint})
        2. ID: ${player2.userId} / 최대티어: ${player2.maxTier} / 라인: ${player2.lanes} (점수: ${player2.maxTierPoint})
        3. ID: ${player3.userId} / 최대티어: ${player3.maxTier} / 라인: ${player3.lanes} (점수: ${player3.maxTierPoint})
        4. ID: ${player4.userId} / 최대티어: ${player4.maxTier} / 라인: ${player4.lanes} (점수: ${player4.maxTierPoint})
        5. ID: ${player5.userId} / 최대티어: ${player5.maxTier} / 라인: ${player5.lanes} (점수: ${player5.maxTierPoint})
        6. ID: ${player6.userId} / 최대티어: ${player6.maxTier} / 라인: ${player6.lanes} (점수: ${player6.maxTierPoint})
        7. ID: ${player7.userId} / 최대티어: ${player7.maxTier} / 라인: ${player7.lanes} (점수: ${player7.maxTierPoint})
        8. ID: ${player8.userId} / 최대티어: ${player8.maxTier} / 라인: ${player8.lanes} (점수: ${player8.maxTierPoint})
        9. ID: ${player9.userId} / 최대티어: ${player9.maxTier} / 라인: ${player9.lanes} (점수: ${player9.maxTierPoint})
        10. ID: ${player10.userId} / 최대티어: ${player10.maxTier} / 라인: ${player10.lanes} (점수: ${player10.maxTierPoint})
        
        [A팀]
        ID: ${matchMaker.teamA[0].userId} / 최대티어: ${matchMaker.teamA[0].maxTier} / 라인: ${matchMaker.teamA[0].lanes} (점수: ${matchMaker.teamA[0].maxTierPoint})
        ID: ${matchMaker.teamA[1].userId} / 최대티어: ${matchMaker.teamA[1].maxTier} / 라인: ${matchMaker.teamA[1].lanes} (점수: ${matchMaker.teamA[1].maxTierPoint})
        ID: ${matchMaker.teamA[2].userId} / 최대티어: ${matchMaker.teamA[2].maxTier} / 라인: ${matchMaker.teamA[2].lanes} (점수: ${matchMaker.teamA[2].maxTierPoint})
        ID: ${matchMaker.teamA[3].userId} / 최대티어: ${matchMaker.teamA[3].maxTier} / 라인: ${matchMaker.teamA[3].lanes} (점수: ${matchMaker.teamA[3].maxTierPoint})
        ID: ${matchMaker.teamA[4].userId} / 최대티어: ${matchMaker.teamA[4].maxTier} / 라인: ${matchMaker.teamA[4].lanes} (점수: ${matchMaker.teamA[4].maxTierPoint})
        총점: $teamAsum
        
        [B팀]
        ID: ${matchMaker.teamB[0].userId} / 최대티어: ${matchMaker.teamB[0].maxTier} / 라인: ${matchMaker.teamB[0].lanes} (점수: ${matchMaker.teamB[0].maxTierPoint})
        ID: ${matchMaker.teamB[1].userId} / 최대티어: ${matchMaker.teamB[1].maxTier} / 라인: ${matchMaker.teamB[1].lanes} (점수: ${matchMaker.teamB[1].maxTierPoint})
        ID: ${matchMaker.teamB[2].userId} / 최대티어: ${matchMaker.teamB[2].maxTier} / 라인: ${matchMaker.teamB[2].lanes} (점수: ${matchMaker.teamB[2].maxTierPoint})
        ID: ${matchMaker.teamB[3].userId} / 최대티어: ${matchMaker.teamB[3].maxTier} / 라인: ${matchMaker.teamB[3].lanes} (점수: ${matchMaker.teamB[3].maxTierPoint})
        ID: ${matchMaker.teamB[4].userId} / 최대티어: ${matchMaker.teamB[4].maxTier} / 라인: ${matchMaker.teamB[4].lanes} (점수: ${matchMaker.teamB[4].maxTierPoint})
        총점: $teamBsum
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