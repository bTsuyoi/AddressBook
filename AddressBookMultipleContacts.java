import java.util.Scanner;
public class AddressBookMultipleContacts {
	public static final int MAX_CONTACTS_LIMIT = 10;

    public String firstName, lastName, address, city, state;
    public int zip, phoneNumber;

    public AddressBookMultipleContacts(String firstName, String lastName, String address, String city, String state, int zip,
            int phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
    }

    public void displayContact() {
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Address: " + address);
        System.out.println("City: " + city);
        System.out.println("State: " + state);
        System.out.println("Zip Code: " + zip);
        System.out.println("Phone Number: " + phoneNumber + "\n");
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        int choice = 2;
        AddressBookMultipleContacts addressBook[] = new AddressBookMultipleContacts[MAX_CONTACTS_LIMIT];
        while (i < MAX_CONTACTS_LIMIT) {
            System.out.println("Choice: 1] Add Contact 2] Display Contacts 3] Exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(
                            "Please Write in Format.\nFirst_Name Last_Name Adderss City State Zip Phone_Number");
                    addressBook[i] = new AddressBookMultipleContacts(scanner.next(), scanner.next(), scanner.next(), scanner.next(),
                            scanner.next(), scanner.nextInt(), scanner.nextInt());
                    i++;
                    break;
                case 2:
                    for (int j = 0; j < i; j++) {
                        addressBook[j].displayContact();
                    }
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
    }
}
