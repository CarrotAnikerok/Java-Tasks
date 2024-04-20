package Homework4;

public class Diamond implements Figure {

    public double diagonal1;
    public double diagonal2;

    public Diamond(double d1, double d2) {
        diagonal1 = d1;
        diagonal2 = d2;
    }
    @Override
    public double area() {
        return (diagonal1 + diagonal2) / 2;
    }

    @Override
    public double perimiter() {
        return 2 * Math.sqrt(diagonal1 * diagonal1 + diagonal2 * diagonal2);
    }

    @Override
    public String info() {
        return "ромб с диагоналями " + diagonal1 + " и " + diagonal2;
    }
}
