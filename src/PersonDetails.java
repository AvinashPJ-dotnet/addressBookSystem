import java.util.Comparator;

public class PersonDetails<T extends Comparable<T>> {
    private T firstName;
    private T lastName;
    private T address;
    private T city;
    private T state;
    private T email;
    private T zip;
    private T phone;


    public T getFirstName() {
        return firstName;
    }

    public void setFirstName(T firstName) {
        this.firstName = firstName;
    }

    public T getLastName() {
        return lastName;
    }

    public void setLastName(T lastName) {
        this.lastName = lastName;
    }

    public T getAddress() {
        return address;
    }

    public void setAddress(T address) {
        this.address = address;
    }

    public T getCity() {
        return city;
    }

    public void setCity(T city) {
        this.city = city;
    }

    public T getState() {
        return state;
    }

    public void setState(T state) {
        this.state = state;
    }

    public T getZip() {
        return zip;
    }

    public void setZip(T zip) {
        this.zip = zip;
    }

    public T getPhone() {
        return phone;
    }

    public void setPhone(T phone) {
        this.phone = phone;
    }

    public T getEmail() {
        return email;
    }

    public void setEmail(T email) {
        this.email = email;
    }


    public void displayPersonContactDetails() {
        System.out.println("First Name: " + firstName + "\nLast Name: " + lastName + "\nAddress: " + address + "\nCity: " + city + "\nState: " + state + "\nZip: " + zip + "\nPhone Number: " + phone + "\nEmail Id: " + email);
    }

    @Override
    public String toString() {
        return "PersonDetails{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", email='" + email + '\'' +
                ", zip='" + zip + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}