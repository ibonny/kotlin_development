package kotlin_development

class AutoKey() {
    val alphabet = "abcdefghijklmnopqrstuvwxyz"

    fun lookup(orig: Char, key: Char): Char {
        val offset = key.toInt() - 'a'.toInt()

        val newalpha = alphabet.substring(offset, alphabet.length) +
            alphabet.substring(0, offset)

        return newalpha[orig.toInt() - 'a'.toInt()]
    }

    fun rev_lookup(orig: Char, key: Char): Char {
        val char_val = key.toInt() - 'a'.toInt()

        val newalpha = alphabet.substring(char_val, alphabet.length) +
            alphabet.substring(0, char_val)

        val offset = newalpha.indexOf(orig)

        return alphabet[offset]
    }

    fun encrypt(str: String, kw: String): String {
        val nospaces = str.replace(" ", "")

        var output_string = ""
        var keystring = kw

        var key_index = 0

        for (char in nospaces) {
            output_string += rev_lookup(char, keystring[key_index])

            keystring += char

            key_index += 1
        }

        return output_string
    }

    fun decrypt(str: String, kw: String): String {
        val nospaces = str.replace(" ", "")

        var output_string = ""
        var keystring = kw

        var key_index = 0

        for (char in nospaces) {
            val dchar = lookup(char, keystring[key_index])

            output_string += dchar

            keystring += dchar

            key_index += 1
        }

        return output_string
     }

    fun process(args: Array<String>) {
        var original = "this is a test"

        if (args.size > 0) {
            original = args.joinToString(" ")
        }

        println(original)

        val encrypted = format_string(this.encrypt(original, "fortification"))

        println(encrypted)

        val decrypted = this.decrypt(encrypted, "fortification")

        println(decrypted)
    }
}
