package Day03

import java.io.File

fun part1(input: List<String>): Int {
    val exprs: List<Sequence<MatchResult>> = input.map { Regex("mul\\(\\d+,\\d+\\)").findAll(it) }
    val result = mutableListOf<Int>()
    exprs.also { expr ->
         expr.map {
             result.add(it.map{ matchResult -> matchResult.value.substring(4, matchResult.value.length-1).split(',').map(String::toInt).fold(1) {acc, mul -> acc*mul}}.sum())
        }
    }
    return result.sum()
}

fun part2(input: List<String>): Int {

}

fun main() {
    val input = File("src/Day03/input.txt").inputStream().bufferedReader().readLines()
    println("Part 1: ${part1(input)}")
}