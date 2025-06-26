import java.io.File
import kotlin.math.abs

fun day2part1() : Pair<Int, List<List<Int>>> {
    // safe levels : ASC or DESC on line
    // AND adjacent values within 1 to 3 (incl)

    val fileName = "inputText/day2.txt"
    var safeLevels = 0
    val badLevels = mutableListOf(listOf<Int>())

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
            if (ascending && curr[i] > curr[i+1]) {
                badLevels.add(curr)
                break
            }
            else if (!ascending && curr[i] < curr[i+1]) {
                badLevels.add(curr)
                break
            }
            else if (diff < 1 || diff > 3) {
                badLevels.add(curr)
                break
            }

            //made it to the end of the line (is safe)
            if (i+1 == curr.lastIndex) safeLevels++
        }
    }

    badLevels.removeAt(0) //first list element empty on init
    return Pair(safeLevels, badLevels)
}

fun day2part2() : Int {

    // cheese strat: use day 2 part 1, return array of unsafe lines AND safeLevels
    // use unsafe lines array as test in day2, sum with known safeLevels

    val part1 = day2part1()
    var safeLevels : Int = part1.first
    val badLevels = part1.second

    val outputDebug = File("d2p2debug.txt")
    outputDebug.writeText("Day 2 - Part 2 Debug file, check badLevels for each assumed line")


    //check each level for allowable cases
    for (level in badLevels) {
        outputDebug.appendText("\n$level , ")
        var badCounter = 0
        var ascending : Boolean = level[0] < level[1]


        for (i in 0 until level.lastIndex) {
            val difference = abs(level[i] - level[i+1])
            //changes direction
            if (ascending && level[i] > level[i+1]) {
                badCounter++
                //update direction!
                ascending = false

            } else if (!ascending && level[i] < level[i+1]) {
                badCounter++
                ascending = true

            } else if (difference < 1 || difference > 3) {
                badCounter++

            }

            if (i+1 == level.lastIndex && badCounter <= 1) {
                safeLevels++
            }

        }
        outputDebug.appendText("badCounter: $badCounter")
    }

    return safeLevels

}



