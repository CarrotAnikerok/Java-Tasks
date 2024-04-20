package Homework4;

public class EqualTriangle extends Triangle implements Figure {

    public double side;

    public EqualTriangle(double s) {
        super(s, s, s);
    }

    /*
    @Override
    public double area() {
        return Math.sqrt(3) * side * side / 4;
    }

    @Override
    public double perimiter() {
        return 3 * side;
    }
    */

    @Override
    public String info() {
        return "равносторонний треугольник со стороной " + side;
    }
}
