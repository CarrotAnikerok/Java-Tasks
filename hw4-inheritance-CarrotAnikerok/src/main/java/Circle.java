public class Circle implements Figure {

    public double radius;

    public Circle(double r) {
        radius = r;
    }

    @Override
    public double area() {
        if (radius < 0)
            return 0;
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double perimiter() {
        if (radius < 0)
            return 0;
        return 2 * Math.PI * radius;
    }

    @Override
    public String info() {
        return "krug radiusa " + radius;
    }
}


