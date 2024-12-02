package Day02

import getIntColumns
import java.io.File
import kotlin.math.abs

fun MutableList<Int>.isSafe(): Boolean {
    return ((this == this.sortedDescending() || this == this.sorted()) && this.zipWithNext().all{ (a, b) -> a != b && abs(a-b) in 1..3 })
}

fun part1(input: List<String>): Int {
    return getIntColumns(input).filter { it.isSafe() }.size
}

fun part2(input: List<String>): Int {
    val cols = getIntColumns(input)
    var total = 0
    cols.forEach {
        if (it.isSafe())  {
            total++
        } else {
            for (i in it.indices) {
                val tmp = it.toMutableList().apply { removeAt(i) }
                if (tmp.isSafe()) {
                    total++
                    break
                }

            }
        }
    }
    return total
}

fun main() {
    val input = File("src/Day02/input.txt").inputStream().bufferedReader().readLines()
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}