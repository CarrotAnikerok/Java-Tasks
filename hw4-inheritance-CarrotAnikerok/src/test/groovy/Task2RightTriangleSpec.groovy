import spock.lang.Specification;

class Task2RightTriangleSpec extends Specification {

    def "2: right triangle; check area"() {
        given:
        Figure triangle = new RightTriangle(a, b)

        when:
        def area = triangle.area()

        then:
        TestHelper.round3(area) == expectedArea

        where:
        a   ||  b  || expectedArea
        0   ||  0  || 0
        0   ||  1  || 0
        1   ||  0  || 0
        1   ||  1  || 1/2
        2   ||  1  || 1
        2   ||  2  || 2
        5   ||  8  || 20

    }

    def "2: right triangle; check area with negative a"() {
        given:
        Figure triangle = new RightTriangle(-2, -8)

        when:
        def area = triangle.area()

        then:
        TestHelper.round3(area) == Double.NaN || TestHelper.round3(area) == 0
    }

    def "2: right triangle; check perimeter"() {
        given:
        Figure triangle = new RightTriangle(a, b)

        when:
        def perimeter = triangle.perimiter()

        then:
        TestHelper.round3(perimeter) == expectedPerimeter

        where:
        a   ||  b  || expectedPerimeter
        0   ||  0  || 0
        1   ||  1  || 3.414
        5   ||  3  || 13.831
        12  ||  10 || 37.620
    }

    def "2: right triangle; check perimeter with negative a"() {
        given:
        Figure rectangle = new Rectangle(-4, -3)

        when:
        def perimeter = rectangle.perimiter()

        then:
        TestHelper.round3(perimeter) == Double.NaN || TestHelper.round3(perimeter) == 0
    }

    def "2: right triangle; check info"() {
        given:
        Figure rectangle = new RightTriangle(4, 1)

        expect:
        rectangle.info() == "pramougolini treugolnic so storonami 4.0 i 1.0"
    }
}
