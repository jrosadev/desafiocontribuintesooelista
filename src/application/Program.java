package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {		
		Scanner sn = new Scanner(System.in);
		
		List<TaxPayer> payers = new ArrayList<>();
		
		System.out.print("Quantos contribuintes irá digitar? ");
		int n = sn.nextInt();
		
		System.out.println();
				
		for (int i=0; i<n; i++) {
			System.out.printf("Digite os dados do " + (i+1) + "º contribuinte");
			System.out.println();
			System.out.print("Renda anual com salário: R$");
			double salaryIncome = sn.nextDouble();
			System.out.print("Renda anual com prestação de serviço: R$");
			double servicesIncome = sn.nextDouble();
			System.out.print("Renda anual com ganho de capital: R$");
			double capitalIncome = sn.nextDouble();
			System.out.print("Gastos médicos: R$");
			double healthSpending = sn.nextDouble();
			System.out.print("Gastos educacionais: R$");
			double educationSpending = sn.nextDouble();
			System.out.println();
		
			payers.add(new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending));
		}
		
		for (TaxPayer contributor : payers) {			
			System.out.printf("Relatório do " + (payers.indexOf(contributor)+1) + "º contribuinte");
			System.out.println();
			System.out.printf("Imposto bruto total: R$%.2f%n", contributor.grossTax());
			System.out.printf("Abatimento: R$%.2f%n", contributor.taxRebate());
			System.out.printf("Imposto devido: R$%.2f%n", contributor.netTax());
			System.out.println();
		}
		
		sn.close();
	}
}
