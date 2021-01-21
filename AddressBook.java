
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class AddressBook
{
	public static Scanner sc = new Scanner(System.in);
	private String person="notfound";
	static String name;
	private String firstName,lastName, address, city, state, zip, phoneNumber, email;
	private  Map<String,Map> library = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
	private  Map<Integer,Map> addressBook = new TreeMap<>();
	private  Map<String,String> contact = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
	static int entry=0;
	
	public void toCheckPerson() {
		Map<String,String> contact = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		addressBook = library.get(name);
			for (int i=1; i<=addressBook.size(); i++) {
				contact = addressBook.get(i);
				if(contact.get("First Name").equals(firstName) && contact.get("Last Name").equals(lastName)) {
					person="found";
				}
				else {
					person="notfound";
				}
			}
	}
	
	public void toCreateContact() {
		try {
			Map<Integer,Map> addressBook = new TreeMap<>();
			addressBook = library.get(name);
			
			for(int i: addressBook.keySet()) {
				entry=1;
				person="check";
				contact = addressBook.get(i);
				if(entry<i) {
					entry=i;
				}
					
			}
			
		}
		catch(NullPointerException e) {
			entry=0;
			String person="notfound";
		}
		Map<String,String> contact = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		System.out.print("Enter the contact person details");
		System.out.print("\nEnter first name: ");
		firstName = sc.nextLine();
		firstName = sc.nextLine();
		System.out.print("Enter last name: ");
		lastName = sc.nextLine();
		if (person == "check") {
			
			toCheckPerson();
			if(person == "found") {
				System.out.println("\nDetails for this person already exists...");
				process();
			}
		}
		
		System.out.print("Enter address: ");
		address = sc.nextLine();
			
		System.out.print("Enter city: ");
		city = sc.nextLine();
			
		System.out.print("Enter state: ");
		state = sc.nextLine();
			
		System.out.print("Enter zip: ");
		zip = sc.nextLine();
			
		System.out.print("Enter phone number: ");
		phoneNumber = sc.nextLine();
			
		System.out.print("Enter email: ");
		email = sc.nextLine();
			
		contact.put("First Name", firstName); 
		contact.put("Last Name", lastName);
		contact.put("Address", address); 
		contact.put("City", city); 
		contact.put("State", state);
		contact.put("Zip", zip); 
		contact.put("Phone number", phoneNumber); 
		contact.put("Email", email);
		entry++;
		try {
			Map<Integer,Map> addressBook = new TreeMap<>();
			addressBook = library.get(name);
			addressBook.put(entry,contact);
			library.put(name,addressBook);
			toShowContacts();
		}
		catch(NullPointerException e) {
			Map<Integer,Map> addressBook = new TreeMap<>();
			addressBook.put(entry,contact);
			library.put(name,addressBook);
			toShowContacts();
		}
		
	}
	public void toShowContacts() {
		for(String m: library.keySet()) {
			System.out.println("------------"+m+"-------------");
			addressBook = library.get(m);
			for(int i: addressBook.keySet()) {
				contact = addressBook.get(i);
				System.out.println("------------Entry"+i+"--------------");
					System.out.println("\nFirst Name: "+contact.get("First Name"));
					System.out.println("Last Name "+contact.get("Last Name"));
					System.out.println("Address: "+contact.get("Address"));
					System.out.println("City: "+contact.get("City"));
					System.out.println("State: "+contact.get("State"));
					System.out.println("Zip: "+contact.get("Zip"));
					System.out.println("Phone number: "+contact.get("Phone number"));
					System.out.println("Email: "+contact.get("Email"));
			
			}
		}
	}
	public void toEditContact() {
		Map<String,String> contact = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		addressBook = library.get(name);
			String first_Name, last_Name, field;
			int choice=1;
			System.out.println("Enter first name: ");
			first_Name=sc.next();
			System.out.println("Enter last name: ");
			last_Name=sc.next();
			String status="notfound";
			for (int i=1; i<=addressBook.size(); i++) {
				contact = addressBook.get(i);
				if(contact.get("First Name").equals(first_Name) && contact.get("Last Name").equals(last_Name)) {
					status="found";
					while(choice > 0 && choice < 9){
						toShowContacts();
						System.out.println("\n**edit contact**\n1. first name   2. last name");
						System.out.println("3. address      4. city");
						System.out.println("5. state        6. zip");
						System.out.println("7. phone number 8. email");
						System.out.println("0. exit");
												
						choice = sc.nextInt();
						if(choice==0) {
							process();
							break;
							}
						sc.nextLine();	
						
						System.out.print("Enter field: ");
						
						field = sc.nextLine();	
											
						switch(choice){
							case 1:	contact.replace("First Name", field);
									break;
							case 2:	contact.replace("Last Name", field);													
									break;
							case 3:	contact.replace("Address", field);							
									break;
							case 4:	contact.replace("City", field);							
									break;
							case 5:	contact.replace("State", field);
									break;
							case 6:	contact.replace("Zip", field);
									break;
							case 7:	contact.replace("Phone number", field);
									break;
							case 8:	contact.replace("Email", field);
									break;
							case 0:	
									break;
							default:				
						}
					addressBook.put(i, contact);	
					}
				}
			}
			if(status.equals("notfound")) {
				System.out.println("Details not found.");
			}
		}
	public void toDeleteContact() {
		Map<String,String> contact = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		addressBook = library.get(name);
		String first_Name, last_Name, field;
		int choice=1;
		System.out.println("Enter first name: ");
		first_Name=sc.next();
		System.out.println("Enter last name: ");
		last_Name=sc.next();
		String status="notfound";
		for (int i=1; i<=addressBook.size(); i++) {
			contact = addressBook.get(i);
			if(contact.get("First Name").equals(first_Name) && contact.get("Last Name").equals(last_Name)) {
				status="found";
				addressBook.remove(i);	
				System.out.println("Contact Deleted");
				toShowContacts();
			}
		}
		if(status.equals("notfound")) {
			System.out.println("Details not found.");
		}
	}
	public void toCreateAddressBook() {
		System.out.println("Enter Address Book Name.");
		name=sc.next();
	}
	public void toChangeAddressBook() {
		System.out.println("\nAvailable AddressBooks are:");
		for(String m: library.keySet()) {
			System.out.println("\n"+m);
		}
		System.out.println("\nEnter the AddressBook you want to use:");
		name=sc.next();
	}
	public void process() {
		int choice = 1;
		while(choice != 4){
			System.out.println("\n1. Create new AddressBook.\n2. Change AddressBook\n3. Create new person contact in current AddressBook"
					+ "\n4. Edit contact by name in current AddressBook.\n5. Delete Contact by name in current addressBook\n6 Check people in State or City.\n7. Exit");
			choice = sc.nextInt();
			switch(choice){
				case 1:
					toCreateAddressBook();
					break;
				case 2:
					toChangeAddressBook();
					break;
				case 3:
					toCreateContact();
					break;
				case 4:
					toEditContact();
					break;
				case 5:
					toDeleteContact();
					break;
				case 6:
					toShowPeopleInCity_State();
					break;
				case 7:
					System.out.println("Program is exited.");
					System.exit(0);
					break;
				default:		
					System.out.println("wrong choice");
			}
		}
	}
	public void toShowPeopleInCity_State() {
		Map<String,String> contact = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		addressBook = library.get(name);
		String city=" ", state=" ";
		int choice=1;
		System.out.println("\n1. Check people in state \n2. Check people in city");
		choice=sc.nextInt();
		if(choice==1) {
			System.out.println("Enter State: ");
			state=sc.next();
		}
		else if(choice==2) {
			System.out.println("Enter City: ");
			city=sc.next();
		}
		else {
			System.out.println("No entries available.....");
		}
		
		String status="notfound";
		for(String m: library.keySet()) {
			addressBook = library.get(m);
			for(int i: addressBook.keySet()) {
				contact = addressBook.get(i);
				if(contact.get("City").equals(city) || contact.get("State").equals(state)) {
					System.out.println("\nFirst Name: "+contact.get("First Name"));
					System.out.println("Last Name "+contact.get("Last Name"));
				}
			}
		}
		
	}
	public static void main(String[] args)	{
		
		Map<String,Map> library = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		AddressBook addressBook = new AddressBook();
		System.out.println("***Welcome to Address Book Program***");
		System.out.println("Enter Address Book Name.");
		name=sc.next();
		addressBook.toCreateContact();
		addressBook.process();
		sc.close();
	}

		
}

