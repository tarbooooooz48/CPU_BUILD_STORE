package admin;


import java.util.*;

import cpuvs.Homepage;
import cpuvs.Recommend;
import data.*;
public class Admin extends Homepage{
	 String username ;
	 String password ;
	
//	private LinkedHashMap<String, String> hmAdminUserPass = new LinkedHashMap<>();
//	//setter
//	public void setter_Admin_User_Pass(HashMap<String, String> ref){
//		hmAdminUserPass.putAll(ref);
//	}
//	//getter
//	 public HashMap<String, String> getter_Admin_User_Pass(){
//		 return hmAdminUserPass;
//	 }
	 
	 
	public Admin(String username, String password) {

		this.username = username;
		this.password = password;
		
	}

	public boolean loginCheck() {
		Scanner sc = new Scanner(System.in);
		String username = null ,password = null;
		try {
		System.out.println("Enter username : ");
		 username = sc.nextLine();
	
		System.out.println("Enter Password : ");
		password= sc.nextLine();
		}
		
		catch(InputMismatchException ref) {
			System.err.println("Wrong input , Please try again...");
			loginCheck();
		}
		catch(Throwable ref) {
			System.err.println("Wrong input , Please try again...");
			loginCheck();
		}
		
		if((username.equals(this.username)) && (password.equals(this.password))) {
			return true;
		}else  {
			return false;
		}
		
		
		
	}
	public void manage_Admin() {
		System.out.println("--------------------ADMIN PAGE-------------------------------------");
		System.out.println();
		System.out.println("Enter 1 to remove account : ");
		System.out.println("Enter 2 to add a peripheral : ");
		System.out.println("Enter 3 to go to HOMEPAGE ");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		int tp = 0;
		try {
			tp = sc.nextInt();
		}
		catch(InputMismatchException ref) {
			System.out.println();
			System.err.println("Wrong input...\nPlease try again...");
			manage_Admin();
		}
		
		switch(tp) {
		case 1 :  //remove an account
			account_Admin();
			manage_Admin();
			break;
		case 2 :  //add peripheral
			add_peripherals();
			manage_Admin();
			break;
		case 3:
			Recommend rd = new Recommend();
			rd.loginP();
			break;
		default: 
				System.out.println();
				System.err.println("Invalid Option...\n Please try again...");
				System.out.println();
				break;
		}
		
	}
	
	public void account_Admin() {
			System.out.println("===================Remove Account===================");
		//linked list
	//	LinkedList<String> ll_Username = new LinkedList<>(ll_User);
	//	 LinkedList<String> ll_Password = new LinkedList<>(ll_Pass);
		 
		 if(ll_User.size() == 0) {
			 System.out.println();
			 System.err.println("There are no users signedIN in this store...");
			 manage_Admin();
		 } else {
			System.out.println();
		 System.out.println("Remove the account that you want to remove...\n Enter the option ");
		 System.out.println();
		 
		 for( int i = 0; i < ll_User.size();i++) {
			 System.out.println((i+1)+ "  "+ll_User.get(i)+"  "+ll_Pass.get(i));
			 System.out.println();
		 }
		 
		 Scanner sc =  new Scanner(System.in);
		 
		 
		 	if(ll_User.size() != 0) {
		 		
		 	
			 System.out.print("Enter your option OR do you wanna go back (press 0 to back): ");
			 try {
			 int remove_account_option = sc.nextInt();
			 
			 if(remove_account_option == 0) {
				
				
			 }else {
				 
			 
			 
			 ll_User.remove(ll_User.get(remove_account_option - 1));
			 ll_Pass.remove(ll_Pass.get(remove_account_option - 1));
			 
			 
			 
			 
//			 for( int i = 0; i < ll_User.size();i++) {
//				 System.out.println((i+1)+ "  "+ll_User.get(i)+"  "+ll_Pass.get(i));
//				 System.out.println();
//			 }
			 
			 System.out.println();
			 System.out.println("do you want to remove one more account (y for YES / any other key for NO) ?? ");
			 System.out.println();
			 char c = sc.next().charAt(0);
			 
			 if((c == 'y')||(c == 'Y')) {
				account_Admin();
			 }
			 }
			 }
			 catch(IndexOutOfBoundsException ref) {
				 System.out.println();
				 
				 System.err.println("Invalid Option...\nPlease try again...");
				 System.out.println();
				 account_Admin();
			 }
			 catch(InputMismatchException ref) {
				 System.out.println();
				 System.err.println("Wrong input...\nPlease try again...");
				 System.out.println();
				 account_Admin();
			 }
			 catch(Throwable ref) {
				 System.out.println();
				 System.err.println("Wrong input...\nPlease try again...");
				 System.out.println();
				 account_Admin();
			 }
		 	}
		 	
		 	else {
		 		System.out.println();
		 		System.err.println("There is not user SIGIN left...");
		 		System.out.println();
		 		
		 	}
		 }
		 
			
	}
	
