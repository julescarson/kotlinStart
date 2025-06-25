import java.io.File
import kotlin.math.abs

fun day2part1() : Int {
    // safe levels : ASC or DESC on line
    // AND adjacent values within 1 to 3 (incl)

    val fileName = "inputText/day2.txt"
    var safeLevels : Int = 0

    File(fileName).forEachLine { line ->

        //int arr from line string
        val curr = line
            .split(" ")
            .map { it.toInt() }

        val ascending : Boolean = (curr[0] < curr[1])
        for (i in 0 until curr.lastIndex) {

            //adj level difference
            val diff = abs(curr[i] - curr[i+1])

            // unsafe conditions
            if (ascending && curr[i] > curr[i+1]) break
            else if (!ascending && curr[i] < curr[i+1]) break
            else if (diff < 1 || diff > 3) break

            //made it to the end of the line (is safe)
            if (i+1 == curr.lastIndex) safeLevels++
        }
    }
    return safeLevels
}

