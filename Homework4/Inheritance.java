package Homework4;

public class Inheritance{
    public static void main(String[] args) {
        Circle circle = new Circle(2);
        Diamond diamond = new Diamond(2, 3);
        EqualTriangle eTriangle = new EqualTriangle(4);
        Rectangle rectangle = new Rectangle(5, 8);
        RightTriangle rTriangle = new RightTriangle(3, 4);
        Square square = new Square(4);

        Circle text = new Circle(-2);
        System.out.println(rTriangle.side1);

        System.out.println(text.area());

        Figure[] all = {circle, diamond, eTriangle, rectangle, rTriangle, square};

        for (Figure i : all) {
            System.out.println(i.info());
            System.out.println(i.area());
            System.out.println(i.perimiter());
            System.out.println(i.capacity());
            System.out.println(Figure.capacity(i));
        }
    }
}
