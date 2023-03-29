// Assume that VIT Uty provides an option for faculty to choose 
// tax model of FY22-23 or 23-24. 
// Use hierarchical inheritance to calculate tax for a faculty 
// for the month of December. Accomplish runtime polymorphism also.

abstract class TaxModel {
    protected int baseSalary;

    public TaxModel(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public abstract double calculateTax(double income);
}

class FY22_23 extends TaxModel {
    public FY22_23(int baseSalary) {
        super(baseSalary);
    }

    @Override
    public double calculateTax(double income) {
        double tax = 0.0;
        if (income > 50000) {
            tax = (income - 50000) * 0.2;
        }
        return tax;
    }
}

class FY23_24 extends TaxModel {
    public FY23_24(int baseSalary) {
        super(baseSalary);
    }

    @Override
    public double calculateTax(double income) {
        double tax = 0.0;
        if (income > 75000) {
            tax = (income - 75000) * 0.25;
        }
        return tax;
    }
}

class Faculty {
    private final String name;
    private final TaxModel taxModel;

    public Faculty(String name, TaxModel taxModel) {
        this.name = name;
        this.taxModel = taxModel;
    }

    public double calculateTaxForMonth(double income) {
        return taxModel.calculateTax(income) / 12;
    }
}

public class FacultyTaxCalculator {
    public static void main(String[] args) {
        int baseSalary = 80000;
        Faculty faculty = new Faculty("Meena", new FY23_24(baseSalary));
        double income = baseSalary + 20000; // December income
        double tax = faculty.calculateTaxForMonth(income);
        System.out.printf("Tax for Meena in December: $%.2f\n", tax);
    }
}
