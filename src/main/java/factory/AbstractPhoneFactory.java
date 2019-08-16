package factory;

//This abstract class will return PhoneFactories based on OSType like WindowsPhoneFactory or AndroidFactory

public abstract class AbstractPhoneFactory {

    public static OSFactory getFactory(OSType osType){

        switch (osType){

             case ANDROID:
                 return new AndroidFactory();

            case WINDOWS:
                return new WindowsFactory() ;

            case IOS:
                return null;

             default:
                 return  null;


        }
    }


}
