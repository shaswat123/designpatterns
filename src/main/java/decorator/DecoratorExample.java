package decorator;

interface Shape{
    public String info();
}

class Circle implements Shape{

    private Float radius ;


    public Circle(Float radius) {
        this.radius = radius;
    }

    public Circle() {
    }

    public void resize(Integer factor){

        radius *= factor;

    }

    @Override
    public String info() {
        return "A circle of radius"+radius;
    }


}

class Square implements Shape{

    private Float side;

    public Square(Float side) {
        this.side = side;
    }

    public Square() {
    }

    @Override
    public String info() {
        return "A square of side "+side;
    }
}

//Decorator
class ColoredShape implements Shape{

    private Shape shape;
    private  String color;

    public ColoredShape(Shape shape, String color) {
        this.shape = shape;
        this.color = color;
    }

    @Override
    public String info() {
        return shape.info()+"has the color "+color;
    }
}

//Decorator

class TransparentShape implements Shape{

    private Shape shape;
    private Integer transparency;

    public TransparentShape(Shape shape, Integer transparency) {
        this.shape = shape;
        this.transparency = transparency;
    }



    @Override
    public String info() {
        return shape.info()+"has "+ transparency +"% transparency ";
    }
}



public class DecoratorExample {

    public static void main(String[] args) {

        Circle circle = new Circle(10F);
        System.out.println(circle.info());

        ColoredShape blueSquare = new ColoredShape(new Square(10F),"blue");

        System.out.println(blueSquare.info());


        TransparentShape transparentRedCircle = new TransparentShape(new ColoredShape(new Circle(5F),"Green"),50);

        System.out.println(transparentRedCircle.info());

    }





}
