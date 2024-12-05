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

// Converts all values per row from input into list of Ints
fun getIntColumns(input: List<String>): List<MutableList<Int>> {
    return input.map { it.split(" ").filter { i -> i.isNotBlank() }.map { i -> i.toInt() }.toMutableList() }
}

// Pads input with inputted value
fun List<String>.paddedWith(delim: String, depth: Int, contentLen: Int = this[0].length): List<String> {
    return buildList {
        repeat(depth) {
            add(delim.repeat(contentLen))
        }

        for (string in this@paddedWith) {
            add( delim.repeat(depth) + string + delim.repeat(depth))
        }

        repeat(depth) {
            add(delim.repeat(contentLen))
        }
    }
}