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

    public void addOrEditPersonContact(List personDetail) {
        this.firstName = (String) personDetail.get(0);
        this.lastName = (String) personDetail.get(1);
        this.address = (String) personDetail.get(2);
        this.city = (String) personDetail.get(3);
        this.state = (String) personDetail.get(4);
        this.zip = (String) personDetail.get(5);
        this.phone = (String) personDetail.get(6);
        this.email = (String) personDetail.get(7);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void displayPersonContactDetails() {
        System.out.println("First Name: " + firstName + "\nLast Name: " + lastName + "\nAddress: " + address + "\nCity: " + city + "\nState: " + state + "\nZip: " + zip + "\nPhone Number: " + phone + "\nEmail Id: " + email);
    }

}
