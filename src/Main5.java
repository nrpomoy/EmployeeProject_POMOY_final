import version5.HourlyEmployee;
import version5.PieceWorkerEmployee;
import version5.CommissionEmployee;
import version5.BasePlusCommissionEmployee;
import version5.Name;
import version5.MyDate;
import version5.Employee;
import version5.EmployeeRoster;


public class Main5 {
    public static void main(String[] args) {
        EmployeeRoster roster = new EmployeeRoster();

        MyDate hiredDate = new MyDate(1, 6, 2022);

        MyDate dobSep = new MyDate(18, 9, 2000);
        MyDate dobApr = new MyDate(5, 4, 1998);

        Employee emp1 = new HourlyEmployee(101, new Name("Alice", "M.", "Smith"), dobSep, hiredDate, 45.0f, 200.00);
        Employee emp2 = new PieceWorkerEmployee(201, new Name("Bob", "C.", "Jones", "Jr."), dobApr, hiredDate, 250, 15.00);
        Employee emp3 = new CommissionEmployee(301, new Name("Maria", "L.", "Reyes"), dobSep, hiredDate, 100000.00);
        Employee emp4 = new BasePlusCommissionEmployee(401, new Name("Kevin", "S.", "Tan"), dobApr, hiredDate, 80000.00, 19000.00);

        System.out.println("======================================================================");
        System.out.println("           DYNAMIC ROSTER INITIALIZATION (ArrayList Backend)          ");
        System.out.println("======================================================================");

        roster.addEmployee(emp1);
        System.out.println("Enrolled: Smith, Alice M. (Hourly)");
        roster.addEmployee(emp2);
        System.out.println("Enrolled: Jones, Bob C. Jr. (Piece Worker)");
        roster.addEmployee(emp3);
        System.out.println("Enrolled: Reyes, Maria L. (Commission)");
        roster.addEmployee(emp4);
        System.out.println("Enrolled: Tan, Kevin S. (Base Plus Commission)");

        System.out.printf("Total Roster Size: %d employees%n", roster.countEmployees());

        System.out.println("======================================================================");
        System.out.println("        PURE POLYMORPHIC PAYROLL REPORT (Target Month: Sep)           ");
        System.out.println("   [No downcasting; dynamic dispatch via Employee.computeSalary()]    ");
        System.out.println("======================================================================");
        roster.displayPayroll(9);

        System.out.println("======================================================================");
        System.out.println("                       COLLECTION REMOVAL TEST                        ");
        System.out.println("======================================================================");

        int removeID = 201;
        System.out.printf("Removing Employee ID %d... ", removeID);
        Employee removed = roster.removeEmployee(removeID);
        if (removed != null) {
            System.out.println("Successfully removed.");
        } else {
            System.out.println("Employee not found.");
        }

        System.out.printf("Updated Roster Size: %d%n", roster.countEmployees());
        System.out.println("Current Active Employees:");
        roster.displayAllEmployees();
        System.out.println("======================================================================");
    }
}