// Common Functions

// Returns a Pair of MutableLists .first = 1st column and .second = 2nd column
fun getTwoColumns(input: List<String>): Pair<MutableList<Int>, MutableList<Int>> {
    val left = mutableListOf<Int>()
    val right = mutableListOf<Int>()

    input.forEach {
        val split = it.split(" ").filter { i -> i.isNotBlank() }.map { i -> i.toInt() }
        left.add(split.first())
        right.add(split.last())
    }

    return left to right
}

fun getIntColumns(input: List<String>): List<MutableList<Int>> {
    return input.map { it.split(" ").filter { i -> i.isNotBlank() }.map { i -> i.toInt() }.toMutableList() }
}