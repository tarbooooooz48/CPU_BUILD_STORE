package cpuvs;

import java.util.*;

import admin.Admin;

public class loginPage implements LoginPageAbst {
	
	//login status
	public static boolean status = false;
	//temp value for status invoke
	public static int tp;
	
	//data manip
	
	 public static LinkedHashMap<String, Double> tmcpuname = new LinkedHashMap<>();
	 public static LinkedHashMap<String, Double> hmGpuname = new LinkedHashMap<>();
	 public static LinkedHashMap<String, Double> hmMotherBname = new LinkedHashMap<>();
	 public static LinkedHashMap<String, Double> hmRam = new LinkedHashMap<>();
	 public static LinkedHashMap<String , Double> hmStorageinTB = new LinkedHashMap<>();
	  
	  
	  
	static {
	tmcpuname.put("AMD Ryzen Threadripper PRO 7995WX" , 25000.0); //1
	tmcpuname.put("Intel Xeon w9-3495X Processor" , 23000.0); //2
	tmcpuname.put("AMD Ryzen Threadripper PRO 5995WX" , 21000.0); //3
	tmcpuname.put("Intel Core i5-13600K Processor" , 19000.0); //4
	tmcpuname.put("Intel Core i5 processor 14600K" , 17000.0); //5
	tmcpuname.put("AMD Ryzen 5 4500" , 15000.0); //6
	tmcpuname.put("AMD FX-8350" , 13000.0); //7
	tmcpuname.put("AMD Ryzen 5 2600" , 11000.0); //8
	tmcpuname.put("Intel Core i3-10100F Processor" , 9000.0); //9
	tmcpuname.put("Intel Core i7-7700 Processor" , 7000.0); //10
	
	
	//------------------------------------------------------------------------------------
	
	hmGpuname.put("NVIDIA RTX 4090",25000.00);
	hmGpuname.put("NVIDIA RTX 4080 Super",23000.00);
	hmGpuname.put("NVIDIA RTX 4080",21000.00);
	hmGpuname.put("AMD RX 7900 XTX",19000.00);
	hmGpuname.put("AMD RX 7900 XT",17000.00);
	hmGpuname.put("NVIDIA RTX 4070 Super",15000.00);
	hmGpuname.put("AMD Radeon RX 7900 GRE",13000.00);
	hmGpuname.put("NVIDIA RTX 4060Ti",11000.00);
	hmGpuname.put("AMD Radeon RX 6700 XT",9000.00);
	hmGpuname.put("Intel Arc A750",7000.00);
	
	//-------------------------------------------------------------------------------------
	hmMotherBname.put("MSI MPG Z690 Edge WiFi DDR4 Motherboard", 21000.0);
	hmMotherBname.put("MSI PRO Z790-P WiFi Motherboard", 19000.0);
	hmMotherBname.put("MSI B550M Pro-Vdh WiFi Gaming Motherboard", 17000.0);
	hmMotherBname.put("MSI B450 Gaming Plus MAXATX Gaming Motherboard", 15000.0);
	hmMotherBname.put("ASUS Prime B450M-A II DDR4 Micro ATX Motherboard", 13000.0);
	hmMotherBname.put("Gigabyte B450M DS3H WiFi MicroATX Motherboard", 11000.0);
	hmMotherBname.put("ASUS Prime H510M EmicroATX Motherboard", 9000.0);
	hmMotherBname.put("MSI PRO H610M E DDR4", 7000.0);
	hmMotherBname.put("Gigabyte H310M HDMI and VGA port Motherboard", 6500.0);
	hmMotherBname.put("Gigabyte B450M DS3H V2 Motherboard", 6000.0);

	//-------------------------------------------------------------------------------------
	
	hmRam.put("G.Skill Trident Z5 Neo RGB DDR5-6000",10000.0);
	hmRam.put("G.Skill Trident Z5 RGB DDR5-6000",9500.0);
	hmRam.put("Samsung DDR5-4800",9000.0);
	hmRam.put(" TeamGroup T-Force Xtreem ARGB DDR4-3600",8500.0);
	hmRam.put("Patriot Viper Steel DDR4-4400",8000.0);
	hmRam.put("Patriot Viper RGB DDR4-3600",7500.0);
	hmRam.put("Patriot Viper 4 DDR4-3400",7250.0);
	hmRam.put("Corsair Vengeance RGB Pro DDR4-3200",7000.0);
	hmRam.put("Patriot Viper Steel DDR4-3200",6500.0);
	hmRam.put("Patriot Viper Steel DDR4-3600",6000.0);
	
	//--------------------------------------------------------------------------------------
	
	hmStorageinTB.put(" Seagate IronWolf Pro 20TB HDD",11000.0);
	hmStorageinTB.put("WD Black 12TB HDD",10500.0);

	hmStorageinTB.put("WD Blue 10TB HDD",10000.0);
	hmStorageinTB.put("Seagate FireCuda 8TB HDD",9500.0);
	hmStorageinTB.put("WD Red Pro 8TB HDD",9000.0);
	hmStorageinTB.put("Toshiba N300 8TB HDD ",8750.0);
	hmStorageinTB.put("Seagate Exos X20 6TB HDD",8000.0);
	hmStorageinTB.put("WD Gold 4TB HDD",7000.0);
	hmStorageinTB.put("Seagate SkyHawk AI 2TB HDD",5000.0);
	hmStorageinTB.put("Seagate FireCuda 1TB HDD",4000.0);
	
	
	}
	
	
	//sets
	  
