package string_integer

import kotlin.math.abs

class AngleBetweenHandsofaClockKotlin1344 {
    fun angleClock(hour: Int, minutes: Int): Double {
        val baseHour = when (hour) {
            12 -> 0
            else -> 30 * hour
        }
        val hourVal = minutes.toDouble() / 2 + baseHour

        val minutesVal = minutes.toDouble() * 6

        val result = abs(hourVal - minutesVal)

        return if (result > 180) 360 - result else result
    }
}

fun main() {
    val solution = AngleBetweenHandsofaClockKotlin1344()
    // 165
    println(solution.angleClock(12, 30))
    // 75
    println(solution.angleClock(3, 30))
    // 7.5
    println(solution.angleClock(3, 15))
    // 155
    println(solution.angleClock(4, 50))
    // 0
    println(solution.angleClock(12, 0))
    // 76.5
    println(solution.angleClock(1, 57))
}