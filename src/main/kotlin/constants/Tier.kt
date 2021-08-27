package constants

enum class Tier(
    val displayText: String,
    val code: Int,
    val tierRatio: Double,
    val levelRatio: Double,
    val isLevelPoint: Boolean
) {
    // @formatter:off
    UNRANKED(     displayText = "언랭",     code = 0,  tierRatio = 0.0,  levelRatio = 0.0,  isLevelPoint = false),
    IRON(         displayText = "아이언",         code = 1,  tierRatio = 10.0, levelRatio = 1.0,  isLevelPoint = false),
    BRONZE(       displayText = "브론즈",       code = 2,  tierRatio = 10.0, levelRatio = 1.33,  isLevelPoint = false),
    SILVER(       displayText = "실버",       code = 3,  tierRatio = 10.0, levelRatio = 1.66,  isLevelPoint = false),
    GOLD(         displayText = "골드",         code = 4,  tierRatio = 10.0, levelRatio = 2.0,  isLevelPoint = false),
    PLATINUM(     displayText = "플래티넘",     code = 5,  tierRatio = 10.0, levelRatio = 2.5,  isLevelPoint = false),
    EMERALD(      displayText = "에메랄드",      code = 6,  tierRatio = 10.0, levelRatio = 3.0,  isLevelPoint = false),
    DIAMOND(      displayText = "다이아몬드",      code = 7,  tierRatio = 10.0, levelRatio = 4.0, isLevelPoint = true),
    MASTER(       displayText = "마스터",       code = 8,  tierRatio = 10.0, levelRatio = 6.0, isLevelPoint = true),
    GRAND_MASTER( displayText = "그랜드 마스터", code = 9,  tierRatio = 10.0, levelRatio = 9.0, isLevelPoint = true),
    CHALLENGER(   displayText = "챌린저",   code = 10, tierRatio = 10.0, levelRatio = 12.0, isLevelPoint = true)
    // @formatter:on
}