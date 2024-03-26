package cpuvs;

import data.*;
import java.util.*;
import admin.*;

public class Recommend extends Peripherals{
		

	//budget price is gonna be static for price checking random
	static double chose_Price;
	
	//linkedlists for build buying
	static LinkedList<Double> ll_Recommended_price = new LinkedList<>();
	
	//for 
	public static ArrayList<Double> arr = new ArrayList<>();
	 
	 static {
			double temp = 45000.00;
			for(int j = 0; j < 9; j++) {
				arr.add(temp);
				temp += 7000.00;
			}
	 }
	
		public void takingBudget() {
			Collections.sort(arr);
			System.out.println();
			System.out.println("What would be your budget for the whole pc?? ");
			System.out.println();
			System.out.println("Enter 0 to go back ");
			
			Scanner sc =  new Scanner(System.in);
			double i = 0;
			try{
				 i = sc.nextDouble();
			} 
			catch(Throwable ref) {
				System.err.println("The input, you have entered is wrong...");
				System.err.println("Please try again");
				takingBudget();				
			}
			
			if(i == 0) {
				Options();
			}else if(i > arr.get(arr.size() - 1)) {
				System.out.println();
				System.err.println("That's too Overpriced, Please choose within Range : 45000 - 101000 ");
				System.out.println();
				//Collections.sort(arr);
				takingBudget();
			}
			else {
			
				//checking if it is within budget
//			System.out.println(arr.get(0));
				if(i >= arr.get(0)) {
					System.out.println("Yes, we have some build recommendations in this range");
					System.out.println();
					System.out.println("Following is the list..");
				
				}else {
					System.err.println("I am deeply sorry we dont have any build within this range..");
					System.err.println("Please try again..");
					takingBudget();
				}
				
				int count = 1;
			
				Collections.reverse(arr);//sorting the whole price array
				
			for( int j = 0; j < arr.size(); j++) {
				if(arr.get(j) <= i) {
					System.out.println(count+" Rs " + arr.get(j));
					count++;
				} 
			}
				
			System.out.println();
			System.out.println("Please choose your interested price : ");
			boolean x = true;
			int choosePrice = 0;
			while(x) {
			try{
				choosePrice = sc.nextInt();
				//arr.get(count - 1 - choosePrice);
				System.out.println();
				System.out.println("You chose Rs "+arr.get((arr.size() - count)+choosePrice ));
				System.out.println();
				chose_Price  = arr.get((arr.size() - count)+choosePrice );
				x = false;
			} 
			catch(IndexOutOfBoundsException ref) {
					System.err.println("Sorry, you have entered wrong option ..");
					System.err.println("Please try again...");
					//Collections.sort(arr);
					takingBudget();
			}
			
			catch(Throwable ref) {
				System.err.println("Sorry, you have entered wrong option ..");
				System.err.println("Please try again...");
				//Collections.sort(arr);
				takingBudget();
			}
				
			
			}
			
			random_Builds();
			
			}
		}
		
		
		public void random_Builds() {
			System.out.println("These would be the builds...");
			Random r1 = new Random();
			Random r2 = new Random();
			Random r3 = new Random();
			Random r4 = new Random();
			Random r5 = new Random();
			double tempprice = 0;
			int itr = 0;
			while(true) {
				tempprice = 0;
				
			int random_CPU = r1.nextInt(alCpuPrice.size() - 1);
				
				
			
			int random_GPU = r2.nextInt(alGpuPrice.size() - 1);
			

			int random_MotherB = r3.nextInt(alMotherBPrice.size() - 1);

			int random_Ram = r4.nextInt(alCpuPrice.size() - 1);
			

			int random_StorageinTB = r5.nextInt(alCpuPrice.size() - 1);
			
			
		
			tempprice = alCpuPrice.get(random_CPU) + alGpuPrice.get(random_GPU) + alMotherBPrice.get(random_MotherB) + alRamPrice.get(random_Ram) + alStorageinTBPrice.get(random_StorageinTB);
			
			//checking the budget value
			if((tempprice <= chose_Price )&&(tempprice >= chose_Price - 20000)) {
				System.out.println("========================= BUILD "+(itr+1)+" =========================");
				System.out.println("1. "+alCpuName.get(random_CPU)+"  Rs"+ alCpuPrice.get(random_CPU));
				System.out.println("2. "+alGpuName.get(random_GPU)+"  Rs"+ alGpuPrice.get(random_GPU));
				System.out.println("3. "+alMotherBName.get(random_MotherB)+"  Rs"+ alMotherBPrice.get(random_MotherB));
				System.out.println("4. "+alRamName.get(random_Ram)+"  Rs"+ alRamPrice.get(random_Ram));
				System.out.println("5. "+alStorageinTBName.get(random_StorageinTB)+"  Rs"+ alStorageinTBPrice.get(random_StorageinTB));
				System.out.println();
				System.out.println("---------------------------------------------------------");
				System.out.println();
				System.out.println("TOTAL : Rs"+tempprice);
				ll_Recommended_price.add(tempprice);
				itr++;
			} else {
				continue;
			}
			
			if(itr == 5) {
				break;
			}
			
			}
				
			//asking Options for choosing the build
			
			
			choose_build();
			
		}
		
		public void choose_build() {
			System.out.println();
			System.out.println("Enter your option for the build OR do you want to go back (Press 0 to go back) : ");
			Scanner sc = new Scanner(System.in);
			
			int i = 0;
			try {
			i = sc.nextInt();
			
			
			if(i == 0) {
				ll_Recommended_price.clear();  //to remove the prices in the array
				//Collections.sort(arr);    //sorting the array as it is being reversed each time the taking_budget() method is called perfectly
				takingBudget();
			}else {
			Payout p_random_build = new Payout(ll_Recommended_price.get(i-1));
			
			p_random_build.display();
			}
			}
			catch(InputMismatchException ref) {
				System.out.println();
				System.err.println("Wrong input");
				System.out.println();
				choose_build();
			}
			catch(IndexOutOfBoundsException ref) {
				System.out.println();
				System.err.println("Wrong input");
				System.out.println();
				choose_build();
			}
			catch(Throwable ref) {
				System.out.println();
				System.err.println("Wrong input");
				System.out.println();
				choose_build();
			}
		}
	
}	
