package model

import constants.Tier

data class Player(
    val userId: String = "",
    val maxTierName: Tier = Tier.UNRANKED,
    val maxTierLevel: Int = 0,
    val maxTier: String = "${maxTierName.displayText} $maxTierLevel",
    var maxTierPoint: Int = 0
)