package kotlin_development

class ADFGVX {
    val square = listOf(
        "ph0qg6",
        "4mea1y",
        "l2nofd",
        "xkr3cv",
        "s5zw7b",
        "j9uti8"
    )

    val adfgvx = "ADFGVX"

    fun location(char: Char): List<Int> {
        for ((index, line) in this.square.withIndex()) {
            if (char in line) {
                return listOf(line.indexOf(char), index)
            }
        }

        return listOf(-1, -1)
    }

    fun encode(str: String): String {
        val nospaces = str.replace(" ", "")

        var out_string = ""

        for (char in nospaces) {
            val loc = this.location(char)

            var temp = "${this.adfgvx[loc[0]]}${this.adfgvx[loc[1]]}"

            out_string += temp
        }

        var matched_val = -1

        for (i in 2..100) {
            if (i*i > out_string.length) {
                matched_val = i

                break
            }
        }

        out_string += "X".repeat(matched_val*matched_val - out_string.length)

        val square2 = out_string.chunked(matched_val)

        var step_two = ""

        for (col in 0..matched_val-1) {
            for (row in 0..square2.size-1) {
                step_two += square2[row][col]
            }
        }

        println(step_two)

        var step_three = ""

        if (step_two.length % 2 == 1) {
            step_two += "X"
        }

        for (chars in step_two.chunked(2)) {
            val row = this.adfgvx.indexOf(chars[0])
            val col = this.adfgvx.indexOf(chars[1])

            step_three += square[row][col]
        }

        return step_three
    }

    fun process(args: Array<String>) {
        val original = "this is a test"

        println(original)

        val encrypted = encode(original)

        println(encrypted)
    }
}
