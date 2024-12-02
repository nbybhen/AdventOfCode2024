package Day01
import getTwoColumns
import java.io.File
import kotlin.math.abs

fun part1(input: List<String>): Int {
    val columns = getTwoColumns(input).also {
        it.first.sort()
        it.second.sort()
    }

    return run {
        columns.first.zip(columns.second).fold(0) {acc, (f, s) -> acc + abs(f - s)}
    }
}

fun part2(input: List<String>): Int {
    return getTwoColumns(input).let {
        val occ = it.second.groupingBy{inner -> inner}.eachCount()
        it.first.fold(0) {acc, ele -> acc + ele * occ.getOrDefault(ele, 0)}
    }
}

fun main() {
    val input = File("src/Day01/input.txt").inputStream().bufferedReader().readLines()
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}