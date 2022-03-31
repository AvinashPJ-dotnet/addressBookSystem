import java.math.BigInteger;

public class PersonContact {
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String city;
    private final String state;
    private final String email;
    private final int zip;
    private final String phone;

    public PersonContact(String firstName,String lastName,String address,String city,String state,int zip,String phone,String email){
        this.firstName=firstName;
        this.lastName=lastName;
        this.address=address;
        this.city=city;
        this.state=state;
        this.zip=zip;
        this.phone=phone;
        this.email=email;
        displayPersonContactDetails();
    }

    public void displayPersonContactDetails(){
        System.out.println("First Name: "+firstName+"\nLast Name: "+lastName+"\nAddress: "+address+"\nCity: "+city+"\nState: "+state+"\nZip: "+zip+"\nPhone Number: "+phone+"\nEmail Id: "+email);
    }

}
