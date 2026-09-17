package version4;

public class EmployeeRoster {
    private Employee[] empList;
    private int max;
    private int count;

    public EmployeeRoster(){
        this.max = 10;
        this.empList = new Employee[max];
        this.count = 0;
    }

    public EmployeeRoster(int max){
        this.max = max;
        this.empList = new Employee[this.max];
        this. count = 0;
    }

    public boolean addEmployee(Employee emp){
        if(count < max && emp != null){
            empList[count] = emp;
            count++;
            return true;
        } else {
            return false;
        }
    }

    public Employee removeEmployee(int empID){
        for(int i = 0; i < max; i++){
            if(empID == empList[i].getEmpID()){
                Employee removedEmployee = empList[i];

                for (int j = i; j < count - 1; j++) {
                    empList[j] = empList[j + 1];
                }

                empList[count - 1] = null;
                count--;
                return removedEmployee;
            }
        }
        return null;
    }

    public Employee searchEmployee(int empID){
        for(int i = 0; i < count; i++){
            if(empList[i].getEmpID() == empID){
                return empList[i];
            }
        }
        return null;
    }

    public int countHE(){
        int found = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof HourlyEmployee) {
                found++;
            }
        }
        return found;
    }

    public int countPWE(){
        int found = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof PieceWorkerEmployee) {
                found++;
            }
        }
        return found;
    }

    public int countCE(){
        int found = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i].getClass() == CommissionEmployee.class) {
                found++;
            }
        }
        return found;
    }

    public int countBPCE(){
        int found = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof BasePlusCommissionEmployee) {
                found++;
            }
        }
        return found;
    }

    public void displayHE(){
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof HourlyEmployee) {
                HourlyEmployee he = (HourlyEmployee) empList[i];
                he.displayHourlyEmployee();
            }
        }
    }

    public void displayPWE(){
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof PieceWorkerEmployee) {
                PieceWorkerEmployee pe = (PieceWorkerEmployee) empList[i];
                pe.displayPieceWorkerEmployee();
            }
        }
    }

    public void displayCE(){
        for (int i = 0; i < count; i++) {
            if (empList[i].getClass() == CommissionEmployee.class) {
                CommissionEmployee ce = (CommissionEmployee) empList[i];
                ce.displayCommissionEmployee();
            }
        }
    }

    public void displayBPCE(){
        for(int i = 0; i < count; i++){
            if(empList[i] instanceof BasePlusCommissionEmployee){
                BasePlusCommissionEmployee bpce = (BasePlusCommissionEmployee) empList[i];
                bpce.displayBasePlusCommissionEmployee();
            }
        }
    }

    public void displayAllEmployees() {
        System.out.printf("%-5s | %-20s | %-30s%n", "ID", "Name", "Type");
        System.out.println("-----------------------------------------------------------------");
        for (int i = 0; i < count; i++) {
            System.out.printf("%-5d | %-20s | %-30s%n",
                    empList[i].getEmpID(),
                    empList[i].getEmpName().toString(),
                    empList[i].getClass().getSimpleName());
        }
    }

    public void displayPayroll(int currentMonth) {
        for (int i = 0; i < count; i++) {
            Employee emp = empList[i];
            String typePrefix = "";
            double salary = 0;

            if (emp instanceof BasePlusCommissionEmployee) {
                BasePlusCommissionEmployee bpce = (BasePlusCommissionEmployee) emp;
                typePrefix = "[Base Plus Commission]";
                salary = bpce.computeSalary(currentMonth);
            } else if (emp instanceof CommissionEmployee) {
                CommissionEmployee ce = (CommissionEmployee) emp;
                typePrefix = "[Commission]";
                salary = ce.computeSalary(currentMonth);
            } else if (emp instanceof HourlyEmployee) {
                HourlyEmployee he = (HourlyEmployee) emp;
                typePrefix = "[Hourly]";
                salary = he.computeSalary(currentMonth);
            } else if (emp instanceof PieceWorkerEmployee) {
                PieceWorkerEmployee pwe = (PieceWorkerEmployee) emp;
                typePrefix = "[Piece Worker]";
                salary = pwe.computeSalary(currentMonth);
            }

            boolean bonusApplied = (emp.getBirthDate() != null && emp.getBirthDate().getMonth() == currentMonth);
            String bonusSuffix = bonusApplied ? " (Birthday Bonus Applied)" : "";

            System.out.printf("%-23s ID: %-3d | Name: %-15s | Salary: ₱%,.2f%s%n",
                    typePrefix, emp.getEmpID(), emp.getEmpName(), salary, bonusSuffix);
        }
    }

    public int getCount() {
        return count;
    }

    public int getMax() {
        return max;
    }
}
