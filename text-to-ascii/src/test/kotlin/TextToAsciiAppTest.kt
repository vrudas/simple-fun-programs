import org.testng.annotations.Test

class TextToAsciiAppTest {

    @Test
    fun testPrintAscii_with_normal_letters() {
        TextToAsciiApp("MANHATTAN", 5, 4).printAscii()
    }

    @Test
    fun testPrintAscii_with_ignore_case() {
        TextToAsciiApp("ManhAtTan", 5, 4).printAscii()
    }

    @Test
    fun testPrintAscii_with_unknown() {
        TextToAsciiApp("M@NH@TT@N", 5, 4).printAscii()
    }
}