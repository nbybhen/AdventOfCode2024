package Day04

import paddedWith
import java.io.File

fun part1(input: List<String>) {
    println(input.paddedWith(".", 4).joinToString("\n"))
}

fun main() {
    val input = File("src/Day04/input.txt").inputStream().bufferedReader().readLines()
    println("Part 1: ${part1(input)}")
}