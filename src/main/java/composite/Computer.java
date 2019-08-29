package composite;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    public static void main(String[] args) {

        Component hd = new Leaf(4000,"HDD");
        Component mouse = new Leaf(5000,"Mouse");
        Component Monitor = new Leaf(6000,"Monitor");
        Component Ram = new Leaf(7000,"RAM");

        Component CPU = new Leaf(7000,"CPU");

        Composite motherBoard = new Composite("Motherboard");
        Composite peripheral = new Composite("Peripheral");

        Composite cabinet = new Composite("Cabinet");
        Composite computer = new Composite("Computer");

        motherBoard.addComponent(Ram);
        motherBoard.addComponent(CPU);

        peripheral.addComponent(mouse);
        peripheral.addComponent(Monitor);

        cabinet.addComponent(motherBoard);
        cabinet.addComponent(hd);

        computer.addComponent(peripheral);
        computer.addComponent(cabinet);

        Ram.showPrice();

        computer.showPrice();


    }


}

interface Component{

    public void showPrice();

}

class Leaf implements Component{


    private Integer price;
    private String name ;

    public Leaf(Integer price, String name) {
        this.price = price;
        this.name = name;
    }

    @Override
    public void showPrice() {


        System.out.println("Name :-"+ name +"Price :-"+price);

    }
}

class Composite implements Component{

    private String name ;
    private List<Component> components = new ArrayList<>();

    public Composite(String name) {
        this.name = name;
    }

    @Override
    public void showPrice() {

        System.out.println("Name:-"+name );

        components.stream().forEach(x->x.showPrice());

    }

    public void addComponent(Component component){

        components.add(component);

    }
}

