package Day01
import java.io.File
import kotlin.math.abs

fun Part1(input: List<String>): Int {
    val left = mutableListOf<Int>()
    val right = mutableListOf<Int>()
    val result = mutableListOf<Int>()

    input.forEach {
        val split = it.split(" ").filter { i -> i.isNotBlank() }.map { i -> i.toInt() }
        left.add(split.first())
        right.add(split.last())
    }
    left.sort()
    right.sort()

    for (i in 0..<left.size) {
        result.add(abs(left[i] - right[i]))
    }

    return result.sum()
}

fun Part2(input: List<String>): Int {
    val left = mutableListOf<Int>()
    val right = mutableMapOf<Int, Int>()
    val result = mutableListOf<Int>()

    input.forEach {
        val split = it.split(" ").filter { i -> i.isNotBlank() }.map { i -> i.toInt() }
        left.add(split.first())
        right[split.last()] = right.getOrDefault(split.last(), 0) + 1
    }

    left.forEach {
        result.add(it * right.getOrDefault(it, 0))
    }
    return result.sum()
}

fun main() {
    val input = File("src/Day01/input.txt").inputStream().bufferedReader().readLines()
    println("Part 1: ${Part1(input)}")
    println("Part 2: ${Part2(input)}")
}