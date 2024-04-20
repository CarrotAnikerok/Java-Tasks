package Homework4;

public class Rectangle implements Figure {

    public double height;
    public double width;


    public Rectangle(double h, double w) {
        height = h;
        width = w;
    }
    @Override
    public double area() {
        return height * width;
    }

    @Override
    public double perimiter() {
        return 2 * height + 2 * width;
    }

    @Override
    public String info() {
        return "прямоугольник со сторонами " + height + " и " + width;
    }
}
