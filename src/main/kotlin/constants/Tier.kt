package constants

enum class Tier(val displayText: String,
                val code: Int,
                val tierRatio: Double,
                val levelRatio: Double,
                val isLevelPoint: Boolean) {
    UNRANKED("Unranked", 0, 0.0, 0.0, false),
    IRON("Iron", 1, 10.0, 1.0, false),
    BRONZE("Bronze", 2, 10.0, 1.1, false),
    SILVER("Silver", 3, 10.0, 1.2, false),
    GOLD("Gold", 4, 10.0, 1.3, false),
    PLATINUM("Platinum", 5, 10.0, 1.4, false),
    EMERALD("Emerald", 6, 10.0, 1.5, false),
    DIAMOND("Diamond", 7, 10.0, 0.01, true),
    MASTER("Master", 8, 10.0, 0.02, true),
    GRAND_MASTER("Grand master", 9, 10.0, 0.03, true),
    CHALLENGER("Challenger", 10, 10.0, 0.04, true)
}