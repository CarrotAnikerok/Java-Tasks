import spock.lang.Specification

class Task4Capacity extends Specification {
    def "4: calc by default method capacity"() {
        when:
        def calculatedCapacity = TestHelper.round3 figure.capacity()

        then:
        calculatedCapacity == capacity

        where:
        figure                     || capacity
        new Circle(5)              || 2.5D
        new EquilateralTriangle(5) || 0.722
        new Rectangle(5, 6)        || 1.364
        new RightTriangle(5, 6)    || 0.797
        new Rhomb(5, 6)            || 0.96
        new Square(5)              || 1.25
    }

    def "4: calc by static method capacity"() {
        when:
        def calculatedCapacity = TestHelper.round3 Figure.capacity(figure)

        then:
        calculatedCapacity == capacity

        where:
        figure                     || capacity
        new Circle(5)              || 2.5D
        new EquilateralTriangle(5) || 0.722
        new Rectangle(5, 6)        || 1.364
        new RightTriangle(5, 6)    || 0.797
        new Rhomb(5, 6)            || 0.96
        new Square(5)              || 1.25
    }

}
