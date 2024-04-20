import spock.lang.Specification

class Task2EquilateralTriangleSpec extends Specification {

    def "2: square; check area"() {
        given:
        Figure triangle = new EquilateralTriangle(a)

        when:
        def area = triangle.area()

        then:
        TestHelper.round3(area) == expectedArea

        where:
        a                        || expectedArea
        0                        || 0
        1                        || 0.433
        2                        || 1.732
        19                       || 156.318
    }

    def "2: square; check area with negative a"() {
        given:
        Figure square = new EquilateralTriangle(-2)

        when:
        def area = square.area()

        then:
        TestHelper.round3(area) == Double.NaN || TestHelper.round3(area) == 0
    }

    def "2: square; check perimeter"() {
        given:
        Figure triangle = new EquilateralTriangle(a)

        when:
        def perimeter = triangle.perimiter()

        then:
        TestHelper.round3(perimeter) == expectedPerimeter

        where:
        a                        || expectedPerimeter
        0                        || 0
        1                        || 3
        2                        || 6
        12                       || 36
    }

    def "2: square; check perimeter with negative a"() {
        given:
        Figure triangle = new EquilateralTriangle(-4)

        when:
        def perimeter = triangle.perimiter()

        then:
        TestHelper.round3(perimeter) == Double.NaN || TestHelper.round3(perimeter) == 0
    }

    def "2: square; check info"() {
        given:
        Figure equilateralTriangle = new EquilateralTriangle(4)

        expect:
        equilateralTriangle.info() == "ravnostoronny treugolnik so storonoi 4.0"
    }
}