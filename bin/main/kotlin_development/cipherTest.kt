package kotlin_development


fun encrypt(str: String): String {
    var outStr = ""
 
    for (char in str) {
        if (char == ' ') {
            continue
        }

        var temp = char.toInt() - 'a'.toInt()

        temp = (temp + 13) % 26

        temp += 'a'.toInt()

        outStr = "${outStr}${temp.toChar()}"
    }

    return outStr
}

fun formatted(str: String): String {
    var counter = 1

    var outStr = ""

    for (char in str) {
        outStr = "${outStr}${char}"

        if (counter % 5 == 0) {
            outStr = "${outStr} "

            counter = 0
        }

        counter += 1
    }

    return outStr
}

fun decrypt(str: String): String {
    val nextStep = str.replace("\\s".toRegex(), "")

    var outStr = ""

    for (char in nextStep) {
        var temp = char.toInt() - 'a'.toInt()

        temp = (temp + 13) % 26

        temp += 'a'.toInt()

        outStr = "${outStr}${temp.toChar()}"
    }

    return outStr
}

fun testout_fun() {
    val result = formatted(encrypt("i hope this works the way its supposed to"))

    println(result)

    val decrypted = decrypt(result)

    print(decrypted)
}