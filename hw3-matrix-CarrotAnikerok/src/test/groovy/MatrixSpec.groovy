import spock.lang.Specification

class MatrixSpec extends Specification {

    def "1: should create matrix by constructor"() {
        given:
        def matrix = new Matrix22(0,1,2,3)

        when:
        def arrayFromMatrix = matrix.get()

        then:
        arrayFromMatrix == [[0, 1], [2, 3]] as double[][]
    }

    def "2: when we change array from which we create matrix, matrix should stay the same"() {
        given:
        def matrixArray = [[0, 1], [2, 3]] as double[][]
        def matrix = new Matrix22(matrixArray)

        when:
        matrixArray[0][0] = 100
        def arrayFromMatrix = matrix.get()

        then:
        arrayFromMatrix[0][0] == 0
    }

    def "3: calc det"() {
        given:
        def matrix1 = new Matrix22([[0, 1], [2, 3]] as double[][])
        def matrix2 = new Matrix22([[5, 10], [-2, 6]] as double[][])
        expect:
        matrix1.det() == -2
        matrix2.det() == 50
    }

    def "3: calc trace"() {
        given:
        def matrix1 = new Matrix22([[0, 1], [2, 3]] as double[][])
        def matrix2 = new Matrix22([[5, 10], [-2, 6]] as double[][])
        def matrix3 = new Matrix22([[5, 10], [-2, -6]] as double[][])
        expect:
        matrix1.trace() == 3
        matrix2.trace() == 11
        matrix3.trace() == -1
    }

    def "4: matrix should not change when we change got array"() {
        given:
        def matrix = new Matrix22([[0, 1], [2, 3]] as double[][])

        when:
        def arrayFromMatrix = matrix.get()
        arrayFromMatrix[0][0] = 100

        then:
        matrix.get()[0][0] == 0
    }

    def "7: should add 2 matrix"() {
        given:
        def matrix1 = new Matrix22([[1, 2], [3, 4]] as double[][])
        def matrix2 = new Matrix22([[5, 6], [7, 8]] as double[][])

        when:
        def result = matrix1.add(matrix2)

        then:
        result.get() == [[6, 8], [10, 12]] as double[][]
    }

    def "8: should mul 2 matrix"() {
        given:
        def matrix1 = new Matrix22([[2, 2], [1, 2]] as double[][])
        def matrix2 = new Matrix22([[3, 4], [2, 3]] as double[][])

        when:
        def result = matrix1.mul(matrix2)

        then:
        result.get() == [[10, 14], [7, 10]] as double[][]
    }

    def "8: should mul 2 matrix again"() {
        given:
        def matrix1 = new Matrix22([[1, 2], [3, 4]] as double[][])
        def matrix2 = new Matrix22([[5, 6], [7, 8]] as double[][])

        when:
        def result = matrix1.mul(matrix2)

        then:
        result.get() == [[19, 22], [43, 50]] as double[][]
    }

    def "9: pow 1 matrix"() {
        given:
        def matrix1 = new Matrix22([[1, 2], [3, 4]] as double[][])

        when:
        matrix1.pow(1)

        then:
        matrix1.get() == [[1, 2], [3, 4]] as double[][]
    }

    def "9: pow 2 matrix"() {
        given:
        def matrix1 = new Matrix22([[1, 2], [3, 4]] as double[][])

        when:
        matrix1.pow(2)

        then:
        matrix1.get() == [[7, 10], [15, 22]] as double[][]
    }

    def "9: pow 15 matrix"() {
        given:
        def matrix1 = new Matrix22([[1, 2], [3, 4]] as double[][])

        when:
        matrix1.pow(15)

        then:
        matrix1.get() == [[21407570533, 31199973606], [46799960409, 68207530942]] as double[][]
    }
}