import spock.lang.Specification

class CatSpec extends Specification {
    def "check cat"() {
        expect:
        IntroTasks.cat(a) == expectedCat

        where:
        a    || expectedCat
        -5   || "-5 kotov"
        -4   || "-4 kota"
        -1   || "-1 kot"
        0    || "0 kotov"
        2    || "2 kota"
        3    || "3 kota"
        4    || "4 kota"
        5    || "5 kotov"
        6    || "6 kotov"
        7    || "7 kotov"
        8    || "8 kotov"
        9    || "9 kotov"
        11   || "11 kotov"
        14   || "14 kotov"
        21   || "21 kot"
        22   || "22 kota"
        25   || "25 kotov"
        1001 || "1001 kot"
        1003 || "1003 kota"
        1005 || "1005 kotov"
    }
}
