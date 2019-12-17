package kotlin_development

class PlayFair {
    fun build_square(kw: String): List<String> {
        var tempString = kw

        for (char in "abcdefghiklmnopqrstuvwxyz") {
            if (char in kw) {
                continue
            }

            tempString += char
        }

        return tempString.chunked(5)
    }

    fun location(sq: List<String>, char: Char): List<Int> {
        for ((index, line) in sq.withIndex()) {
            if (char in line) {
                return listOf(line.indexOf(char), index)
            }
        }

        return listOf(-1, -1)
    }

    fun char_at_loc(sq: List<String>, loc: List<Int>): Char {
        return sq[loc[1]][loc[0]]
    }

    fun encrypt(str: String, kw: String): String {
        var nospaces = str.replace(" ", "")

        val square = build_square(kw)

        if (nospaces.length % 2 == 1) {
            nospaces += "x"
        }

        var output_string = ""

        for (pairs in nospaces.chunked(2)) {
            var modpairs = pairs

            if (modpairs[0] == modpairs[1]) {
                modpairs = modpairs.replaceRange(1, 1, "x")
            }

            val (x1, y1) = location(square, modpairs[0])
            val (x2, y2) = location(square, modpairs[1])

            var newPair1: List<Int>
            var newPair2: List<Int>

            if (x1 == x2) {
                newPair1 = listOf(x1, (y1+1) % 5)
                newPair2 = listOf(x2, (y2+1) % 5)
            }

            else if (y1 == y2) {
                newPair1 = listOf((x1+1) % 5, y1)
                newPair2 = listOf((x2+1) % 5, y2)
            }

            else {
                newPair1 = listOf(x2, y1)
                newPair2 = listOf(x1, y2)
            }

            output_string += char_at_loc(square, newPair1)
            output_string += char_at_loc(square, newPair2)
        }

        return output_string
    }

    fun rev_mod(num: Int, offset: Int): Int {
        var temp = num - 1
        
        if (temp < 0) {
            temp += offset
        }

        return temp
    }

    fun decrypt(str: String, kw: String): String {
        var nospaces = str.replace(" ", "")

        val square = build_square(kw)

        if (nospaces.length % 2 == 1) {
            nospaces += "x"
        }

        var output_string = ""

        for (pairs in nospaces.chunked(2)) {
            var modpairs = pairs

            if (modpairs[0] == modpairs[1]) {
                modpairs = modpairs.replaceRange(1, 1, "x")
            }

            val (x1, y1) = location(square, modpairs[0])
            val (x2, y2) = location(square, modpairs[1])

            var newPair1: List<Int>
            var newPair2: List<Int>

            if (x1 == x2) {
                newPair1 = listOf(x1, rev_mod(y1, 5))
                newPair2 = listOf(x2, rev_mod(y2, 5))
            }

            else if (y1 == y2) {
                newPair1 = listOf(rev_mod(x1, 5), y1)
                newPair2 = listOf(rev_mod(x2, 5), y2)
            }

            else {
                newPair1 = listOf(x2, y1)
                newPair2 = listOf(x1, y2)
            }

            output_string += char_at_loc(square, newPair1)
            output_string += char_at_loc(square, newPair2)
        }

        return output_string
    }

    fun process(args: Array<String>) {
        var original = "this is a test"

        if (args.size > 0) {
            original = args.joinToString(" ")
        }

        println(original)

        val encrypted = this.encrypt(original, "monarchy")

        println(format_string(encrypted))

        val decrypted = this.decrypt(encrypted, "monarchy")

        println(decrypted)
    }
}
