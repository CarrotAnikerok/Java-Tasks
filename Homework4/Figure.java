package Homework4;

public interface Figure {
    double area(); //возвращает площадь фигуры
    double perimiter(); //возвращает периметр фигуры
    String info(); //возвращает ифнормацию о фигуре по типу “квадрат со стороной 7”, “круг радиуса 22” и т.п.
    static double capacity(Figure f) {
        return f.area()/(f.perimiter() * f.perimiter());
    }
    default double capacity() {
        return area()/(perimiter() * perimiter());
    } //вычисляет отношение площади к квадрату периметра
}
