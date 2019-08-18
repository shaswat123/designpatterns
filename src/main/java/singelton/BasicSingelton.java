package singelton;

public class BasicSingelton {

    private  BasicSingelton(){
        System.out.println("objects created");
    }

    private static final BasicSingelton INSTANCE = new BasicSingelton();

    public static BasicSingelton getInstance(){
        System.out.println("Now calling");
        return INSTANCE;
    }

}

class Demo{

    public static void main(String[] args) {
        BasicSingelton singeltonObj = BasicSingelton.getInstance();

    }
}
