package version2;

public class CommissionEmployee {
    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;
    private double totalSale;

    public CommissionEmployee() {
        this.empID = 0;
        this.empName = new Name();
        this.birthDate = new MyDate();
        this.dateHired = new MyDate();
        this.totalSale = 0.0;
    }

    public CommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
        this.totalSale = 0.0;
    }

    public CommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, double totalSale) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
        setTotalSale(totalSale);
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public Name getEmpName() {
        return empName;
    }

    public void setEmpName(Name empName) {
        this.empName = empName;
    }

    public MyDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(MyDate birthDate) {
        this.birthDate = birthDate;
    }

    public MyDate getDateHired() {
        return dateHired;
    }

    public void setDateHired(MyDate dateHired) {
        this.dateHired = dateHired;
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

    public double computeSalary() {
        double rate = 0.0;
        if (this.totalSale < 50000.00) {
            rate = 0.05;
        } else if (this.totalSale < 100000.00) {
            rate = 0.10;
        } else if (this.totalSale < 500000.00) {
            rate = 0.15;
        } else {
            rate = 0.20;
        }
        return this.totalSale * rate;
    }

    public double computeSalary(int currentMonth) {
        double salary = computeSalary();
        if (this.birthDate != null && this.birthDate.getMonth() == currentMonth) {
            salary = salary + 5000.00;
        }
        return salary;
    }

    public void displayCommissionEmployee() {
        System.out.printf("ID: %d | Name: %s | DOB: %s | Hired: %s | Total Sale: ₱%.2f%n",
                this.empID, this.empName, this.birthDate, this.dateHired, this.totalSale);
    }

    @Override
    public String toString() {
        return String.format("CommissionEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, Sales: ₱%.2f, Total Salary: ₱%.2f]",
                this.empID, this.empName, this.birthDate, this.dateHired, this.totalSale, computeSalary());
    }
}