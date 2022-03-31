import java.util.*;

public class AddressBook {
    HashMap<String, Object> contactDetailsList = new HashMap<>();

    public List readContactDetail(boolean isEdit) {
        List<String> list = new ArrayList<>();
        System.out.println("Enter Contact Details");
        System.out.println("----------------------");
        Scanner in = new Scanner(System.in);
        if (isEdit == false) {
            System.out.print("Enter First Name: ");
            list.add(in.next());
        }
        System.out.print("Enter Last Name: ");
        list.add(in.next());
        System.out.print("Enter Address: ");
        list.add(in.next());
        System.out.print("Enter City: ");
        list.add(in.next());
        System.out.print("Enter State: ");
        list.add(in.next());
        System.out.print("Enter Zip: ");
        list.add(in.next());
        System.out.print("Enter Phone number: ");
        list.add(in.next());
        System.out.print("Enter Email Id: ");
        list.add(in.next());
        return list;
    }

    public void addContactDetail() {
        List listContactDetails = readContactDetail(false);//if not edit then it will take first name
        PersonContact objPersonContact = new PersonContact();
        objPersonContact.addPersonContact(listContactDetails);
        contactDetailsList.put((String) listContactDetails.get(0), objPersonContact);//add firstname and personContact object
    }

    public void editContactDetail(String firstName) {
        if (contactDetailsList.isEmpty()) {
            System.out.println("------NO RECORDS------");
            return;
        }
        if (contactDetailsList.containsKey(firstName)) {
            PersonContact newPersonContact = (PersonContact) contactDetailsList.get(firstName);//get value(object) from hashmap and convert Person contact object
            List editedPersonDetail = readContactDetail(true);//if true then it will not read first name
            newPersonContact.editPersonContactDetails(editedPersonDetail);
        } else {
            System.out.println("First name doesn't exist");
        }
    }

    public void deleteContactDetail(String firstName) {
        if (contactDetailsList.isEmpty()) {
            System.out.println("------NO RECORDS------");
            return;
        }
        if (contactDetailsList.containsKey(firstName)) {
            contactDetailsList.remove(firstName);//remove value(object) from hashmap and convert Person contact object
        } else {
            System.out.println("First name doesn't exist");
        }
    }

    //display contact details
    public void displayContactDetails() {
        if (contactDetailsList.isEmpty()) {
            System.out.println("------NO RECORDS------");
            return;
        }
        for (String key : contactDetailsList.keySet()) {
            PersonContact newPersonContact = (PersonContact) contactDetailsList.get(key);
            System.out.println("--------------------------");
            newPersonContact.displayPersonContactDetails();
            System.out.println("--------------------------");
        }
    }
}
