package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int count = scan.nextInt();

		
		String[][] nameAndPrice = new String[count][2];
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < 2; j++) {
				if (j == 0) {
					nameAndPrice[i][j] = scan.next();
				} else {
					nameAndPrice[i][j] = String.format("%.2f", scan.nextDouble());
				}	
			}
		}
		
		int numberOfCustomers = scan.nextInt();
		String[][] customerNames = new String[numberOfCustomers][2];
		double[] pricePaid = new double[numberOfCustomers];
		
		
		for (int i = 0; i < numberOfCustomers; i++) {
			String customerFirstName = scan.next();
			String customerLastName = scan.next();
			customerNames[i][0] = customerFirstName;
			customerNames[i][1] = customerLastName;
			
			int itemsBought = scan.nextInt();
			
			String[][] quantAndNameOfItem = new String[itemsBought][2];
			double total = 0;
			for (int j = 0; j < itemsBought; j++) {
				quantAndNameOfItem[j][0] = Integer.toString(scan.nextInt());
				quantAndNameOfItem[j][1] = scan.next();
				double price = searchArray(nameAndPrice, quantAndNameOfItem[j][1]);
				double rev = price * Double.parseDouble(quantAndNameOfItem[j][0]);
				total = total + rev;
			}
			pricePaid[i] = total;
			 
		}
		
		System.out.println("Biggest: " + customerNames[findBiggestName(pricePaid)][0] + " " + customerNames[findBiggestName(pricePaid)][1] + " " + "(" + String.format("%.2f", findBiggestAmount(pricePaid)) + ")");
		System.out.println("Smallest: " + customerNames[findSmallestName(pricePaid)][0] + " " + customerNames[findSmallestName(pricePaid)][1] + " " + "(" + String.format("%.2f", findSmallestAmount(pricePaid)) + ")");
		System.out.println("Average: " + String.format("%.2f", findAverage(pricePaid)));
	}
		

	
	static double searchArray(String[][] a, String b) {
		for (int i = 0; i < a.length; i++) {
				if (b.equals(a[i][0])) {
					double output = Double.parseDouble(a[i][1]);
					return output;
			}
			
		}
		return 0;
	}
	
static double findBiggestAmount(double[] a) {
	double x = 0;
	for (int i = 0; i < a.length; i++) {
		if (a[i] > x) {
			x = a[i];
		}
	}
	return x;
	}


static int findBiggestName(double[] a) {
	double x = 0;
	for (int i = 0; i < a.length; i++) {
		if (a[i] > x) {
			x = a[i];
		}
	}
	for (int j = 0; j < a.length; j++) {
		if (Math.abs(x - a[j]) < .05) {
			return j;
		}
	}
	return 0;
	
	}

static double findSmallestAmount(double[] a) {
	double x = 1000000000;
	for (int i = 0; i < a.length; i++) {
		if (a[i] < x) {
			x = a[i];
		}
	}
	return x;
	}

static int findSmallestName(double[] a) {
	double x = 1000000000;
	for (int i = 0; i < a.length; i++) {
		if (a[i] < x) {
			x = a[i];
		}
	}
	for (int j = 0; j < a.length; j++) {
		if (Math.abs(x - a[j]) < .05) {
			return j;
		}
	}
	return 0;
	
	}
static double findAverage(double[] a) {
	double x = 0;
	for (int i = 0; i < a.length; i++) {
		x = x + a[i];
	}
	double average = x / a.length;
	return average;
}

}
	
	

