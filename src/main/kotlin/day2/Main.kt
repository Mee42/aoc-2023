package sh.carson.day2_2023

import sh.carson.*

fun main() {
    var input = inputLines(day = 2, year = 2023).map { line ->
        val (lhe, rhe) = line.split(":")

        val game_id = lhe.ints()[0]
        val rounds = rhe.split(";").map { round ->
            round.split(",").map { a ->
                val (number, color) = a.trim().split(" ").map { it.trim() }
                number.toInt() to color
            }
        }
        var red = 0
        var blue = 0
        var green = 0

        var valid = true
        for(round in rounds) {
            for((number, color) in round) {
                when(color) {
                    "red" -> {
                        if(number > red) red = number
                    }
                    "blue" -> {
                        if(number > blue) blue = number
                    }
                    "green" -> {
                        if(number > green) green = number
                    }
                    else -> TODO()
                }

            }
        }
        red * blue * green
    }.sum()
    println(input)



    var answer = input
    println(answer)
}