package sh.carson.day3

import sh.carson.*

fun main() {
    val input = inputLines(day = 3, year = 2023)
    var part2 = 0
    val map = mutableMapOf<Coords2D, Int>()
    for((index, line) in input.withIndex()) {
        number@ for (position in Regex("""\d+""").findAll(line)) {
            val number = position.value.toInt()
            for (n in position.range) {
                val pos = p(index, n)
                for (variation in CARDINAL_OFFSETS_INCL_DIAGONALS) {
                    val checking = pos + variation
                    val c = input.getOrNull(checking.x)?.getOrNull(checking.y)
                    if (c == '*') {
                        val e = map[checking]
                        if(e != null) {
                            part2 += e * number
                        } else {
                            map[checking] = number
                        }
                        continue@number
                    }
                }
            }
        }
    }
    println(part2)
}