	 //adding the peripherals
	
	 public void add_peripherals() {
		 	System.out.println("");
		 	System.out.println("===================ADD PERIPHERALS====================");
			System.out.println();
			System.out.println("Enter 1 for CPU processors :");
			System.out.println("Enter 2 for GPU :");
			System.out.println("Enter 3 for MotherBoard :");
			System.out.println("Enter 4 for RAM :");
			System.out.println("Enter 5 for Storage in TB(HDD) :");
			System.out.println("Enter 6 to go back : ");
			
			Scanner sc =  new Scanner(System.in);
			int tp = 0;
			try {
				tp = sc.nextInt();
			}
			catch(InputMismatchException ref) {
				System.out.println();
				System.err.println("Wrong input...\nPlease try again...");
				add_peripherals();
			}
			
			switch(tp) {
				
			
			case 1 :  //CPU
				String tempname = "";
				double tempprice = 0;
				
				//input
					System.out.println();
					System.out.println("Enter CPU name : ");
					sc.nextLine();
					tempname = sc.nextLine();
					System.out.println();
					System.out.println("Enter its price : ");
					tempprice = sc.nextDouble();
					
					tmcpuname.put(tempname, tempprice);
					
					add_peripherals();
				break;
			case 2 :  //GPU
				
				//input
				
				System.out.println();
				System.out.println("Enter GPU name : ");
				sc.nextLine();
				tempname = sc.nextLine();
				System.out.println();
				System.out.println("Enter its price : ");
				tempprice = sc.nextDouble();
				
				hmGpuname.put(tempname, tempprice);
				
				add_peripherals();
				
				break;
			case 3:  //MotherB
				
				//input
				
				System.out.println();
				System.out.println("Enter MotherBoard name : ");
				sc.nextLine();
				tempname = sc.nextLine();
				System.out.println();
				System.out.println("Enter its price : ");
				tempprice = sc.nextDouble();
				
				hmMotherBname.put(tempname, tempprice);
				
				add_peripherals();
				break;
			case 4 :   //RAM
				
				//input
				
				System.out.println();
				System.out.println("Enter RAM name : ");
				sc.nextLine();
				tempname = sc.nextLine();
				System.out.println();
				System.out.println("Enter its price : ");
				tempprice = sc.nextDouble();
				
				hmRam.put(tempname, tempprice);
				
				add_peripherals();
				break;
			case 5 : //Storage in TB
				
				//input
				
				System.out.println();
				System.out.println("Enter StorageinTB(HDD) name : ");
				sc.nextLine();
				tempname = sc.nextLine();
				System.out.println();
				System.out.println("Enter its price : ");
				tempprice = sc.nextDouble();
				
				hmStorageinTB.put(tempname, tempprice);
				
				add_peripherals();
				break;
			case 6 :   //go back
				break; 
			default: 
					System.out.println();
					System.err.println("Invalid Option...\n Please try again...");
					System.out.println();
					add_peripherals();
					break;
			}
	 }
	
	
	
}
