package factory;

public class AndroidFactory implements OSFactory {

    public Phone create(Manufacturer manufacturer) {

        switch (manufacturer){
            case GOOGLE:
                return new GooglePhone();

            case LENOVO:
                return new LenovoPhone() ;
            default:
                return  null;






        }

    }
}
