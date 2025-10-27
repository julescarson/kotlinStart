package leetcode

class IsPalindrome125 {
    fun isPalindrome(s: String): Boolean {
        if (s.length == 1) return true
        val s2 : String = s.lowercase().replace(Regex("[^a-z0-9]"), "")
        println(s2)

        for (i in 0 until s2.length/2) {
            println("${s2[i]} ${s2[s2.length-1-i]}")
            if (s2[i] == s2[s2.length-1-i]) {
                continue
            } else {
                return false
            }
        }
        return true
    }
}