package Day05
import java.io.File

fun part1(input: List<String>): Int {
    val rules  = input.filter{it.contains('|')}
    val order = input.filter {it.contains(',')}
    println("Rules: $rules")
    println("Order: $order")
    return 0
}

fun part2(input: List<String>): Int {

    return 0
}

fun main() {
    println("===== Day 05 ====")
    val input = File("src/Day05/input.txt").inputStream().bufferedReader().readLines()
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}