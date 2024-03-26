package admin;

import java.util.*;

import cpuvs.Recommend;
import cpuvs.loginPage;
public class Payout extends loginPage{
		
		
	
	 LinkedList<String> name = new LinkedList<>();
	 LinkedList<Double> price = new LinkedList<>();
	 
	 double recommended_price;
	 
	 public Payout() {
		 
	 }
	 
	 //for custom build
	 
	public Payout(LinkedList<String> name,LinkedList<Double> price){
		this.name = name;
		this.price = price;
		display();
	}
	
	//for recommended build
	
	public Payout(double recommended_price) {
		this.recommended_price = recommended_price;
//		this.status = status;
	}
	
	
	public void display() {
		System.out.println("==================YOU CANNOT GO BACK BETWEEN TRANSACTION============================");
		System.out.println();
		double sum = 0;
		
		if(recommended_price == 0) {
		for(int i = 0 ; i < name.size();i++) {
			System.out.println((i+1)+"  "+ name.get(i)+"  Rs "+price.get(i));
			System.out.println();
			sum += price.get(i);
		}
	} 
		else {
		sum = recommended_price;
	}
		
		System.out.println();
		System.out.println("==========================TOTAL=============================");
		System.out.println("your total will be : Rs "+sum);
		
		
		//static status usage for login purpose
		while(true) {
		if( status == true) {
		System.out.println("Payment would be in the form of ?");
		System.out.println("Enter 1 for Cash ");
		System.out.println("Enter 2 for Upi");
		System.out.println();
		
		Scanner sc =  new Scanner(System.in);
		int pay_type_option = 0;
		
		try {
		 pay_type_option = sc.nextInt();
		}
		catch(InputMismatchException ref) {
			System.out.println();
			System.err.println("Wrong input...\nPlease try again...");
			System.out.println();
			display();
		}
		
		
		switch(pay_type_option) {
		case 1 :      // cash
			status = false;
			System.out.println("Thank you for shopping from our store...\nLOGGED OUT");
		
			//Recommend por = new Recommend();
			loginP();
			

			break;
		case 2 :          //UPI
			
			UPI();
			
			System.out.println("Thank you for shopping from our store...\nLOGGED OUT");
			
			//clearing cart
			name.clear();   price.clear();
			status = false;
//			Recommend porUPI = new Recommend();
			loginP();
			break;
			
		default:
				System.err.println("Invalid Option... \n Try Again...");
				display();
				break;
			
		}
		
		break;
		}
		else {
			System.err.println("Sorry, You haven't logged in this store...\n Please login or sign up...");
			
			System.out.println();
			loginP();
			status = true;
		}
		}
		
		
	}
	
	public void UPI() {
				System.out.println("======================UPI====================");
				System.out.println("Enter 1 for mobile number ");
				System.out.println("Enter 2 for UPI account ");
				System.out.println("Enter 3 to go back ");
				
				Scanner sc = new Scanner(System.in);
				int upi_option = 0;
				try {
				 upi_option = sc.nextInt();
				}
				catch(InputMismatchException ref) {
					System.out.println();
					System.err.println("Wrong input...\nPlease try again...");
					System.out.println();
					UPI();
				}
				switch(upi_option) {
				case 1: //mobile
					contactValidation();
					OTP();
					break;
				case 2 : //UPI account
					UPI_account_validation();
					break;
				case 3 :
					display();
					break;
					default: 
						System.err.println("Invalid option...\n Try Again...");
						UPI();
						break;
				}
				
				
	}
	
	public void contactValidation() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your contact details");
			long contact = 0;
			try {
		contact = sc.nextLong();
			    }
	
			catch(InputMismatchException ref) {
				
					System.err.println("Wrong input...\nPlease try again...");
	                   }
			
		if (contact > 999999999L && contact < 10000000000L) {
			System.out.println("Contact Valid");
		} else {
			System.err.println("Enter 10 digits number");
			contactValidation(); // method recursion
		}
	}
	
	public void OTP() {
		String otp = "";
		Random r = new Random();
		while (otp.length() < 6) {
			int n = r.nextInt(60);// ---> 0 to 122
			if ((n >= 48 && n <= 57)) {
				otp += (char) n;
			}
		}
		System.out.println(otp);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the above OTP");
		String input_otp = sc.nextLine();
		if (input_otp.equals(otp)) {
			System.out.println("Successful");
		} else {
			System.err.println("Try Again!!!");
			OTP();
		}
	}
	
	public void UPI_account_validation() {
		Scanner sc =  new Scanner(System.in);
		System.out.println("Enter Upi account : ");
	
		String user_account = sc.nextLine();
		
				
		if((user_account.endsWith("@okaxis.in")) ||(user_account.endsWith("@oksbi.in"))|| (user_account.endsWith("@okicici.in"))){
			
			System.out.println("Valid UPI Account...");
			System.out.println();
			//normal pin enter 
			while(true) {
			System.out.print("Please enter your UPI pin : ");
			String pin = sc.nextLine();
			if((pin.length() <= 6)&&(pin.length() >= 4)) break;
			
			System.err.println("pin should be within 4 - 6 digits...");
			}
			
		}else {
			System.out.println("Not a Valid UPI Account please try again...");
			UPI_account_validation();
		}
		
	}
}
