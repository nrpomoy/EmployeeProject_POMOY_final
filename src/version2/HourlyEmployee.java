package version2;

public class HourlyEmployee {
    private int empID;
    private Name empName;
    private float totalHoursWorked;
    private double ratePerHour;
    private MyDate birthDate;
    private MyDate dateHired;

    public HourlyEmployee(){
        empID = 0;
        empName = null;
        totalHoursWorked = 0;
        ratePerHour = 0;
        this.birthDate = new MyDate();
        this.dateHired = new MyDate();
    }

    public HourlyEmployee(int empID, Name empName){
        this.empID = empID;
        this.empName = empName;
        totalHoursWorked = 0;
        ratePerHour = 0;
        this.birthDate = new MyDate();
        this.dateHired = new MyDate();
    }

    public HourlyEmployee(int empID, Name empName, float totalHoursWorked, double ratePerHour){
        this.empID = empID;
        this.empName = empName;
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
        this.birthDate = new MyDate();
        this.dateHired = new MyDate();
    }

    public HourlyEmployee(int empID, Name empName, float totalHoursWorked, double ratePerHour, MyDate birthDate, MyDate dateHired){
        this.empID = empID;
        this.empName = empName;
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
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
        return totalSalary;
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

