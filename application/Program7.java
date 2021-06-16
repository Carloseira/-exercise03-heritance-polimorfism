package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program7 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		List<TaxPayer> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = input.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char answer = input.next().charAt(0);
			System.out.print("Name: ");
			input.nextLine();
			String name = input.nextLine();
			System.out.print("Anual income: ");
			double anualIncome = input.nextDouble();
			if (answer == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = input.nextDouble();
				list.add(new Individual(name, anualIncome, healthExpenditures));
			}
			else {
				System.out.print("Number of employees: ");
				int numberOfEmployees = input.nextInt();
				list.add(new Company(name, anualIncome, numberOfEmployees));
			}
		}
		System.out.println();
		System.out.println("-------------TAXES PAID:-------------");
		for (TaxPayer tp : list) {
			System.out.println(tp.getName() + ": $" + String.format("%.2f", tp.taxPaid()));
		}
		double sum = 0.0;
		for (TaxPayer tp : list) {
			sum += tp.taxPaid();
		}
		System.out.println();
		System.out.println("TOTAL TAXES: $" + String.format("%.2f", sum));	
		input.close();
	}
}
