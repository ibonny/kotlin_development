package kotlin_development

val checkerboard = arrayOf(
    "fkm cpd ye",
    "hbigqrosaz",
    "lutjnwvx  " 
)

fun cbencrypt(str: String): String {
    var output_string = ""

    for (char in str) {
        if (char == ' ') {
            output_string += "78 "

            continue
        }

        for ((index, line) in checkerboard.withIndex()) {
            if (char in line) {
                val pos = line.indexOf(char)

                if (index == 0) {
                    output_string += "$pos "
                } else if (index == 1) {
                    output_string += "3$pos "
                } else if (index == 2) {
                    output_string += "7$pos "
                }
            }
        }
    }

    return output_string
}

fun cbdecrypt(str: String): String {
    val nospaces = str.replace(" ", "")

    var output_string = ""

    var index = 0

    while (index < nospaces.length) {
        val char = nospaces[index]

        if (char == '3') {
            val processChar = nospaces[index+1]

            output_string += checkerboard[1][processChar.toInt() - '0'.toInt()]

            index += 2
        } else if (char == '7') {
            val processChar = nospaces[index+1]

            output_string += checkerboard[2][processChar.toInt() - '0'.toInt()]

            index += 2
        } else {
            output_string += checkerboard[0][char.toInt() - '0'.toInt()]

            index += 1
        }
    }

    return output_string
}

fun format_string(str: String): String {
    var output_string = ""

    val nospaces = str.replace(" ", "")

    var index = 0

    for (char in nospaces) {
        if (index % 5 == 0 && index != 0) {
            output_string += " "
        }

        output_string += char

        index += 1
    }

    return output_string
}

fun checkerboard_entrypoint() {
    val encrypted = cbencrypt("this is a test")

    println(format_string(encrypted))

    val decrypted = cbdecrypt(encrypted)

    println(decrypted)
}
