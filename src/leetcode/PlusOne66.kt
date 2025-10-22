package leetcode

fun plusOne(digits : IntArray) : IntArray {

    //the last value can be incremented and immediately return
    val lastNotNine : Boolean = digits[digits.lastIndex] != 9
    if (lastNotNine) {
        digits[digits.lastIndex] += 1
        return digits
    }

    //a value can be incremented without adding an element
    val noExtraElement : Boolean = digits.toSet().size > 1
    if (noExtraElement) {
        for (i in digits.lastIndex downTo 0) {
            if (digits[i] == 9) {
                digits[i] = 0
            } else if (digits[i] < 9) {
                digits[i] += 1
                return digits
            }
        }
    }

    //digits is only 9s, require new element, rest init as 0
    val extraDigitArray : IntArray =  IntArray(digits.size + 1)
    extraDigitArray[0] = 1
    return extraDigitArray

}