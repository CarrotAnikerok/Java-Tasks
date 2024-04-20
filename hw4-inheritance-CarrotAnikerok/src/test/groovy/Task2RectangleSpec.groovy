import spock.lang.Specification;

class Task2RectangleSpec extends Specification {

    def "2: rectangle; check area"() {
        given:
        Figure square = new Rectangle(a, b)

        when:
        def area = square.area()

        then:
        TestHelper.round3(area) == expectedArea

        where:
        a   ||  b  || expectedArea
        0   ||  0  || 0
        0   ||  1  || 0
        1   ||  0  || 0
        1   ||  1  || 1
        2   ||  1  || 2
        2   ||  2  || 4
        5   ||  8  || 40

    }

    def "2: square; check area with negative a"() {
        given:
        Figure rectangle = new Rectangle(-2, -8)

        when:
        def area = rectangle.area()

        then:
        TestHelper.round3(area) == Double.NaN || TestHelper.round3(area) == 0
    }

    def "2: square; check perimeter"() {
        given:
        Figure rectangle = new Rectangle(a, b)

        when:
        def perimeter = rectangle.perimiter()

        then:
        TestHelper.round3(perimeter) == expectedPerimeter

        where:
        a   ||  b  || expectedPerimeter
        0   ||  0  || 0
        0   ||  1  || 2
        1   ||  1  || 4
        5   ||  3  || 16
        12  ||  10 || 44
    }

    def "2: square; check perimeter with negative a"() {
        given:
        Figure rectangle = new Rectangle(-4, -3)

        when:
        def perimeter = rectangle.perimiter()

        then:
        TestHelper.round3(perimeter) == Double.NaN || TestHelper.round3(perimeter) == 0
    }

    def "2: square; check info"() {
        given:
        Figure rectangle = new Rectangle(4, 1)

        expect:
        rectangle.info() == "pramougolnic so sotoronami 4.0 i 1.0"
    }
}
