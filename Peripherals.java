package data;
import java.util.*;
import admin.*;
import cpuvs.*;
public class Peripherals extends secpage{
//		String cpuname;
//		String gpuname;
//		String MotherBname;
//		String ram;
//		String storageinTB;
		
//		Recommend rp = new Recommend();

		
		public void pagePeripheralOption() {
//			inputAllPeripherals();
			Scanner sc  =  new Scanner(System.in);
			System.out.println("===================PERIPHERALS====================");
			System.out.println();
			System.out.println("Enter 1 for CPU processors :");
			System.out.println("Enter 2 for GPU :");
			System.out.println("Enter 3 for MotherBoard :");
			System.out.println("Enter 4 for RAM :");
			System.out.println("Enter 5 for Storage in TB(HDD) :");
			System.out.println("Enter 6 to access cart : ");
			System.out.println("Enter 7 to go back ");
			System.out.println();
			int tp = 0;
			
			try {
			 tp = sc.nextInt();
			
			
			switch(tp) {
			case 1 :
				int temp = 1;
				System.out.println("----------------------------------------");
						System.out.println();
					for(Object obj : tmcpuname.keySet()) {
						System.out.println(" "+ temp +"  "+ obj+"   Rs "+ alCpuPrice.get(temp - 1));
						temp++;
					}
					System.out.println();
					System.out.println("---------------------------------------------");
					filling_Cart(tmcpuname);
					break;
			case 2 : 
				temp = 1;
				System.out.println("----------------------------------------");
				System.out.println();
				for(Object obj : hmGpuname.keySet()) {
					System.out.println(" "+ temp +"  "+ obj+"   Rs "+ alGpuPrice.get(temp - 1));
					temp++;
				}
				System.out.println();
				System.out.println("---------------------------------------------");
				filling_Cart(hmGpuname);
				break;
				
			case 3 :
				temp = 1;
				System.out.println("----------------------------------------");
				System.out.println();
				for(Object obj : hmMotherBname.keySet()) {
					System.out.println(" "+ temp +"  "+ obj+"   Rs "+ alMotherBPrice.get(temp - 1));
					temp++;
				}
				System.out.println();
				System.out.println("---------------------------------------------");
				filling_Cart(hmMotherBname);
				break;
			case 4 :
				temp = 1;
				System.out.println("----------------------------------------");
				System.out.println();
				for(Object obj : hmRam.keySet()) {
					System.out.println(" "+ temp +"  "+ obj+"   Rs "+ alRamPrice.get(temp - 1));
					temp++;
				}
				System.out.println();
				System.out.println("---------------------------------------------");
				filling_Cart(hmRam);
				break;
			case 5 :
				temp = 1;
				System.out.println("----------------------------------------");
				System.out.println();
				for(Object obj : hmStorageinTB.keySet()) {
					System.out.println(" "+ temp +"  "+ obj+"   Rs "+ alStorageinTBPrice.get(temp - 1));
					temp++;
				}
				System.out.println();
				System.out.println("---------------------------------------------");
				filling_Cart(hmStorageinTB);
				
				break;
			case 6 :  //cart
				display_Cart();
				break;
			case 7 : //go back
				Recommend rp = new Recommend();
				rp.Options();
				
				break;
				
			default:
					System.out.println();
					System.err.println("Invalid input...\n Try again...");
					System.out.println();
					pagePeripheralOption();
						break;
					
			}
			}
			catch(InputMismatchException ref) {
				System.out.println();
				System.err.println("wrong input...\nPlease try again...");
				System.out.println();
				pagePeripheralOption();
			}
			catch(IndexOutOfBoundsException ref) {
				System.out.println();
				System.err.println("wrong input...\nPlease try again...");
				System.out.println();
				pagePeripheralOption();
			}
			catch(Throwable ref) {
				System.out.println();
				System.err.println("wrong input...\nPlease try again...");
				System.out.println();
				pagePeripheralOption();
			}

		}
		
		
		public void filling_Cart(LinkedHashMap<String, Double> ref) {
			
			LinkedHashSet<String> lhsName = new LinkedHashSet<>(ref.keySet());
			
			LinkedHashSet<Double> lhsPrice = new LinkedHashSet<>(ref.values());
			
			
			//temp values

			
			
			System.out.println();
			System.out.println("Enter your choice : ");
			Scanner sc = new Scanner(System.in);
			int i = 0;
			try {
			  i = sc.nextInt();
			
			
		
			//fetching name
			Iterator itrName = lhsName.iterator();
			for(int tp = 1; tp < i; tp++) {
				if(itrName.hasNext()) {
					itrName.next();
					}else {
						System.err.println("Invalid Option...");
						filling_Cart(ref);
					}
			}
			String fetched_name = (String)itrName.next(); 
			
			
			//fetching value
			
		
			
			Iterator itrPrice = lhsPrice.iterator();
			for(int tp = 1; tp < i; tp++) {
				
				if(itrPrice.hasNext()) {
				itrPrice.next();
				}
				else {
					System.err.println("Invalid Option...");
					filling_Cart(ref);
				}
				
			}
		
			
			double fetched_price = (double) itrPrice.next();			
			
			cartName.add(fetched_name); cartPrice.add(fetched_price);
			
			}
			catch(InputMismatchException ref1) {
				System.out.println();
				System.err.println("wrong input...\nPlease try again...");
				System.out.println();
				filling_Cart(ref);
			}
			catch(IndexOutOfBoundsException ref2) {
				System.out.println();
				System.err.println("wrong input...\nPlease try again...");
				System.out.println();
				filling_Cart(ref);
			}
			catch(Throwable ref3) {
				System.out.println();
				System.err.println("wrong input...\nPlease try again...");
				System.out.println();
				filling_Cart(ref);
			}
			
	
			
			pagePeripheralOption();
		}
		
		
		
