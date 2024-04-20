import spock.lang.Specification;

class Task2RohmbSpec extends Specification {

    def "2: rectangle; check area"() {
        given:
        Figure rhomb = new Rhomb(a, b)

        when:
        def area = rhomb.area()

        then:
        TestHelper.round3(area) == expectedArea

        where:
        a   ||  b  || expectedArea
        0   ||  0  || 0
        0   ||  1  || 0
        1   ||  0  || 0
        1   ||  1  || 0.5
        2   ||  1  || 1
        2   ||  2  || 2
        5   ||  8  || 20

    }

    def "2: square; check area with negative a"() {
        given:
        Figure rhomb = new Rhomb(-2, -7)

        when:
        def area = rhomb.area()

        then:
        TestHelper.round3(area) == Double.NaN || TestHelper.round3(area) == 0
    }

    def "2: square; check perimeter"() {
        given:
        Figure rhomb = new Rhomb(a, b)

        when:
        def perimeter = rhomb.perimiter()

        then:
        TestHelper.round3(perimeter) == expectedPerimeter

        where:
        a   ||  b  || expectedPerimeter
        0   ||  0  || 0
        1   ||  1  || 2.828
        5   ||  3  || 11.662
        12  ||  10 || 31.241
    }

    def "2: square; check perimeter with negative a"() {
        given:
        Figure rhomb = new Rhomb(-4, -7)

        when:
        def perimeter = rhomb.perimiter()

        then:
        TestHelper.round3(perimeter) == Double.NaN || TestHelper.round3(perimeter) == 0
    }

    def "2: square; check info"() {
        given:
        Figure rhomb = new Rhomb(4, 7)

        expect:
        rhomb.info() == "rhomb s diagonalami 4.0 i 7.0"
    }
}
