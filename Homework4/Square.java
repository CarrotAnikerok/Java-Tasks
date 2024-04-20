package Homework4;

public class Square extends Rectangle implements Figure {

    public double side;


    public Square(double s) {
        super(s, s);
    }
    /*
    @Override
    public double area() {
        return side * side;
    }

    @Override
    public double perimiter() {
        return 4 * side;
    } */

    @Override
    public String info() {
        return "квадрат со стороной " + side;
    }
}
