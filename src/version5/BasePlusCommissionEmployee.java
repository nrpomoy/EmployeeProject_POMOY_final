package version5;

import java.util.Objects;

public class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary;

    public BasePlusCommissionEmployee() {
        super();
        this.baseSalary = 0.0;
    }

    public BasePlusCommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, double totalSale, double baseSalary) {
        super(empID, empName, birthDate, dateHired, totalSale);
        setBaseSalary(baseSalary);
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary >= 0) {
            this.baseSalary = baseSalary;
        } else {
            this.baseSalary = 0.0;
        }
    }

    @Override
    public double computeSalary(int currentMonth) {
        double baseCommission = getTotalSale() * getCommissionRate();
        double totalSalary = this.baseSalary + baseCommission;

        if (getBirthDate() != null && getBirthDate().getMonth() == currentMonth) {
            totalSalary += 5000.00;
        }
        return totalSalary;
    }

    public void displayBasePlusCommissionEmployee() {
        super.displayEmployee();
        System.out.printf(" | Base Salary: ₱%.2f | Sales: ₱%.2f | Rate: %.0f%%%n",
                this.baseSalary, getTotalSale(), getCommissionRate() * 100);
    }

    @Override
    public String toString() {
        return String.format("BasePlusCommissionEmployee [ID: %d, Name: %s, Total Salary: ₱%,.2f]",
                getEmpID(), getEmpName(), computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        BasePlusCommissionEmployee other = (BasePlusCommissionEmployee) obj;
        return Double.compare(other.baseSalary, baseSalary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), baseSalary);
    }

    @Override
    public BasePlusCommissionEmployee clone() {
        return (BasePlusCommissionEmployee) super.clone();
    }
}