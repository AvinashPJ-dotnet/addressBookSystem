import java.util.*;

public class AddressBook {
    List<String> listFirstName = new ArrayList<>();
    List<PersonContact> listContactDetails = new ArrayList<>();

    @SuppressWarnings("rawtypes")//warning should be suppressed using this suppressWarning annotation
    public List readContactDetail() {
        List<String> list = new ArrayList<>();
        System.out.println("Enter Contact Details");
        System.out.println("----------------------");
        Scanner in = new Scanner(System.in);
        System.out.print("Enter First Name: ");
        list.add(in.next());
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

    @SuppressWarnings("rawtypes")
    public void addContactDetail() {
        List listReadContactDetails = readContactDetail();
        if (!listFirstName.contains((String) listReadContactDetails.get(0)))//check whether the first name exist
        {
            PersonContact objPersonContact = new PersonContact();
            objPersonContact.addOrEditPersonContact(listReadContactDetails);
            listFirstName.add((String) listReadContactDetails.get(0));
            listContactDetails.add(objPersonContact);
        } else {
            System.out.println("First Name already exist..");
        }
    }

    public void editContactDetail(String firstName) {
        if (listFirstName.isEmpty() || listContactDetails.isEmpty()) {
            System.out.println("------NO RECORDS------");
            return;
        }
        if (listFirstName.contains(firstName)) {
            int choice;
            int indexFirstName = listFirstName.indexOf(firstName);
            PersonContact newPersonContact = listContactDetails.get(indexFirstName);
            do {
                System.out.println("---------------------------");
                System.out.println("What you want to edit");
                System.out.println("1. First Name\n2. Last Name\n3. Address\n4. City\n5. State\n6. Zip\n7. Phone Number\n8. Email Id\n9. All\n0. Cancel\n");
                System.out.print("Enter choice: ");
                Scanner in = new Scanner(System.in);
                choice = in.nextInt();
                //use switch for edit specific details
                switch (choice) {
                    case 1:
                        System.out.println("Old: " + newPersonContact.getFirstName());
                        System.out.print("New: ");
                        String newFirstName = in.next();
                        newPersonContact.setFirstName(newFirstName);
                        listFirstName.set(indexFirstName, newFirstName);//change first name from list
                        break;

                    case 2:
                        System.out.println("Old: " + newPersonContact.getLastName());
                        System.out.print("New: ");
                        String newLastName = in.next();
                        newPersonContact.setLastName(newLastName);
                        break;
                    case 3:
                        System.out.println("Old: " + newPersonContact.getAddress());
                        System.out.print("New: ");
                        String newAddress = in.next();
                        newPersonContact.setAddress(newAddress);
                        break;
                    case 4:
                        System.out.println("Old: " + newPersonContact.getCity());
                        System.out.print("New: ");
                        String newCity = in.next();
                        newPersonContact.setCity(newCity);
                        break;
                    case 5:
                        System.out.println("Old: " + newPersonContact.getState());
                        System.out.print("New: ");
                        String newState = in.next();
                        newPersonContact.setState(newState);
                        break;
                    case 6:
                        System.out.println("Old: " + newPersonContact.getZip());
                        System.out.print("New: ");
                        String newZip = in.next();
                        newPersonContact.setZip(newZip);
                        break;
                    case 7:
                        System.out.println("Old: " + newPersonContact.getPhone());
                        System.out.print("New: ");
                        String newPhone = in.next();
                        newPersonContact.setPhone(newPhone);
                        break;
                    case 8:
                        System.out.println("Old: " + newPersonContact.getEmail());
                        System.out.print("New: ");
                        String newEmail = in.next();
                        newPersonContact.setEmail(newEmail);
                        break;
                    case 9:
                        List editedPersonDetail = readContactDetail();
                        newPersonContact.addOrEditPersonContact(editedPersonDetail);
                        listFirstName.set(indexFirstName, (String) editedPersonDetail.get(0));
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("invalid option....");
                        break;
                }
            } while (choice != 0);


        } else {
            System.out.println("First name doesn't exist");
        }
    }

    public void deleteContactDetail(String firstName) {
        if (listFirstName.isEmpty() || listContactDetails.isEmpty()) {
            System.out.println("------NO RECORDS------");
            return;
        }
        if (listFirstName.contains(firstName)) {
            int indexFirstName = listFirstName.indexOf(firstName);
            listContactDetails.remove(indexFirstName);
            listFirstName.remove(indexFirstName);
        } else {
            System.out.println("First name doesn't exist");
        }
    }

    //display contact details
    public void displayContactDetails() {
        if (listFirstName.isEmpty() || listContactDetails.isEmpty()) {//check list are empty or not
            System.out.println("------NO RECORDS------");
            return;
        }
        for (PersonContact objPerson : listContactDetails) {
            System.out.println("--------------------------");
            objPerson.displayPersonContactDetails();
            System.out.println("--------------------------");
        }
    }
}
