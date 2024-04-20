package Homework4;

public class RightTriangle extends Triangle implements Figure {

    public double side1;
    public double side2;

    public RightTriangle(double s1, double s2) {
        super(s1, s2, Math.sqrt((s1 * s1 + s2 * s2)));
    }
    /*
    @Override
    public double area() {
        return (side1 * side2) / 2;
    }

    @Override
    public double perimiter() {
        return side1 + side2 + Math.sqrt((side1 * side1 + side2 * side2));
    }
     */

    @Override
    public String info() {
        return "прямоугольный треугольник со стороными " + side1 + " и " + side2;
    }
}
