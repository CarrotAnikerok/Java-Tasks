import spock.lang.Specification

class Task2CircleSpec extends Specification {

    def "2: circle; check area"() {
        given:
        Figure circle = new Circle(2)

        when:
        def area = circle.area()

        then:
        TestHelper.round3(area) == 12.566D
    }

    def "2: circle; check area with negative radius"() {
        given:
        Figure circle = new Circle(-2)

        when:
        def area = circle.area()

        then:
        TestHelper.round3(area) == Double.NaN || TestHelper.round3(area) == 0
    }

    def "2: circle; check perimeter"() {
        given:
        Figure circle = new Circle(4)

        when:
        def perimeter = circle.perimiter()

        then:
        TestHelper.round3(perimeter) == 25.133D
    }

    def "2: circle; check perimeter with negative radius"() {
        given:
        Figure circle = new Circle(-4)

        when:
        def perimeter = circle.perimiter()

        then:
        TestHelper.round3(perimeter) == Double.NaN || TestHelper.round3(perimeter) == 0
    }

    def "2: circle; check info"() {
        given:
        Figure circle = new Circle(2D)

        expect:
        circle.info() == "krug radiusa 2.0"
    }
}