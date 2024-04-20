import spock.lang.Specification

class Task1FigureSpec extends Specification{
    def "1: check methods of interface Figure"() {
        given:
        def figureMethods = Figure.getMethods()

        when:
        def areaMethod = figureMethods.find { it.name == 'area' }

        then:
        areaMethod != null
        areaMethod.genericReturnType == double
        areaMethod.parameterCount == 0

        when:
        def perimeterMethod = figureMethods.find { it.name == 'perimiter' }

        then:
        perimeterMethod != null
        perimeterMethod.genericReturnType == double
        perimeterMethod.parameterCount == 0

        when:
        def infoMethod = figureMethods.find { it.name == 'info' }

        then:
        infoMethod != null
        infoMethod.genericReturnType == String
        infoMethod.parameterCount == 0
    }
}
