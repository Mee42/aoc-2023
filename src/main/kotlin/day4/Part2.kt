package sh.carson.day4


import sh.carson.*

fun main() {

    val cards = inputLines(day = 4, year = 2023).map { line ->
        val (_, winning, a) = line
            .split(Regex("""[:|]"""))
            .map { it.ints().toSet() }
        a.intersect(winning).size
    }

    val numberOfWins = List(cards.size) { 1 }.toMutableList()
    val score = numberOfWins.indices.sumOf { n ->
        for (i in 1..cards[n]) {
            numberOfWins[n + i] += numberOfWins[n]
        }
        numberOfWins[n]
    }
    println("part2: $score")
}