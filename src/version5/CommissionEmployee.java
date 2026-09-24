package version5;

import java.util.Objects;

public class CommissionEmployee extends Employee {
    private double totalSale;

    public CommissionEmployee() {
        super();
        this.totalSale = 0.0;
    }

    public CommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, double totalSale) {
        super(empID, empName, birthDate, dateHired);
        setTotalSale(totalSale);
    }

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        if (totalSale >= 0) {
            this.totalSale = totalSale;
        } else {
            this.totalSale = 0.0;
        }
    }

    public double getCommissionRate() {
        if (this.totalSale < 50000.00) {
            return 0.05;
        } else if (this.totalSale < 100000.00) {
            return 0.10;
        } else if (this.totalSale < 500000.00) {
            return 0.15;
        } else {
            return 0.20;
        }
    }

    @Override
    public double computeSalary(int currentMonth) {
        double commission = this.totalSale * getCommissionRate();

        if (getBirthDate() != null && getBirthDate().getMonth() == currentMonth) {
            commission += 5000.00;
        }
        return commission;
    }

    public void displayCommissionEmployee() {
        super.displayEmployee();
        System.out.printf(" | Total Sale: ₱%.2f | Rate: %.0f%%%n", this.totalSale, getCommissionRate() * 100);
    }

    @Override
    public String toString() {
        return String.format("CommissionEmployee [ID: %d, Name: %s, Total Salary: ₱%,.2f]",
                getEmpID(), getEmpName(), computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        CommissionEmployee other = (CommissionEmployee) obj;
        return Double.compare(other.totalSale, totalSale) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalSale);
    }

    @Override
    public CommissionEmployee clone() {
        return (CommissionEmployee) super.clone();
    }
}