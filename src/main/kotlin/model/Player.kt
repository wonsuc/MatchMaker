package model

import constants.Lane
import constants.Tier

data class Player(
    val userId: String = "",
    val maxTierName: Tier = Tier.UNRANKED,
    val maxTierLevel: Int = 0,
    var availableLanes: List<Lane>,
    var mainLane: Lane? = null
) {
    val maxTier: String = "${maxTierName.displayText} $maxTierLevel"
    val lanes: String = availableLanes.sorted().map { lane -> lane.displayText }.joinToString(",")
    var maxTierPoint: Int = 0

    // constructor(userId: String, maxTierName: Tier) : this(userId, Tier.UNRANKED, 0, emptyArray(), null)
}