public class Rhomb implements Figure {

    public double diagonal1;
    public double diagonal2;

    public Rhomb(double d1, double d2) {
        diagonal1 = d1;
        diagonal2 = d2;
    }
    @Override
    public double area() {
        if (diagonal1 < 0 || diagonal2 < 0)
            return 0;
        return (diagonal1 * diagonal2) / 2;
    }

    @Override
    public double perimiter() {
        if (diagonal1 < 0 || diagonal2 < 0)
            return 0;
        return 2 * Math.sqrt(diagonal1 * diagonal1 + diagonal2 * diagonal2);
    }

    @Override
    public String info() {
        return "rhomb s diagonalami " + diagonal1 + " i " + diagonal2;
    }

    @Override
    public double capacity() {
        return (diagonal1 * diagonal2 / 2) / this.perimiter();
    }
}
