import spock.lang.Specification

class Task2SquareTest extends Specification {

    def "2: square; check area"() {
        given:
        Figure square = new Square(a)

        when:
        def area = square.area()

        then:
        TestHelper.round3(area) == expectedArea

        where:
        a                        || expectedArea
        0                        || 0
        2                        || 4
        10                       || 100
    }

    def "2: square; check area with negative a"() {
        given:
        Figure square = new Square(-2)

        when:
        def area = square.area()

        then:
        TestHelper.round3(area) == Double.NaN || TestHelper.round3(area) == 0
    }

    def "2: square; check perimeter"() {
        given:
        Figure square = new Square(a)

        when:
        def perimeter = square.perimiter()

        then:
        TestHelper.round3(perimeter) == expectedPerimeter

        where:
        a                        || expectedPerimeter
        0                        || 0
        1                        || 4
        2                        || 8
        12                       || 48
    }

    def "2: square; check perimeter with negative a"() {
        given:
        Figure square = new Square(-4)

        when:
        def perimeter = square.perimiter()

        then:
        TestHelper.round3(perimeter) == Double.NaN || TestHelper.round3(perimeter) == 0
    }

    def "2: square; check info"() {
        given:
        Figure square = new Square(4D)

        expect:
        square.info() == "kvadrat so storonoi 4.0"
    }

}
