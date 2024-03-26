package cpuvs;

import java.util.*;
import java.util.Scanner;
import data.*;
import admin.*;
public class secpage extends loginPage {
	
	public static LinkedList<String> cartName = new LinkedList<>();
	public static LinkedList<Double> cartPrice = new LinkedList<>();

	
		public void Options() {
			System.out.println();
			System.out.println("=====================Browsing Page=====================");
			System.out.println();
			System.out.println("Enter 1 for recommendation " );
			System.out.println("Enter 2 for direct peripherals " );
			System.out.println("Enter 3 to go back(LOGOUT, if SIGNEDIN) ");
			System.out.println("Enter 4 to exit");
			
			Scanner sc =  new Scanner(System.in);
			int tp = 0;
			
			try {                  //exception
				tp = sc.nextInt();
			}
			catch(InputMismatchException ref) {
				System.out.println();
				System.err.println("Wrong input...\nPlease enter integers only...");
			}
			
			
			switch(tp) {
			case 1 :   //recommendation
				
				Recommend rd = new Recommend();
				rd.takingBudget();
				break;
			case 2 :    //custom build
				Peripherals pl = new Peripherals();
				
				pl.pagePeripheralOption();
				
				break;
			 
			case 3 : //go back
				System.out.println();
				System.out.println("Are you sure ?(your cart will be empty...)\nPress 'y' for YES or any other character/value  for NO...");
				cartName.clear(); cartPrice.clear();
				char c = '0';
				try {
				 c = sc.next().charAt(0);
				}
				catch(InputMismatchException ref) {
					
				}
				if((c == 'y')||(c == 'Y')) {
					status = false;
					loginP();
				}
				else {
					Options();
				}
				
					
				break;
			case 4 :
				System.exit(0);
				default :
					System.out.println();
					System.err.println("Incorrect Option");
					System.out.println();
					Options();
			}
				
			
		}
}
