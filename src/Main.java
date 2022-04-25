import com.sun.applet2.AppletParameters;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    static Scanner input = new Scanner(System.in);
    AddressBook ab = new AddressBook();
    static HashMap<String, AddressBook> dictAddressBook = new HashMap<>();//
    static Dictionary dictCity = new Hashtable<String, ArrayList<PersonDetails>>();
    static Dictionary dictState = new Hashtable<String, ArrayList<PersonDetails>>();

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

    static public void main(String[] args) {
        int ch;
        System.out.println("Welcome to Address Book");
        do {
            String bookName = "";
            AddressBook addressBook = new AddressBook();
            ch = inputInteger("1. Create New book\n2. Edit Existing book\n" +
                    "3. Edit Global Contact\n4. search by city \n5. search by state\n6.view by city\n7.view by State\n8.count by city\n9.count by State\n(0 to Close)");
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
                case 4:
                    searchPersonCity();
                    break;
                case 5:
                    searchPersonState();
                    break;
                case 6:
                    System.out.println("Enter City name");
                    String city = input.next();
                    viewPersonCity(city);
                    break;
                case 7:
                    System.out.println("Enter State name");
                    String state = input.next();
                    viewPersonState(state);
                    break;
                case 8:
                    System.out.println("Enter city name");
                    String cityToCount = input.next();
                    countPersonByCity(cityToCount);
                    break;
                case 9:
                    System.out.println("Enter state name");
                    String stateToCount = input.next();
                    countPersonByState(stateToCount);
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

    public static void searchPersonCity() {
        System.out.println("Enter City name");
        String city = input.next();
        dictAddressBook.values().forEach(book -> book.listContactDetails.stream().filter(person -> person.getCity().equals(city.toLowerCase())).forEach(System.out::println));
    }

    public static void searchPersonState() {
        System.out.println("Enter State name");
        String state = input.next();
        dictAddressBook.values().forEach(book -> book.listContactDetails.stream().filter(person -> person.getState().equals(state.toLowerCase())).forEach(System.out::println));

    }

    public static void viewPersonCity(String city) {
        try {
            ArrayList<PersonDetails> personDetails = (ArrayList<PersonDetails>) dictCity.get(city);
            personDetails.forEach(System.out::println);
        } catch (NullPointerException ne) {
            System.out.println("--------No Record Found---------");
        }
    }

    public static void viewPersonState(String state) {
        try {
            ArrayList<PersonDetails> personDetails = (ArrayList<PersonDetails>) dictState.get(state);
            personDetails.forEach(System.out::println);
        } catch (NullPointerException ne) {
            System.out.println("--------No Record Found---------");
        }

    }

    public static void countPersonByCity(String city) {
        try {
            ArrayList<PersonDetails> personDetails = (ArrayList<PersonDetails>) dictCity.get(city);
            int count = (int) personDetails.stream().count();
            System.out.println("city: " + city + " are " + count);
        } catch (NullPointerException ne) {
            System.out.println("--------No Record Found---------");
        }
    }

    public static void countPersonByState(String state) {
        try {
            ArrayList<PersonDetails> personDetails = (ArrayList<PersonDetails>) dictState.get(state);
            int count = (int) personDetails.stream().count();
            System.out.println("city: " + state + " total record found: " + count);
        } catch (NullPointerException ne) {
            System.out.println("--------No Record Found---------");
        }
    }
}



