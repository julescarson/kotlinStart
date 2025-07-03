import java.io.File

fun rotateFile(text: String) : String {
    val lines = text.lines()
    val rotated = StringBuilder()
    for (col in 0 until lines[0].length) {
        for (row in lines.indices) {
            rotated.append(lines[row][col])
        }
        rotated.append("\n")
    }
    return rotated.toString()
}

fun day4part1(inputText : String? = null ) : Int {
    val fileName = "inputText/day4test.txt"
    val file = inputText ?: File(fileName).readText()

    println("\n\nOriginal: \n$file")
    println("\n\nRotated: \n${rotateFile(file)}")


    //horizontal
    val forward = "XMAS".toRegex()
    val backward = "SAMX".toRegex()
    val hCount = forward.findAll(file).count() + backward.findAll(file).count()

    //vertical - rotate day4text and repeat above, or on the fly?
    val vCount = forward.findAll(rotateFile(file)).count() + backward.findAll(rotateFile(file)).count()


    //diagonal

    return hCount + vCount
}

fun day4part2() : Int {
    return -1
}