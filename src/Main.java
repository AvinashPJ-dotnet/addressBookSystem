import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice=0;
        AddressBook addressBook = new AddressBook();
        System.out.println("Welcome to Address Book");
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("1. Add Person Details\n2. Display Details\n3. Edit Details\n0. Exit");
            System.out.println("Enter Choice");
            choice=input.nextInt();
            switch (choice) {
                case 1:
                    addressBook.addContactDetail();
                    addressBook.displayContactDetails();
                    break;
                case 2:
                    addressBook.displayContactDetails();
                    break;
                case 3:
                    System.out.print("Enter First Name");
                    String fName=input.next();
                    addressBook.editContactDetail(fName);
                    addressBook.displayContactDetails();
                    break;
            }

        } while (choice!=0);
    }
}
