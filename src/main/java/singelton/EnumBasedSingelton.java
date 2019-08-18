package singelton;
/*
Enum has a default private constructor.If u provide a constructor to an enum ,it doesn't make any sense .
Serializing enum would not serialize its state but searialize the name of the instance
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public enum EnumBasedSingelton {

    INSTANCE;


    private  Integer value;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }


}

class EnumBasedSingeltonDemo{

        static void saveToFile(EnumBasedSingelton singleton, String filename)
                throws Exception
        {
            try (FileOutputStream fileOut = new FileOutputStream(filename);
                 ObjectOutputStream out = new ObjectOutputStream(fileOut))
            {
                out.writeObject(singleton);
            }
        }

        static EnumBasedSingelton readFromFile(String filename)
                throws Exception
        {
            try (FileInputStream fileIn = new FileInputStream(filename);
                 ObjectInputStream in = new ObjectInputStream(fileIn) )
            {
                return (EnumBasedSingelton)in.readObject();
            }
        }

    public static void main(String[] args)
            throws Exception
    {
        String filename = "myfile.bin";

        // run again with next 3 lines commented out

        EnumBasedSingelton singleton = EnumBasedSingelton.INSTANCE;
        singleton.setValue(111);
        saveToFile(singleton, filename);

        EnumBasedSingelton singleton2 = readFromFile(filename);
        System.out.println(singleton2.getValue());

        System.out.println(singleton.hashCode());
        System.out.println(singleton2.hashCode());
    }

}
