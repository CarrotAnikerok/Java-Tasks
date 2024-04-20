package Homework4;

public class Circle implements Figure {

    public double radius;

    public Circle(double r) {
        radius = r;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double perimiter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String info() {
        return "круг радиуса " + radius;
    }

    @Override
    public double capacity() {
        return Math.PI * Math.pow(radius, 2) / Math.pow(2 * Math.PI * radius, 2);
    }
}


