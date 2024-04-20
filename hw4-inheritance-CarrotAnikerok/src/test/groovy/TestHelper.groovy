import java.math.RoundingMode

class TestHelper {
    def static round3(double number) {
        if (number.isNaN()) {
            return number
        }

        BigDecimal bd = new BigDecimal(number)
        bd = bd.setScale(3, RoundingMode.HALF_UP)
        return bd.doubleValue()
    }
}
