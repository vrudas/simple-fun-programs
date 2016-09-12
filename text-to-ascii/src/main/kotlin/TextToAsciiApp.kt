import java.util.*

class TextToAsciiApp(val text: String, val letterHeight: Int, val letterWidth: Int) {

    companion object {
        const val ALPHABET_STRING: String = "ABCDEFGHIJKLMNOPQRSTUVWXYZ?"
        val ALPHABET_ASCII: Array<String> = arrayOf(
                " #  ##   ## ##  ### ###  ## # # ###  ## # # #   # # ###  #  ##   #  ##   ## ### # # # # # # # # # # ### ### ",
                "# # # # #   # # #   #   #   # #  #    # # # #   ### # # # # # # # # # # #    #  # # # # # # # # # #   #   # ",
                "### ##  #   # # ##  ##  # # ###  #    # ##  #   ### # # # # ##  # # ##   #   #  # # # # ###  #   #   #   ## ",
                "# # # # #   # # #   #   # # # #  #  # # # # #   # # # # # # #    ## # #   #  #  # # # # ### # #  #  #       ",
                "# # ##   ## ##  ### #    ## # # ###  #  # # ### # # # #  #  #     # # # ##   #  ###  #  # # # #  #  ###  #  "
        )
    }

    fun printAscii() {
        val letters = text.toUpperCase().split("").filter(String::isNotBlank)
        val asciiContainer = Array(letterHeight, { it -> "" })

        letters.forEach {
            val letterIndex = getLetterIndex(it)
            val asciiLetter = generateAsciiLetter(letterIndex)

            for (i in 0 until letterHeight) {
                asciiContainer[i] += asciiLetter[i]
            }
        }

        asciiContainer.forEach(::println)
        println()
    }

    fun getLetterIndex(letter: String): Int {
        val letterIndex = ALPHABET_STRING.indexOf(letter)
        return if (letterIndex == -1) ALPHABET_STRING.indexOf('?') else letterIndex
    }

    fun generateAsciiLetter(letterIndex: Int): ArrayList<String> {
        val asciiLetter = ArrayList<String>()
        for (i in 0 until letterHeight) {
            val asciiIndex = letterIndex * letterWidth
            asciiLetter.add(ALPHABET_ASCII[i].substring(asciiIndex, asciiIndex + letterWidth))
        }

        return asciiLetter
    }
}