import java.util.*;

public class Main {
    static Scanner input = new Scanner(System.in);
    static HashMap<String, AddressBook> dictAddressBook = new HashMap<>();

    public static String inputString(String message) {
        System.out.println(message);
        return input.next().toLowerCase();
    }

    public static int inputInteger(String message) {
        System.out.println(message);
        return input.nextInt();
    }

    public static char inputChar(String message) {
        System.out.println(message);
        return input.next().toUpperCase().charAt(0);
    }

    public static void displayBooks() {
        for (String books : dictAddressBook.keySet()) {
            System.out.println(books);
        }
    }

    public static void displayNames(AddressBook addressBook) {
        System.out.print("First Names: ");
        for (PersonDetails objPerson : addressBook.listContactDetails
        ) {
            System.out.print(objPerson.getFirstName() + ", ");
        }
        System.out.println();
    }

    public static void userOperation(String bookName, AddressBook addressBook) {
        int choice = 0;
        do {
            System.out.println("--------------------------");
            System.out.println("Accessing: " + bookName);
            System.out.println("1. Add Person Details\n2. Display Details\n3. Edit Detail\n4. Delete Detail\n0. Exit");
            choice = inputInteger("Enter Choice: ");
            switch (choice) {
                case 1:
                    assert addressBook != null;
                    addressBook.addContactDetail();
                    break;
                case 2:
                    addressBook.displayContactDetails();
                    break;
                case 3:
                    displayNames(addressBook);
                    String fNameEdit = inputString("Enter First Name: ");
                    addressBook.editContactDetail(fNameEdit);
                    break;
                case 4:
                    String fNameDelete = inputString("Enter First Name to delete: ");
                    addressBook.deleteContactDetail(fNameDelete);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid input...");
            }
        } while (choice != 0);
    }

    public static void main(String[] args) {
        int ch;
        System.out.println("Welcome to Address Book");
        do {
            String bookName = "";
            AddressBook addressBook = new AddressBook();
            ch = inputInteger("1. Create New book\n2. Edit Existing book\n3. Edit Global Contact\n(0 to Close)");
            switch (ch) {
                case 1:
                    bookName = inputString("Enter New Address Book Name: ");
                    dictAddressBook.put(bookName, addressBook);
                    userOperation(bookName, addressBook);
                    break;

                case 2:
                    if (!dictAddressBook.isEmpty()) {
                        displayBooks();
                        bookName = inputString("Enter Address Book Name to Access: ");
                        addressBook = dictAddressBook.get(bookName);
                        userOperation(bookName, addressBook);
                    } else {
                        System.out.println("No Address Books are present");
                    }
                    break;
                case 3:
                    if (!dictAddressBook.isEmpty()) {
                        String personName = inputString("Enter Person Name to edit: ");
                        editGlobalContact(personName);
                    } else {
                        System.out.println("No Address Books are present");
                    }
                    break;
            }
        } while (ch != 0);
    }

    public static void editGlobalContact(String personName) {
        boolean flag = false;
        for (AddressBook addressBook : dictAddressBook.values()) {
            for (PersonDetails listContactDetail : addressBook.listContactDetails
            ) {
                if (listContactDetail.getFirstName().equals(personName)) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                addressBook.editContactDetail(personName);
                break;
            }
        }
    }
}



