package Day03

import java.io.File

fun part1(input: List<String>): Int {
    val exprs = input.map { Regex("mul\\(\\d+,\\d+\\)").findAll(it) }
    return exprs.sumOf {
        it.sumOf { matchResult ->
            with(matchResult) {
                value.substring(4, value.length - 1).split(',').fold(1 as Int) { acc, x -> acc * x.toInt() }
            }
        }
    }
}

fun part2(input: List<String>): Int {
    val exprs = input.map {Regex("mul\\(\\d+,\\d+\\)|do(n't)*\\(\\)").findAll(it) }
    var can = true
    return exprs.sumOf {
        it.sumOf { matchResult ->
            with(matchResult) {
                when  {
                    matchResult.value.startsWith("don't") -> can = false
                    matchResult.value.startsWith("do") -> can = true
                    else -> {}
                }
                if (can && !matchResult.value.startsWith("do")) {
                    value.substring(4, value.length - 1).split(',').fold(1 as Int) { acc, x -> acc * x.toInt() }
                } else {
                    0
                }
            }
        }
    }
}

fun main() {
    val input = File("src/Day03/input.txt").inputStream().bufferedReader().readLines()
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}