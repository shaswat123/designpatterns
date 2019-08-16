package factory;

public class AbstractFactoryPatternExample {

    public static void main(String[] args) {

        Phone phone=AbstractPhoneFactory.getFactory(OSType.ANDROID).create(Manufacturer.LENOVO);
        phone.display();

        Phone phone1=AbstractPhoneFactory.getFactory(OSType.WINDOWS).create(Manufacturer.MICROSOFT);
        phone1.display();

        Phone phone3=AbstractPhoneFactory.getFactory(OSType.ANDROID).create(Manufacturer.GOOGLE);
        phone3.display();

    }
}
