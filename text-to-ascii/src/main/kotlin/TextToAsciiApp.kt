class TextToAsciiApp(private val text: String, private val letterHeight: Int, private val letterWidth: Int) {

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
        val letters = text.toUpperCase()
            .split("")
            .filter(String::isNotBlank)

        val asciiContainer = Array(letterHeight, { "" })

        letters.forEach { letter ->
            val letterIndex = getLetterIndex(letter)
            val asciiLetter = generateAsciiLetter(letterIndex)

            (0 until letterHeight).forEach { asciiContainer[it] += asciiLetter[it] }
        }

        asciiContainer.forEach(::println)
        println()
    }

    private fun getLetterIndex(letter: String): Int {
        val letterIndex = ALPHABET_STRING.indexOf(letter)
        return when (letterIndex) {
            -1 -> ALPHABET_STRING.indexOf('?')
            else -> letterIndex
        }
    }

    private fun generateAsciiLetter(letterIndex: Int): List<String> =
        (0 until letterHeight).map {
            val asciiIndex = letterIndex * letterWidth
            ALPHABET_ASCII[it].substring(asciiIndex, asciiIndex + letterWidth)
        }
}