public class Square extends Rectangle {

    public double side;


    public Square(double s) {
        super(s, s);
        this.side = s;
    }

    @Override
    public String info() {
        return "kvadrat so storonoi " + side;
    }
}
