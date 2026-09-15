package version2;

public class CommissionEmployee {
    private int empID;
    private Name empName;
    private double totalSale;
    private MyDate birthDate;
    private MyDate dateHired;

    public CommissionEmployee(){
        this.empID = 0;
        this.empName = new Name();
        this.totalSale = 0.0;
        this.birthDate = new MyDate();
        this.dateHired = new MyDate();
    }

    public CommissionEmployee(int empID, Name empName){
        this.empID = empID;
        this.empName = empName;
        this.totalSale = 0.0;
        this.birthDate = new MyDate();
        this.dateHired = new MyDate();
    }

    public CommissionEmployee(int empID, Name empName, double totalSale){
        this.empID = empID;
        this.empName = empName;
        this.totalSale = totalSale;
        this.birthDate = new MyDate();
        this.dateHired = new MyDate();
    }

    public CommissionEmployee(int empID, Name empName, double totalSale, MyDate birthDate, MyDate dateHired){
        this.empID = empID;
        this.empName = empName;
        this.totalSale = totalSale;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
    }

    public int getEmpID(){
        return empID;

    }
    public void setEmpID(int empID){
        this.empID = empID;
    }

    public Name getEmpName(){
        return empName;

    }
    public void setEmpName(Name empName){
        this.empName = empName;
    }

    public double getTotalSale(){
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        this.totalSale = totalSale;
    }

    public MyDate getBirthDate(){
        return birthDate;
    }

    public void setBirthDate(MyDate birthDate){
        this.birthDate = birthDate;
    }

    public MyDate getDateHired() {
        return dateHired;
    }

    public void setDateHired(MyDate dateHired) {
        this.dateHired = dateHired;
    }

    public double computeSalary() {
        double commissionRate = 0;
        if (totalSale < 50000) {
           commissionRate = 0.05;
        } else if (totalSale < 100000) {
            commissionRate = 0.10;
        } else if (totalSale < 500000) {
            commissionRate = 0.15;
        } else {
            commissionRate = 0.20;
        }
        return totalSale * commissionRate;
    }

    public double computeSalary(int currentMonth) {
        double commissionRate = 0;
        if (totalSale < 50000) {
            commissionRate = 0.05;
        } else if (totalSale < 100000) {
            commissionRate = 0.10;
        } else if (totalSale < 500000) {
            commissionRate = 0.15;
        } else {
            commissionRate = 0.20;
        }

        double totalSalary = totalSale * commissionRate;

        if (birthDate.getMonth() == currentMonth){
            totalSalary += 5000.00;
        }

        return totalSalary;
    }

    public void displayCommissionEmployee() {
        System.out.printf("ID: %d | Name: %s | Total Sales: ₱%,.2f%n",
                empID, empName, totalSale);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Commission Employee [ID: ").append(empID)
                .append(", Name: ").append(empName)
                .append(", Sales: ₱").append(String.format("%,.2f", totalSale))
                .append(", Total Salary: ₱").append(String.format("%,.2f", computeSalary()))
                .append("]");
        sb.append("Check for Bonus for Employee [ID: ").append(empID)
                .append(", Name: ").append(empName)
                .append(", Sales: ₱").append(String.format("%,.2f", totalSale))
                .append(", Total Salary: ₱").append(String.format("%,.2f", computeSalary()))
                .append("]");
        return sb.toString();
    }
}
