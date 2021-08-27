package constants

enum class Lane(
    val displayText: String,
    val code: String
) {
    // @formatter:off
    TOP(     displayText = "탑",     code = "T"),
    MID(     displayText = "미드",   code = "M"),
    ADC(     displayText = "원딜",   code = "A"),
    SUPPORT( displayText = "서포터", code = "S"),
    JUNGLE(  displayText = "정글",   code = "J"),
    // @formatter:on
}