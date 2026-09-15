package version2;

public class BasePlusCommissionEmployee {
    private int empID;
    private Name empName;
    private double totalSale;
    private double baseSalary;
    private MyDate birthDate;
    private MyDate dateHired;

    public BasePlusCommissionEmployee(){
        this.empID = 0;
        this.empName = new Name();
        this.totalSale = 0.0;
        this.baseSalary = 0.0;
        this.birthDate = new MyDate();
        this.dateHired = new MyDate();
    }

    public BasePlusCommissionEmployee(int empID, Name empName){
        this.empID = empID;
        this.empName = empName;
        this.totalSale = 0.0;
        this.baseSalary = 0.0;
        this.birthDate = new MyDate();
        this.dateHired = new MyDate();
    }

    public BasePlusCommissionEmployee(int empID, Name empName, double totalSale, double baseSalary){
        this.empID = empID;
        this.empName = empName;
        this.totalSale = totalSale;
        this.baseSalary = baseSalary;
        this.birthDate = new MyDate();
        this.dateHired = new MyDate();
    }

    public BasePlusCommissionEmployee(int empID, Name empName, double totalSale, double baseSalary, MyDate birthDate, MyDate dateHired){
        this.empID = empID;
        this.empName = empName;
        this.totalSale = totalSale;
        this.baseSalary = baseSalary;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
    }

    public int getEmpID(){
        return empID;

    }
    public void setEmpID(int empID){
        this.empID = empID;
    }

    public Name getEmpName() {
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

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
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

    public double getCommissionRate() {
        if (totalSale < 50000) {
            return 0.05;
        } else if (totalSale < 100000) {
            return 0.10;
        } else if (totalSale < 500000) {
            return 0.15;
        } else {
            return 0.20;
        }
    }

    public double computeSalary() {
        return baseSalary + (totalSale * getCommissionRate());
    }

    public double computeSalary(int currentMonth) {
        double totalSalary = baseSalary + (totalSale * getCommissionRate());
        if (birthDate.getMonth() == currentMonth){
            totalSalary += 5000.00;
        }
        return totalSalary;
    }

    public void displayBasePlusCommissionEmployee() {
        System.out.printf("ID: %d | Name: %s | Total Sales: ₱%,.2f | Base Salary: ₱%,.2f%n",
                empID, empName, totalSale, baseSalary);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Base Plus Commission Employee [ID: ").append(empID)
                .append(", Name: ").append(empName)
                .append(", Base Salary: ₱").append(String.format("%,.2f", baseSalary))
                .append(", Sales: ₱").append(String.format("%,.2f", totalSale))
                .append(", Commission Rate: ").append(String.format("%.0f%%", getCommissionRate() * 100))
                .append(", Total Salary: ₱").append(String.format("%,.2f", computeSalary()))
                .append("]");
        return sb.toString();
    }
}
