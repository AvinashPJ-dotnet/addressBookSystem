import java.util.*;

public class Main {
    static Scanner input = new Scanner(System.in);
    static Dictionary<String, AddressBook> dictAddressBook = new Hashtable<>();

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
        Enumeration<String> key = dictAddressBook.keys();
        while (key.hasMoreElements()) {
            System.out.println(key.nextElement());
        }
    }
    public static void displayNames(AddressBook addressBook) {
        System.out.print("First Names: ");
        for (PersonDetails objPerson: addressBook.listContactDetails
             ) {
            System.out.print(objPerson.getFirstName()+", ");
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
        char ch;
        System.out.println("Welcome to Address Book");
        do {
            String bookName = "";
            AddressBook addressBook = new AddressBook();
            ch = inputChar("Want Create new book(Y/N)(X to Close)");
            switch (ch) {
                case 'Y':
                    bookName = inputString("Enter New Address Book Name: ");
                    dictAddressBook.put(bookName, addressBook);
                    userOperation(bookName, addressBook);
                    break;

                case 'N':
                    if (!dictAddressBook.isEmpty()) {
                        displayBooks();
                        bookName = inputString("Enter Address Book Name to Access: ");
                        addressBook = dictAddressBook.get(bookName);
                        userOperation(bookName, addressBook);
                    } else {
                        System.out.println("No Address Books are present");
                    }
                    break;
            }
        } while (ch != 'X');
    }
}
