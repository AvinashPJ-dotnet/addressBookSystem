import java.util.Dictionary;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBook {
    HashMap<String, Object> contactDetailsList = new HashMap<>();
    public void addContactDetails(){
        System.out.println("Enter Contact Details");
        System.out.println("----------------------");
        Scanner in = new Scanner(System.in);
        System.out.print("Enter First Name: ");
        String fName=in.next();
        System.out.print("Enter Last Name: ");
        String lName=in.next();
        System.out.print("Enter Address: ");
        String address=in.next();
        System.out.print("Enter City: ");
        String city=in.next();
        System.out.print("Enter State: ");
        String state=in.next();
        System.out.print("Enter Zip: ");
        int zip=in.nextInt();
        System.out.print("Enter Phone number: ");
        String phone=in.next();
        System.out.print("Enter Email Id: ");
        String email=in.next();

        //initialize details using contractor
        PersonContact newPersonContact = new PersonContact(fName, lName, address, city, state, zip, phone, email);
        contactDetailsList.put(fName,newPersonContact);
    }

    //display contact details
    public void displayContactDetails(){
        for (String key: contactDetailsList.keySet()) {
            PersonContact newPersonContact=(PersonContact) contactDetailsList.get(key);
            System.out.println("--------------------------");
            newPersonContact.displayPersonContactDetails();
        }

    }
}
