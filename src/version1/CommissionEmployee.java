package version1;

public class CommissionEmployee {
    private int empID;
    private String empName;
    private double totalSale;

    public CommissionEmployee(){
        this.empID = 0;
        this.empName = "N/A";
        this.totalSale = 0.0;
    }

    public CommissionEmployee(int empID, String empName){
        this.empID = empID;
        this.empName = empName;
        this.totalSale = 0.0;
    }

    public CommissionEmployee(int empID, String empName, double totalSale){
        this.empID = empID;
        this.empName = empName;
        this.totalSale = totalSale;
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
        return sb.toString();
    }
}
