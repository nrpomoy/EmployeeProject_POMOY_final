package version1;

public class HourlyEmployee {
    private int empID;
    private String empName;
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee(){
        empID = 0;
        empName = null;
    }

    public HourlyEmployee(int empID, String empName){
        this.empID = empID;
        this.empName = empName;
        totalHoursWorked = 0;
        ratePerHour = 0;
    }

    public HourlyEmployee(int empID, String empName, float totalHoursWorked, double ratePerHour){
        this.empID = empID;
        this.empName = empName;
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {
        this.totalHoursWorked = totalHoursWorked;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    public double computeSalary(){
        double regularHours = 40.0;
        double overtime = 1.5;
        double totalSalary = 0;
        if(totalHoursWorked <= regularHours){
            return totalHoursWorked * ratePerHour;
        }
        if (totalHoursWorked > regularHours){
            double regularPay = regularHours * ratePerHour;
            double overtimePay = (totalHoursWorked - regularHours) * (ratePerHour * overtime);
            totalSalary = regularPay + overtimePay;
        }
        return 0;
    }

    public void displayHourlyEmployee() {
        System.out.printf("ID: %d | Name: %s | Hours: %.2f | Rate: ₱%.2f/hr%n",
                empID, empName, totalHoursWorked, ratePerHour);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hourly Employee [ID: ").append(empID)
                .append(", Name: ").append(empName)
                .append(", Hours: ").append(totalHoursWorked)
                .append(", Rate Per Hour: ").append(ratePerHour)
                .append(", Total Salary: ").append(computeSalary())
                .append("]");
        return sb.toString();
    }
}

