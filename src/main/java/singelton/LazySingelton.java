package singelton;

public class LazySingelton {

    private static LazySingelton INSTANCE =null;

    private LazySingelton(){

        System.out.println("Singelton object being created");
    }

    /*public static synchronized LazySingelton getInstance (){

        if(INSTANCE==null){
            INSTANCE=new LazySingelton();
        }

        return INSTANCE;

    }*/

    public static LazySingelton getInstance(){

        if(INSTANCE==null) {

            synchronized (LazySingelton.class) {

                if(INSTANCE==null){

                }

            }
        }
        return  INSTANCE;


    }
}

class DemoSingelton{

    public static void main(String[] args) {



    }



}
