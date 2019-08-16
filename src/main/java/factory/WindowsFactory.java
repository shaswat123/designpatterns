package factory;

public class WindowsFactory implements  OSFactory {

    public Phone create(Manufacturer manufacturer) {

        switch (manufacturer){

            case MICROSOFT:
                return new WindowsPhone() ;
            default:
                return  null;






        }

    }
}
