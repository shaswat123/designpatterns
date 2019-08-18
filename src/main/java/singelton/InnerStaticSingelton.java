package singelton;

/*
Notice the private inner static class that contains the instance of the singleton class.
When the singleton class is loaded, SingletonHelper class is not loaded into memory
and only when someone calls the getInstance method,
this class gets loaded and creates the Singleton class instance.

This is the most widely used approach for Singleton class as it doesn’t require synchronization.
 */

public class InnerStaticSingelton {

    private InnerStaticSingelton(){

     }

     private static class InnerStaticSingeltonImpl{

        private static final InnerStaticSingelton INSTANCE = new InnerStaticSingelton();


    }

    public  static InnerStaticSingelton getInstance(){

        return InnerStaticSingeltonImpl.INSTANCE;
    }


}

class DemoInnerStaticSingelton{

    public static void main(String[] args) {

        InnerStaticSingelton innerStaticSingelton = InnerStaticSingelton.getInstance();

    }
    InnerStaticSingelton innerStaticSingelton = InnerStaticSingelton.getInstance();
}
