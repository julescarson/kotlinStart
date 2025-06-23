import java.io.File
import kotlin.math.abs

//parts
fun day1part1() : Int {
    val input = leftRight("inputText/day1part1.txt")
    val left = input[0].sorted()
    val right = input[1].sorted()

    var diff = 0
    for (i in 0 until right.size) {
        diff += abs(left[i] - right[i])
    }
    //answer
    return diff
}

fun day1part2() : Int {
    val input = leftRight("inputText/day1part1.txt")
    val left = input[0]
    val right = input[1]
    var similarity = 0

    //map for left and right, count instances for each int
    val lmap = left.groupingBy { it }.eachCount()
    val rmap = right.groupingBy { it }.eachCount()

    //loop keys, multiply leftKey * byRightInstance * byLeftInstance
    for ((key,value) in lmap) {
        if (rmap.containsKey(key)) {
            similarity += (key) * rmap.getValue(key) * value
        }
    }
    return similarity
}

fun day2part1() : Int {
    return -1
}

//helpers
fun leftRight(fileName: String): List<MutableList<Int>> {
    val left = mutableListOf<Int>()
    val right = mutableListOf<Int>()
    File(fileName).forEachLine { line ->
        val curr = line.split(" ")
        left.add(curr[0].toInt())
        right.add(curr[curr.lastIndex].toInt())
    }
    return listOf(left, right)
}

