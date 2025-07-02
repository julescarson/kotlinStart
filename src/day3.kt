import java.io.File



fun day3part1(text : String? = null) : Int {
    val fileName = "inputText/day3.txt"
    //we can pass a string if we want to test diff input
    val file = text ?: File(fileName).readText()
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


//kinda hard and fast solution, can be optimized probably for efficiency with less passes and data structures used
fun day3part2() : Int {
    val fileName = "inputText/day3.txt"
    val file = File(fileName).readText()

    //find all do and dont positions
    val doPositions = "do\\(\\)".toRegex()
        .findAll(file)
        .map { it.range.first }
        .toMutableList()
        .apply {add(0,0)}

    val dontPositions = "don't\\(\\)".toRegex()
        .findAll(file)
        .map { it.range.first }
        .toList()

    //valid start at index 0, find pairs (alternating)
    val idxOrder = mutableListOf(0)
    var validSubstring = true

    //pointers for testing valid indices
    var currDo = 1
    var currDont = 0
    var currIdx = 0

    while (currDo < doPositions.size && currDont < dontPositions.size) {
       //currIdx is a doPosition, find next dont
        if (validSubstring) {
           if (dontPositions[currDont] > idxOrder[currIdx]) {
                idxOrder.add(dontPositions[currDont])
                currDont++
                currIdx++
                validSubstring = false
            } else {
                currDont++
                continue
            }
        //currIdx is a dontPosition, find next do
        } else if (!validSubstring) {
            if (doPositions[currDo] > idxOrder[currIdx]) {
                idxOrder.add(doPositions[currDo])
                currDo++
                currIdx++
                validSubstring = true
            } else {
                currDo++
                continue
            }
        }
    }

    // use idxOrder to pass substrings from file to day3part1 summing function w/ regex pattern foreach
    var sum = 0
    for (i in 0 until idxOrder.size-1 step 2) {
        println("${idxOrder[i]}, ${idxOrder[i+1]}")
        sum += day3part1(file.substring(idxOrder[i], idxOrder[i+1]))
    }

    return sum
}

