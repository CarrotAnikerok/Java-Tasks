public class RightTriangle extends Triangle {

    public double side1;
    public double side2;

    public RightTriangle(double s1, double s2) {
        super(s1, s2, Math.sqrt((s1 * s1 + s2 * s2)));
        this.side1 = s1;
        this.side2 = s2;
    }

    @Override
    public String info() {
        return "pramougolini treugolnic so storonami " + side1 + " i " + side2;
    }
}