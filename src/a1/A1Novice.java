package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int customers = scan.nextInt();
		String[] firstNames = new String[customers];
		String[] lastNames = new String[customers];
		int[] numberOfItems = new int[customers];
		int[] quantityOfItems = new int[100000];
		String[] nameOfItem = new String[100000];
		double[] priceOfItem = new double[100000];
		int z = 0;
		String output = "";
		
		
		for (int i = 0; i < customers; i++) {
			firstNames[i] = scan.next();
			lastNames[i] = scan.next();
			numberOfItems[i] = scan.nextInt();
			double cost = 0;
			
			for (int j = 0; j < numberOfItems[i]; j++ ) {
				quantityOfItems[j + z] = scan.nextInt();
				nameOfItem[j + z] = scan.next();
				priceOfItem[j + z] = scan.nextDouble();
				cost = quantityOfItems[j + z] * priceOfItem[j + z] + cost;
			}
			output = convertToInitial(firstNames[i]) + ". " + lastNames[i] + ": " + String.format("%.2f", cost);
			System.out.println(output);
			z = numberOfItems[i] + z;
				
		}
		
			
}
	
	static String convertToInitial(String s) {
		String[] split = s.split("");
		return split[0];
	}
}
