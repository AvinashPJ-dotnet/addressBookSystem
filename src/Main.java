import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice = 0;
        AddressBook addressBook = new AddressBook();
        System.out.println("Welcome to Address Book");
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("1. Add Person Details\n2. Display Details\n3. Edit Detail\n4. Delete Detail\n0. Exit");
            System.out.print("Enter Choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    addressBook.addContactDetail();
                    break;
                case 2:
                    addressBook.displayContactDetails();
                    break;
                case 3:
                    System.out.print("Enter First Name: ");
                    String fNameEdit = input.next();
                    addressBook.editContactDetail(fNameEdit);
                    break;
                case 4:
                    System.out.print("Enter First Name to delete: ");
                    String fNameDelete = input.next();
                    addressBook.deleteContactDetail(fNameDelete);
                    break;
                default:
                    System.out.println("Invalid input...");
            }

        } while (choice != 0);
    }
}
