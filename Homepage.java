package cpuvs;
import java.util.*;
import java.util.Random;
import java.util.Scanner;

public class Homepage extends loginPage {
	
		private String name;
		private long contact ;
		private String email;
		private String username;
		private String password;
		private String cpassword;
		boolean b = false;
		

			
		//public static LinkedHashMap<String, String> hmUserPass = new LinkedHashMap<>();
		
//		public void InputofUserPassFromloginPage(HashMap<String, String> ref) {
//				hmUserPass.putAll(ref);
//		}
//		public HashMap<String , String> input() {
//			HashMap<String, String> hm = new HashMap<>();
//			hm.put(username , cpassword);
//			return hm;
//		}
		
		public void login() {
			Scanner sc = new Scanner(System.in);
			
				
			System.out.println("Enter username : ");
				String username = sc.nextLine();
				
				if (ll_User.contains(username)) {
					System.out.println("Valid");
				
				} else {
					System.err.println("Try again!!!");
					loginP();
				}
				//passkey validation
					int tempidx = 0;
					for( ; tempidx < ll_User.size();tempidx++) {
						if(username.equals(ll_User.get(tempidx))) {
							break;
						}
					}
				System.out.println("Enter your password : ");
			
				String cpassword = sc.nextLine();
				String tp = ll_Pass.get(tempidx);
				if (tp.equals(cpassword)) {
					System.out.println("Valid password");
					
				} else

				{
					System.err.println("Try again!!!");
					loginP();
				}
				
				status = true;
			}

	

//		public void passwordchecking() {
//			Scanner sc = new Scanner(System.in);
//			System.out.println("Enter the password to login");
//			String password = sc.nextLine();
//			if (password.equals(this.password)) {
//				System.out.println("Login Successful");
//				b = true;
//			} else {
//				System.err.println("Enter valid password");
//				login();
//			}
//		}

		public void signup() {
			Scanner sc = new Scanner(System.in);
			
			name_Validation();
			contactValidation();
			
			gmailValidation();
			username_Validation();
			
			passwordValidation();
			captcha();
			ll_User.add(this.username);
			ll_Pass.add(this.cpassword);
			
		}
		
		public void username_Validation() { 
			Scanner sc = new Scanner(System.in);
                   System.out.println("Enter your username : ");
			
               
			this.username = sc.nextLine();
			
			if(this.username == "") {
				System.out.println();
				System.err.println("Value couldn't be empty...");
				System.out.println();
				username_Validation();
				//throw new NoinputException();
			
			}
			if(ll_User.contains(this.username)){
					System.out.println();
					System.err.println("This username already exists...\n Please use different username...");
					System.out.println();
					username_Validation();
			}
		}
		
		public void name_Validation() {
			Scanner sc =  new Scanner(System.in);
			
			System.out.println("Enter your name");
			name = sc.nextLine();
			if(string_Validation(name) == false) {
				System.err.println("Wrong name entered...\nShould contain only a-z or A-Z characters");
				name_Validation();
			}
			
			
		}
		
		public boolean string_Validation(String ref) {
			for(int i = 0; i < ref.length() ;i++) {
			char c = ref.charAt(i);
			int n = (int) c;
			if (!((n >= 65 && n <= 90) || (n >= 97 &&  n <= 122))) {
				return false;
			}
			}
			
			return true;
		}
		
		//fetching username and password
//		public HashMap<String , String> SignUpfetchUserPass(){
//			 hmUserPass.put(this.username,this.cpassword);
//			 return hmUserPass;
//		}
		
		public void gmailValidation() {	
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your gmail id");
			email = sc.nextLine();
				if( email.length() == 0) {
					System.err.println("Sorry your gmail couldnt be empty.. ");
					System.err.println("Please try again...");
					this.email = sc.nextLine();
					gmailValidation();
				} else {
						
					/*
					String atRate = "@gmail.com";
					int temp = email.length() - atRate.length();
					for(int i = atRate.length() - 1; i >= 0; i--) {
						
						try {
						if(email.charAt(i+temp) != atRate.charAt(i)) {
							System.err.println("Sorry this is not a gmail account...");
							System.err.println("Please enter a gmail account...");
							
							gmailValidation();
							
						}
						}
						catch(Throwable ref) {
							System.out.println("Sorry this is not acceptable...");
							gmailValidation();
							break;
						}
							
						}    */
					
					if((email.endsWith("@gmail.com")) ||(email.endsWith("@yahoo.in"))){
								
						System.out.println("Valid email...");
						
					}else {
						System.out.println("Not a Valid email please try again...");
						gmailValidation();
					}
					}
				
			
				}
		
		public void captcha() {
			String captcha = "";
			Random r = new Random();
			while (captcha.length() < 6) {
				int n = r.nextInt(123);// ---> 0 to 122
				if ((n >= 65 && n <= 90) || (n >= 97 && n <= 122) || (n >= 48 && n <= 57)) {
					captcha = captcha + (char) n;
				}
			}
			System.out.println(captcha);
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the above captcha");
			String userCaptcha = sc.nextLine();
			if (captcha.equals(userCaptcha)) {
				System.out.println("SIGNIN Successful");
			} else {
				System.err.println("Try Again!!!");
				captcha();
			}
		}

		public void passwordValidation() {
			Scanner sc = new Scanner(System.in);
			
		
			System.out.println("Enter your password");
			this.password = sc.nextLine();
			System.out.println("Enter password to confirm");
			this.cpassword = sc.nextLine();
			
			
			if (this.password.equals(this.cpassword)) {
				System.out.println("Password Match");
			} else {
				System.err.println("Those passwords didn't match. Try Again!!");
				passwordValidation();
			}
		
		}

		public void contactValidation() {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your contact details");
			
			try {    //exception
			contact = sc.nextLong();
			}
			catch(InputMismatchException ref) {
				System.err.println("Wrong input...\nPlease try again...");
			}
			
			
			if (contact > 999999999L && contact < 10000000000L) {
				System.out.println();
				System.out.println("Contact Valid");
				System.out.println();
			} else {
				System.out.println();
				System.err.println("Please enter 10 digits number ");
				System.out.println();
				contactValidation(); // method recursion
			}
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public long getContact() {
			return contact;
		}

		public void setContact(long contact) {
			this.contact = contact;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getCpassword() {
			return cpassword;
		}

		public void setCpassword(String cpassword) {
			this.cpassword = cpassword;
		}



		

		
		
		
		
}
		
