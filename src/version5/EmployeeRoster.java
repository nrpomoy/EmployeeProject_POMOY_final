package version5;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRoster {
    private List<Employee> empList;

    public EmployeeRoster() {
        this.empList = new ArrayList<>();
    }

    public EmployeeRoster(int initialCapacity) {
        this.empList = new ArrayList<>(initialCapacity);
    }

    public List<Employee> getEmpList() {
        return empList;
    }

    public boolean addEmployee(Employee emp) {
        if (emp == null) {
            return false;
        }
        return this.empList.add(emp);
    }

    public Employee removeEmployee(int empID) {
        for (int i = 0; i < this.empList.size(); i++) {
            if (this.empList.get(i).getEmpID() == empID) {
                return this.empList.remove(i);
            }
        }
        return null;
    }

    public Employee searchEmployee(int empID) {
        for (Employee emp : this.empList) {
            if (emp.getEmpID() == empID) {
                return emp;
            }
        }
        return null;
    }

    public int countEmployees() {
        return this.empList.size();
    }

    public int countHE() {
        int count = 0;
        for (Employee emp : this.empList) {
            if (emp instanceof HourlyEmployee) {
                count++;
            }
        }
        return count;
    }

    public int countPWE() {
        int count = 0;
        for (Employee emp : this.empList) {
            if (emp instanceof PieceWorkerEmployee) {
                count++;
            }
        }
        return count;
    }

    public int countCE() {
        int count = 0;
        for (Employee emp : this.empList) {
            if (emp instanceof CommissionEmployee && !(emp instanceof BasePlusCommissionEmployee)) {
                count++;
            }
        }
        return count;
    }

    public int countBPCE() {
        int count = 0;
        for (Employee emp : this.empList) {
            if (emp instanceof BasePlusCommissionEmployee) {
                count++;
            }
        }
        return count;
    }

    // Dynamic Method Dispatch Demonstration: No instanceof or downcasting permitted
    public void displayPayroll(int currentMonth) {
        for (Employee emp : this.empList) {
            double salary = emp.computeSalary(currentMonth);

            String bonusNotice = "";
            if (emp.getBirthDate() != null && emp.getBirthDate().getMonth() == currentMonth) {
                bonusNotice = " (Birthday Bonus Applied)";
            }

            System.out.printf("ID: %d | Name: %-25s | Payout: ₱%,.2f%s%n",
                    emp.getEmpID(), emp.getEmpName(), salary, bonusNotice);
        }
    }

    public void displayAllEmployees() {
        int index = 1;
        for (Employee emp : this.empList) {
            System.out.printf("%d. %s%n", index++, emp);
        }
    }
}