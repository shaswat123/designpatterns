package builder;

//Using builder pattern to build fluent interface or fluent builder

public class Person {

    public String name;

    public String position;

    public String organisation;

    @Override
    public String toString()
    {
        return "Person{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ",organisation='"+organisation+'\''+
                '}';
    }


}
//The PersonBuilder is going to take a type argument and but that type argument has to be some inheritor of PersonBuilder
//Recursive Generics
class PersonBuilder<SELF extends PersonBuilder<SELF>>{

    protected Person person= new Person();

    public SELF withName(String name){
        person.name=name;

        return (SELF) this;

    }
    public SELF withPosition(String position){
        person.position=position;

        return (SELF)this;

    }

    public Person build (){
        return person;
    }

}
//Preserving fluent api
class EmployeeBuilder extends PersonBuilder<EmployeeBuilder>{

    public EmployeeBuilder worksAt(String organization){


        person.organisation=organization;

        return this;

    }
}

class Demo{

    public static void main(String[] args) {
        Person person1= new PersonBuilder()
                .withName("Shaswat")
                .build();

        Person person2= new PersonBuilder()
                .withName("Shaswat")
                .withPosition("SSE")
                .build();

        Person person3= new EmployeeBuilder()
                .withName("Erik")
                .withPosition("SSE")
                .worksAt("Google")
                .build();



        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);
    }
}


