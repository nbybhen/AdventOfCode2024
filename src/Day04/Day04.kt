package Day04

import paddedWith
import java.io.File

fun part1(input: List<String>): Int {
    val inp = input.paddedWith(".", 4)
    var count = 0
    inp.forEachIndexed { index, row ->
        row.forEachIndexed { j, column ->
            if (column == 'X') {
                // W
                if (row.substring(j-3, j+1) == "SAMX") {
                    count++
                }
                // E
                if (row.substring(j, j+4) == "XMAS") {
                    count++
                }
                // N
                val n = StringBuilder().append(inp[index][j]).append(inp[index-1][j]).append(inp[index-2][j]).append(inp[index-3][j])
                if (n.toString() == "XMAS") {
                    count++
                }
                // S
                val s = StringBuilder().append(inp[index][j]).append(inp[index+1][j]).append(inp[index+2][j]).append(inp[index+3][j])
                if (s.toString() == "XMAS") {
                    count++
                }
                // NE
                val ne = StringBuilder().append(inp[index][j]).append(inp[index-1][j+1]).append(inp[index-2][j+2]).append(inp[index-3][j+3])
                if (ne.toString() == "XMAS") {
                    count++
                }
                // NW
                val nw = StringBuilder().append(inp[index][j]).append(inp[index-1][j-1]).append(inp[index-2][j-2]).append(inp[index-3][j-3])
                if (nw.toString() == "XMAS") {
                    count++
                }
                // SE
                val se = StringBuilder().append(inp[index][j]).append(inp[index+1][j+1]).append(inp[index+2][j+2]).append(inp[index+3][j+3])
                if (se.toString() == "XMAS") {
                    count++
                }
                // SW
                val sw = StringBuilder().append(inp[index][j]).append(inp[index+1][j-1]).append(inp[index+2][j-2]).append(inp[index+3][j-3])
                if (sw.toString() == "XMAS") {
                    count++
                }
            }
        }
    }
    return count
}

fun part2(input: List<String>): Int {
    var count = 0
    val inp = input.paddedWith(".", 3)
    inp.forEachIndexed { index, row ->
        row.forEachIndexed { j, column ->
            if (column == 'M' || column == 'S') {
                // SE
                val se = StringBuilder().append(inp[index][j]).append(inp[index+1][j+1]).append(inp[index+2][j+2])
                // NE
                val ne = StringBuilder().append(inp[index+2][j]).append(inp[index+1][j+1]).append(inp[index][j+2])
                if ((se.toString() == "MAS" || se.toString() == "SAM") && (ne.toString() == "MAS" || ne.toString() == "SAM")) {
                    count++
                }
            }
        }
    }
    return count
}

fun main() {
    println("===== Day 04 =====")
    val input = File("src/Day04/input.txt").inputStream().bufferedReader().readLines()
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}