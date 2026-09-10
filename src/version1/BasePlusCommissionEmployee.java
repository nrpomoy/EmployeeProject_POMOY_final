package version1;

public class BasePlusCommissionEmployee {
    private int empID;
    private String empName;
    private double totalSale;
    private double baseSalary;

    public BasePlusCommissionEmployee(){
        this.empID = 0;
        this.empName = "N/A";
        this.totalSale = 0.0;
        this.baseSalary = 0.0;
    }

    public BasePlusCommissionEmployee(int empID, String empName){
        this.empID = empID;
        this.empName = empName;
        this.totalSale = 0.0;
        this.baseSalary = 0.0;
    }

    public BasePlusCommissionEmployee(int empID, String empName, double totalSale, double baseSalary){
        this.empID = empID;
        this.empName = empName;
        this.totalSale = totalSale;
        this.baseSalary = baseSalary;
    }

    public int getEmpID(){
        return empID;

    }
    public void setEmpID(int empID){
        this.empID = empID;
    }

    public String getEmpName(){
        return empName;

    }
    public void setEmpName(String empName){
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