		public void display_Cart() {
			System.out.println();
			System.out.println("=========================CART================================");
			System.out.println();
			
		
			

			LinkedList<String>llName = new LinkedList<>(cartName);
			LinkedList<Double>llPrice = new LinkedList<>(cartPrice);
			
			if(llName.size() == 0) {
				System.out.println();
				System.err.println("YOUR CART IS EMPTY..\nPlease fill the cart...");
				System.out.println();
				pagePeripheralOption();
			}
			else {
			double price_total = 0;
			for(int i = 0 ; i < llName.size();i++) {
				System.out.println((i+1)+"  "+ llName.get(i)+"  Rs"+llPrice.get(i));
				System.out.println();
				price_total += llPrice.get(i);
				
			}
			
			System.out.println("Total : Rs "+price_total);
			System.out.println("===========================================================");
			
			System.out.println("Enter 1 for proceeding to payout...");
			System.out.println("Enter 2 to go back...");
			System.out.println("Enter 3 to remove an item ");
			
			
			//for deleting the val
			Scanner sc = new Scanner(System.in);
			int i = sc.nextInt();
			switch(i) {
			case 1 :
				Payout po = new Payout(llName, llPrice);

				cartName.clear(); cartPrice.clear();
				
				break;
			case 2 : //goback
				pagePeripheralOption();
				break;
			case 3:
				delete(llName, llPrice);
				break;
				default: 
					System.err.println("Invalid Option...\n Try again...");
					display_Cart();
					break;
			}
			
			}
				
		}
		
		
		public void delete(LinkedList<String> name, LinkedList<Double> price) {
			System.out.println("-----------------------------------------------------------");
			System.out.println();
			System.out.println("Select the option you want to delete ");
			Scanner sc = new Scanner(System.in);
			int del_Option = 0;
			
			if(name.size() == 0) {
				display_Cart();
			}else {
			try {
			 del_Option  = sc.nextInt();
			
			
			cartName.remove(name.get(del_Option - 1));
			cartPrice.remove(price.get(del_Option - 1));
			}
			catch(InputMismatchException ref) {
				System.out.println();
				System.err.println("Wrong input...\n Please try again...");
				System.out.println();
				delete(name, price);
			}
			catch(IndexOutOfBoundsException ref) {
				System.out.println();
				System.err.println("Wrong input...\nplease try again...");
				System.out.println();
				delete(name,price);
			}
			display_Cart();
			}
		}
		
		
}
