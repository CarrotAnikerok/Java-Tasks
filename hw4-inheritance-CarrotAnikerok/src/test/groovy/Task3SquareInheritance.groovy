import spock.lang.Specification

class Task3SquareInheritance extends Specification{
    def "3. square should extend rectangle or rectangle extend squre"() {
        expect:
        Square.getSuperclass() == Rectangle || Rectangle.getSuperclass() == Square
    }
}
