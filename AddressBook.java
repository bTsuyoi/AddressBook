
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class AddressBook
{
	public static Scanner sc = new Scanner(System.in);
	private String firstName,lastName, address, city, state, zip, phoneNumber, email;
	private  Map<Integer,Map> addressBook = new TreeMap<>();
	private  Map<String,String> contact = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
	static int entry=0;
	public void toCreateContact() {
		Map<String,String> contact = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		System.out.print("Enter the contact person details");
		System.out.print("\nEnter first name: ");
		firstName = sc.nextLine();
		firstName = sc.nextLine();
		System.out.print("Enter last name: ");
		lastName = sc.nextLine();
			
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
		addressBook.put(entry,contact);
		toShowContacts(entry);
	}
	public void toShowContacts(int e) {
		contact = addressBook.get(e);
		System.out.println("\nFirst Name: "+contact.get("First Name"));
		System.out.println("Last Name "+contact.get("Last Name"));
		System.out.println("Address: "+contact.get("Address"));
		System.out.println("City: "+contact.get("City"));
		System.out.println("State: "+contact.get("State"));
		System.out.println("Zip: "+contact.get("Zip"));
		System.out.println("Phone number: "+contact.get("Phone number"));
		System.out.println("Email: "+contact.get("Email"));
		
	}
	public void toEditContact() {
		Map<String,String> contact = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

		String first_Name, last_Name, field;
		int choice=1;
		System.out.println("Enter first name: ");
		first_Name=sc.next();
		System.out.println("Enter last name: ");
		last_Name=sc.next();
		String status="notfound";
		for (int i=1; i<=entry; i++) {
			contact = addressBook.get(i);
			System.out.println(contact);
			if(contact.get("First Name").equals(first_Name) && contact.get("Last Name").equals(last_Name)) {
				status="found";
				while(choice > 0 && choice < 9){
					toShowContacts(i);
					System.out.println("\n**edit contact**\n1. first name   2. last name");
					System.out.println("3. address      4. city");
					System.out.println("5. state        6. zip");
					System.out.println("7. phone number 8. email");
					System.out.println("0. exit");
											
					choice = sc.nextInt();
					sc.nextLine();	
					if(choice < 1 || choice > 8)
						break;
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

		String first_Name, last_Name, field;
		int choice=1;
		System.out.println("Enter first name: ");
		first_Name=sc.next();
		System.out.println("Enter last name: ");
		last_Name=sc.next();
		String status="notfound";
		for (int i=1; i<=entry; i++) {
			contact = addressBook.get(i);
			System.out.println(contact);
			if(contact.get("First Name").equals(first_Name) && contact.get("Last Name").equals(last_Name)) {
				status="found";
				addressBook.remove(i);	
				System.out.println("Contact Deleted");
			}
		}
		if(status.equals("notfound")) {
			System.out.println("Details not found.");
		}
	}
	
	public static void main(String[] args)	{
		int choice = 1;
		
		AddressBook addressBook = new AddressBook();
		System.out.println("***Welcome to Address Book Program***");
		
		while(choice != 4){
			System.out.println("\n1. Create new person contact\n2. Edit contact by name\n3. Delete Contact by name \n4. Exit");
			choice = sc.nextInt();
			switch(choice){
				case 1:
					addressBook.toCreateContact();
					break;
				case 2:
					addressBook.toEditContact();
					break;
				case 3:
					addressBook.toDeleteContact();
					break;
				case 4:
					System.out.println("Program is exited.");
					System.exit(0);
					break;
				default:		
					System.out.println("wrong choice");
			}
		}
		sc.close();
	}


}
	
