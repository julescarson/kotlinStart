import java.io.File
import kotlin.math.abs


fun main() {

    var left = mutableListOf<Int>()
    var right = mutableListOf<Int>()

    val fileContents = File("src/day1part1.txt").forEachLine { line ->
        var curr = line.split(" ")
        left.add(curr[0].toInt())
        right.add(curr[curr.lastIndex].toInt())
    }

    val leftSorted = left.sorted()
    val rightSorted = right.sorted()

    var sum = 0

    for (i in 0 until right.size) {
        sum += abs(leftSorted[i] - rightSorted[i])
    }

    //answer
    println(sum)

}