	  LinkedHashSet<Double> hsCpuPrice = new LinkedHashSet<>(tmcpuname.values());
	  LinkedHashSet<Double> hsGpuPrice = new LinkedHashSet<>(hmGpuname.values());
	  LinkedHashSet<Double> hsMotherBPrice = new LinkedHashSet<>(hmMotherBname.values());
	  LinkedHashSet<Double> hsRamPrice = new LinkedHashSet<>(hmRam.values());
	  LinkedHashSet<Double> hsStorageinTBPrice = new LinkedHashSet<>(hmStorageinTB.values());
	  
	  LinkedHashSet<String> hsCpuName = new LinkedHashSet<>(tmcpuname.keySet());
	  LinkedHashSet<String> hsGpuName = new LinkedHashSet<>(hmGpuname.keySet());
	  LinkedHashSet<String> hsMotherBName = new LinkedHashSet<>(hmMotherBname.keySet());
	  LinkedHashSet<String> hsRamName = new LinkedHashSet<>(hmRam.keySet());
	  LinkedHashSet<String> hsStorageinTBName = new LinkedHashSet<>(hmStorageinTB.keySet());
	  
	  //list
	public  LinkedList<Double> alCpuPrice = new LinkedList<>(hsCpuPrice);
	public   LinkedList<Double> alGpuPrice = new LinkedList<>(hsGpuPrice);
	 public LinkedList<Double> alMotherBPrice = new LinkedList<>(hsMotherBPrice);
	  public LinkedList<Double> alRamPrice = new LinkedList<>(hsRamPrice);
	 public LinkedList<Double> alStorageinTBPrice = new LinkedList<>(hsStorageinTBPrice);
	 
	 public LinkedList <String> alCpuName = new LinkedList<>(hsCpuName);
	 public LinkedList <String> alGpuName = new LinkedList<>(hsGpuName);
	 public LinkedList <String> alMotherBName = new LinkedList<>(hsMotherBName);
	 public LinkedList <String> alRamName = new LinkedList<>(hsRamName);
	 public LinkedList <String> alStorageinTBName = new LinkedList<>(hsStorageinTBName);
	
		//for user and pass store for login
	public static LinkedList<String> ll_User = new LinkedList<>();
	public static LinkedList<String> ll_Pass = new LinkedList<>();
		
	
	//welcome message
	
	static {
		System.out.println("===================================================================");
		System.out.println();
		System.out.println("               WELCOME TO COMPUTER BUILD STORE                   ");
		System.out.println();
		System.out.println("===================================================================");
		System.out.println();
	}
	
	@Override	  //from interface
	public void loginP() {
		System.out.println();
		System.out.println("=====================HOMEPAGE======================");
		System.out.println();
		System.out.println("Enter 1 to SIGNIN ");
		System.out.println("Enter 2 to LOGIN ");
		System.out.println("Enter 3 for direct browse ");
		System.out.println("Enter 4 to exit");
		
		Scanner sc =  new Scanner(System.in);
			int i = 0;
			try{
				 i = sc.nextInt();
			}
			catch(InputMismatchException ref) {
				System.out.println();
				System.err.println("Invalid Input...\nInput should be an integer");
				System.out.println();
				loginP();
			}
		
		Homepage pg = new Homepage();

			switch(i) {
			case 1 : //signup
				pg.signup();
				
			case 2 : //login
				
				//normal user or admin
				System.out.println();
				System.out.println("Enter 1 for admin login : ");
				System.out.println("Enter 2 for user login : ");
				System.out.println("Enter 3 to  go back : ");
				System.out.println();
				int temp = 0;
				try{
					 temp = sc.nextInt();
				}catch(InputMismatchException ref) {
					System.err.println("Wrong input..\nPlease inout integers only...");
					loginP();
				}
				
				tp = temp;
				
				switch(temp) {
				case 1 :  //admin
					
					Admin ad = new Admin("admin","admin");
					
					if(ad.loginCheck()) {
						System.out.println();
						System.out.println("Login successful...");
						System.out.println();
						ad.manage_Admin();
						loginP();
					} else {System.out.println();
						System.err.println("Wrong username or password...");
						System.out.println();
						loginP();
					}
				    
				    
					break;
				case 2 : //user
					if(status == false) {
					if(ll_User.size() != 0) {  //accessing static var through classname
						//pg.InputofUserPassFromloginPage(hm);
						pg.login();
					}
					else {
						System.err.println();
						System.out.println("There is no user signin in this store. ");
						System.out.println();
						loginP();
					}
					}
					else {
						pg.login();
						
						
					}
					break;
				case 3 : //go back
					loginP();
					break;
					default: 
						System.err.println("Invalid Option..");
					System.err.println("Try again...");
					loginP();
					break;
				}
				
				if(status == false) break;
				
			case 3 :  //direct browse
				//if(tp == 2) status = true;
					Recommend sp = new Recommend();
					sp.Options();
				break;
			case 4 : //exit
					System.exit(0);
				break;
				default:
					System.out.println();
					System.err.println("Invalid Option...\nPlease Try again...");
					System.out.println();
					loginP();
					break;
			}
			
			
			
//			Recommend rc = new Recommend();
//			rc.takingBudget();
		
		
	
	
	
	}
	
	
	
}
