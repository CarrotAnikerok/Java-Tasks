public class Rectangle implements Figure {

    public double height;
    public double width;


    public Rectangle(double h, double w) {
        height = h;
        width = w;
    }

    @Override
    public double area() {
        if (height < 0 || width < 0)
            return 0;
        return height * width;
    }

    @Override
    public double perimiter() {
        if (height < 0 || width < 0)
            return 0;
        return 2 * height + 2 * width;
    }

    @Override
    public String info() {
        return "pramougolnic so sotoronami " + height + " i " + width;
    }
}
