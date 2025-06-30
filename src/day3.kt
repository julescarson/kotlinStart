import java.io.File


fun day3part1() : Int {
    val fileName = "inputText/day3.txt"
    val file = File(fileName).readText()
    var sum = 0


    // requirements: X and Y are each 1-3 digit
    // regex pattern already avoids whitespace
    val pattern = "mul\\(([0-9]{1,3},[0-9]{1,3})\\)"
        .toRegex()

    pattern.findAll(file)
        .map { it.groupValues[1] }
        .forEach { pair ->
            val nums = pair.split(",")
            sum += nums[0].toInt() * nums[1].toInt()
        }

    return sum
}


fun day3part2() : Int {
    return -1
}