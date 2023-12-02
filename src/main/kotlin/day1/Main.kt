package sh.carson.day1_2023

import sh.carson.*


fun main() {
    val input = inputLines(day = 1, year = 2023)
    val f = "one.two.three.four.five.six.seven.eight.nine".split(".").mapIndexed { i, e -> e to "${i + 1}" }.toMap()
    val part1 =
        input.map { it.filter { c -> c in "0123456789" } }.sumOf { (it.first().toString() + it.last().toString()).toInt() }
    val part2 = input.map { line ->
        val first = Regex("""\d|one|two|three|four|five|six|seven|eight|nine""").find(line)!!.value
        val second =
            Regex("""\d|eno|owt|eerht|ruof|evif|xis|neves|thgie|enin""").find(line.reversed())!!.value.reversed()
        f[first]!! + f[second]!!
    }.sumOf { it.toInt() }
    println("Part 1: $part1   Part 2: $part2")
}