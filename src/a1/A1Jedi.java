package a1;

import java.util.Scanner;


public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

int count = scan.nextInt();

		
		String[][] nameAndPrice = new String[count][4];
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < 2; j++) {
				if (j == 0) {
					nameAndPrice[i][j] = scan.next();
				} else {
					nameAndPrice[i][j] = String.format("%.2f", scan.nextDouble());
				}	
			}
		}
		for (int i =  0; i < count; i++) {
			nameAndPrice[i][2] = Integer.toString(0);
			nameAndPrice[i][3] = Integer.toString(0);
		}
		
		int numberOfCustomers = scan.nextInt();
		String[][] customerNames = new String[numberOfCustomers][3];
		double[] pricePaid = new double[numberOfCustomers];
		
		
		for (int i = 0; i < numberOfCustomers; i++) {
			String customerFirstName = scan.next();
			String customerLastName = scan.next();
			customerNames[i][0] = customerFirstName;
			customerNames[i][1] = customerLastName;
			
			
			int itemsBought = scan.nextInt();
			
			
			
			String[][] quantAndNameOfItem = new String[itemsBought][2];
			double total = 0;
			outer: for (int j = 0; j < itemsBought; j++) {
				quantAndNameOfItem[j][0] = Integer.toString(scan.nextInt());
				quantAndNameOfItem[j][1] = scan.next();
				
				int local = Integer.parseInt(nameAndPrice[searchArrayIndex(nameAndPrice, quantAndNameOfItem[j][1])][3]);
				int z = Integer.parseInt(quantAndNameOfItem[j][0]);
				local = local + z;
				nameAndPrice[searchArrayIndex(nameAndPrice, quantAndNameOfItem[j][1])][3] = Integer.toString(local); 
				
				if (j > 0) {
					for (int l = 0; l < j; l++) {
						if (quantAndNameOfItem[j][1].equals(quantAndNameOfItem[l][1])) {
							continue outer;
						}
					}
				} 
				
				if (searchArrayBoolean(nameAndPrice, quantAndNameOfItem[j][1])) {
					int var = Integer.parseInt(nameAndPrice[searchArrayIndex(nameAndPrice, quantAndNameOfItem[j][1])][2]);
					var = var + 1;
					nameAndPrice[searchArrayIndex(nameAndPrice, quantAndNameOfItem[j][1])][2] = Integer.toString(var);
				}
				
				
				
	
				
				double price = A1Adept.searchArray(nameAndPrice, quantAndNameOfItem[j][1]);
				double rev = price * Double.parseDouble(quantAndNameOfItem[j][0]);
				total = total + rev;
			}
			pricePaid[i] = total;
			 
		}
		for (int i = 0; i < nameAndPrice.length; i++) {
			nameAndPrice[i][3] = " " + nameAndPrice[i][3];
		}
		
		for (int i = 0; i < nameAndPrice.length; i++) {
			System.out.println(changeToNo(nameAndPrice[i][2]) + " customers bought" + changeToNothing(nameAndPrice[i][3]) + " " + nameAndPrice[i][0]);
		}
		
	}
	
	static int searchArrayIndex(String[][] a, String b) {
		for (int i = 0; i < a.length; i++) {
			if (b.equals(a[i][0])) {
				return i;
			}
		}
		return 0;
}
	
	static boolean searchArrayBoolean(String[][] a, String b) {
		for (int i = 0; i < a.length; i++) {
			if (b.equals(a[i][0])) {
				return true;
			}
		}
		return false;
}
	

	
	static String changeToNothing(String a) {
		if (a.equals(" 0")) {
			return "";
		}
		return a;
	}
	
	static String changeToNo(String a) {
		if (a.equals("0")) {
			return "No";
		}
		return a;
	}
	static String changeToTwo(String a) {
		if (a.equals("4")) {
			a = "2";
			return a;
		}
		return a;
	}

}
