package version3;

import java.util.Objects;

public class HourlyEmployee extends Employee {
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        super();
        this.totalHoursWorked = 0.0f;
        this.ratePerHour = 0.0;
    }

    public HourlyEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, float totalHoursWorked, double ratePerHour) {
        super(empID, empName, birthDate, dateHired);
        setTotalHoursWorked(totalHoursWorked);
        setRatePerHour(ratePerHour);
    }

    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {
        if (totalHoursWorked >= 0) {
            this.totalHoursWorked = totalHoursWorked;
        } else {
            this.totalHoursWorked = 0.0f;
        }
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(double ratePerHour) {
        if (ratePerHour >= 0) {
            this.ratePerHour = ratePerHour;
        } else {
            this.ratePerHour = 0.0;
        }
    }

    @Override
    public double computeSalary() {
        return computeSalary(-1);
    }

    @Override
    public double computeSalary(int currentMonth) {
        double basePay = 0.0;
        if (this.totalHoursWorked <= 40) {
            basePay = this.totalHoursWorked * this.ratePerHour;
        } else {
            double regularPay = 40 * this.ratePerHour;
            double overtimePay = (this.totalHoursWorked - 40) * (this.ratePerHour * 1.5);
            basePay = regularPay + overtimePay;
        }
        return basePay + super.computeSalary(currentMonth);
    }

    public void displayHourlyEmployee() {
        super.displayEmployee();
        System.out.printf("Hours: %.2f | Rate: ₱%.2f/hr%n", this.totalHoursWorked, this.ratePerHour);
    }

    @Override
    public String toString() {
        return String.format("HourlyEmployee %s | Hours: %.2f, Rate: ₱%.2f, Total Salary: ₱%.2f",
                super.toString(), this.totalHoursWorked, this.ratePerHour, computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        HourlyEmployee other = (HourlyEmployee) obj;
        return Float.compare(other.totalHoursWorked, totalHoursWorked) == 0 &&
                Double.compare(other.ratePerHour, ratePerHour) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalHoursWorked, ratePerHour);
    }

    @Override
    public HourlyEmployee clone() {
        return (HourlyEmployee) super.clone();
    }
}