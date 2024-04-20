public interface Figure {
    /** Возвращает площадь фигуры*/
    double area();
    /** Возвращает периметр фигуры */
    double perimiter();

    /** Возвращает информацию о фигуре по типу “квадрат со стороной 7”, “круг радиуса 22” и т.п.*/
    String info();
    static double capacity(Figure f) {
        return f.area()/f.perimiter();
    }

    /** Вычисляет отношение площади к квадрату периметра */
    default double capacity() {
        return area()/perimiter();
    }
}
