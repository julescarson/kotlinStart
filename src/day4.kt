import java.io.File

fun day4part1(inputText: String? = null): Int {
    val fileName = "inputText/day4.txt"
    val file = inputText ?: File(fileName).readText()
    val grid = file.lines().filter { it.isNotEmpty() }

    val cols = grid[0].length
    val rows = grid.size
    var totalCount = 0

    // check characters only at valid positions
    fun getCharAt(row: Int, col: Int): Char? {
        return if (row in 0 until rows && col in 0 until cols) {
            grid[row].getOrNull(col)
        } else null
    }

    //  check for "XMAS" or "SAMX"
    fun checkWord(startRow: Int, startCol: Int, rowStep: Int, colStep: Int): Boolean {
        // Get all 4 characters in the specified direction
        val chars = List(4) { i ->
            getCharAt(
                startRow + (i * rowStep),
                startCol + (i * colStep)
            )
        }

        // If any character is null (outside grid), return false
        if (chars.contains(null)) return false

        // Create word from characters and check if it matches
        val word = chars.joinToString("")
        return word == "XMAS" || word == "SAMX"
    }


    for (row in 0 until rows) {
        for (col in 0 until cols) {
            // Check horizontal (→)
            if (checkWord(row, col, rowStep = 0, colStep = 1)) {
                totalCount++
            }

            // Check vertical (↓)
            if (checkWord(row, col, rowStep = 1, colStep = 0)) {
                totalCount++
            }

            // Check diagonal down-right (↘)
            if (checkWord(row, col, rowStep = 1, colStep = 1)) {
                totalCount++
            }

            // Check diagonal up-right (↗)
            if (checkWord(row, col, rowStep = -1, colStep = 1)) {
                totalCount++
            }
        }
    }

    return totalCount
}