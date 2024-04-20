public class EquilateralTriangle extends Triangle {

    public double side;

    public EquilateralTriangle(double s) {
        super(s, s, s);
        this.side = s;
    }

    @Override
    public String info() {
        return "ravnostoronny treugolnik so storonoi " + side;
    }
}
