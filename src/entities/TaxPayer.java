package entities;

public class TaxPayer {

	public double salaryIncome;
	public double servicesIncome;
	public double capitalIncome;
	public double healthSpending;
	public double educationSpending;

	public TaxPayer(double salaryIncome, double servicesIncome, double capitalIncome, double healthSpending,
			double educationSpending) {
		super();
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}
	

	public double getSalaryIncome() {
		return salaryIncome;
	}

	public double getServicesIncome() {
		return servicesIncome;
	}

	public double getCapitalIncome() {
		return capitalIncome;
	}

	public double getHealthSpending() {
		return healthSpending;
	}

	public double getEducationSpending() {
		return educationSpending;
	}

	public double salaryTax() {
		double salaryTax, monthlySalary = salaryIncome / 12;
		if (monthlySalary < 3000) {
			salaryTax = 0;
		} else if (monthlySalary >= 3000 && monthlySalary < 5000) {
			salaryTax = (salaryIncome * 10) / 100;
		} else {
			salaryTax = (salaryIncome * 20) / 100;
		}
		return salaryTax;
	}

	public double servicesTax() {
		if (servicesIncome > 0) {
			return (servicesIncome * 15) / 100;
		} else {
			return 0;
		}
	}

	public double capitalTax() {
		if (capitalIncome > 0) {
			return (capitalIncome * 20) / 100;
		} else {
			return 0;
		}
	}

	public double grossTax() {
		return salaryTax() + servicesTax() + capitalTax();
	}

	public double taxRebate() {
		double totalSpending = healthSpending + educationSpending;
		double percentage = (grossTax() * 30) / 100;
		if (totalSpending >= percentage) {
			return percentage;
		} else {
			return totalSpending;
		}
	}

	public double netTax() {
		return grossTax() - taxRebate();
	}

}
