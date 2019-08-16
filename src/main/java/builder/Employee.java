package builder;

//Multiple builders
public class Employee {

    // address
    public String streetAddress, postcode, city;

    // employment
    public String companyName, position;
    public int annualIncome;

    @Override
    public String toString()
    {
        return "Person{" +
                "streetAddress='" + streetAddress + '\'' +
                ", postcode='" + postcode + '\'' +
                ", city='" + city + '\'' +
                ", companyName='" + companyName + '\'' +
                ", position='" + position + '\'' +
                ", annualIncome=" + annualIncome +
                '}';
    }


}

class EmployeeBuilders{

    protected Employee employee = new Employee();

    public  EmployeeAddressBuilder lives(){
        return new EmployeeAddressBuilder(employee);
    }


    public  EmployeeJobBuilder works(){
        return new EmployeeJobBuilder(employee);
    }

    public Employee build (){
        return employee;
    }


}

class EmployeeAddressBuilder extends  EmployeeBuilders{

    public EmployeeAddressBuilder(Employee employee){
        this.employee= employee;

    }

    public EmployeeAddressBuilder at(String streetAddress) {

        employee.streetAddress = streetAddress;

        return this;

    }

    public EmployeeAddressBuilder withPostCode(String postCode){

        employee.postcode=postCode;
        return  this;
    }

    public EmployeeAddressBuilder in(String city){

        employee.city=city;
        return this;
    }





}

class EmployeeJobBuilder extends EmployeeBuilders
{
    public EmployeeJobBuilder(Employee employee)
    {
        this.employee = employee;
    }

    public EmployeeJobBuilder at(String companyName)
    {
        employee.companyName = companyName;
        return this;
    }

    public EmployeeJobBuilder asA(String position)
    {
        employee.position = position;
        return this;
    }

    public EmployeeJobBuilder earning(int annualIncome)
    {
        employee.annualIncome = annualIncome;
        return this;
    }
}


class EmployeeBuilderDemo{

    public static void main(String[] args) {

        Employee employee = new EmployeeBuilders()
                .lives()
                 .at("123 London Road")
                 .in("London")
                 .withPostCode("12345")
                .works()
                 .asA("SSE")
                 .at("Microsoft")
                 .earning(10000)
                .build();


        System.out.println(employee);

    }

}