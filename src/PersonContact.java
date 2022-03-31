import java.math.BigInteger;
import java.util.List;

public class PersonContact {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String email;
    private String zip;
    private String phone;

    public void addPersonContact(List personDetail) {
        this.firstName = (String) personDetail.get(0);
        this.lastName = (String) personDetail.get(1);
        this.address = (String) personDetail.get(2);
        this.city = (String) personDetail.get(3);
        this.state = (String) personDetail.get(4);
        this.zip = (String) personDetail.get(5);
        this.phone = (String) personDetail.get(6);
        this.email = (String) personDetail.get(7);
    }

    public void editPersonContactDetails(List personDetail) {
        this.lastName = (String) personDetail.get(0);
        this.address = (String) personDetail.get(1);
        this.city = (String) personDetail.get(2);
        this.state = (String) personDetail.get(3);
        this.zip = (String) personDetail.get(4);
        this.phone = (String) personDetail.get(5);
        this.email = (String) personDetail.get(6);
    }

    public void displayPersonContactDetails() {
        System.out.println("First Name: " + firstName + "\nLast Name: " + lastName + "\nAddress: " + address + "\nCity: " + city + "\nState: " + state + "\nZip: " + zip + "\nPhone Number: " + phone + "\nEmail Id: " + email);
    }

}
