package Homework4;

public class Triangle implements Figure{

    public double side1;
    public double side2;
    public double side3;

    public Triangle(double s1, double s2, double s3) {
        this.side1 = s1;
        this.side2 = s2;
        this.side3 = s3;
    }

    @Override
    public double area() {
        double p2 = this.perimiter() / 2;
        return Math.sqrt(p2 * (p2 - side1) * (p2 - side2) * (p2 - side3));
    }

    @Override
    public double perimiter() {
        return side1 + side2 + side3;
    }

    @Override
    public String info() {
        return "треугольник со стороными " + side1 + " и " + side2;
    }
}
