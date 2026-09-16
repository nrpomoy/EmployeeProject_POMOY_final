import version3.HourlyEmployee;
import version3.PieceWorkerEmployee;
import version3.CommissionEmployee;
import version3.BasePlusCommissionEmployee;
import version3.Name;
import version3.MyDate;
import version3.Employee;

public class Main3 {
    public static void main(String[] args) {
        int targetMonth = 9;

        MyDate dobSep = new MyDate(18, 9, 2000);
        MyDate dobApr = new MyDate(5, 4, 1998);
        MyDate hired = new MyDate(1, 6, 2022);

        Employee[] employees = new Employee[4];

        employees[0] = new HourlyEmployee(101, new Name("Alice",
                "M.", "Smith"), dobSep, hired, 45.0f,
                200.00);

        employees[1] = new PieceWorkerEmployee(201, new Name("Bob",
                "C.", "Jones", "Jr."), dobApr, hired,
                250, 15.00);

        employees[2] = new CommissionEmployee(301, new Name("Diana", "Prince"),
                dobSep, hired, 75000.00);

        employees[3] = new BasePlusCommissionEmployee(401, new Name("Fiona",
                "G.", "Gallagher", "III"), dobApr, hired,
                35000.00, 15000.00);



        System.out.println("-------- POLYMORPHIC PAYROLL REPORT (Target Month: Sep)--------\n");

        for (int i = 0; i < employees.length; i++) {
            Employee emp = employees[i];
            double basePay = emp.computeSalary(-1);
            double totalPay = emp.computeSalary(targetMonth);
            double bonus = totalPay - basePay;
            String eligibility = (bonus > 0) ? "Eligible" : "Ineligible";

            System.out.printf("%d. %s [%s]%n", (i + 1), emp.getClass().getSimpleName(),
                    emp);
            System.out.printf("   Base Pay: ₱%,.2f | Birthday Bonus: ₱%,.2f (%s)%n",
                    basePay, bonus, eligibility);
            System.out.printf("   Total Payout: ₱%,.2f%n", totalPay);
            System.out.println("\n\n");
        }



        System.out.println("\n--------OBJECT CONTRACT TESTS (equals & hashCode)--------\n");

        HourlyEmployee emp1 = new HourlyEmployee(101, new Name("Alice",
                "M.", "Smith"), new MyDate(18, 9,
                2000), new MyDate(1, 6, 2022),
                45.0f, 200.00);

        HourlyEmployee emp1Identical = new HourlyEmployee(101, new Name("Alice",
                "M.", "Smith"), new MyDate(18, 9, 2000), new MyDate(1, 6, 2022), 45.0f, 200.00);

        HourlyEmployee emp2 = new HourlyEmployee(102, new Name("John", "Doe"),
                new MyDate(10, 5, 1995), new MyDate(1, 6, 2022), 40.0f, 150.00);

        System.out.println("emp1 equals emp1Identical: " + emp1.equals(emp1Identical));
        System.out.println("emp1 hashCode: " + emp1.hashCode() + " | emp1Identical hashCode: " + emp1Identical.hashCode() +
                " (Match: " + (emp1.hashCode() == emp1Identical.hashCode()) + ")");
        System.out.println("emp1 equals emp2: " + emp1.equals(emp2));



        System.out.println("\n--------DEEP CLONE VERIFICATION--------\n");

        HourlyEmployee original = (HourlyEmployee) employees[0];
        HourlyEmployee cloned = original.clone();

        System.out.println("Original Name before modification: " +
                original.getEmpName());

        cloned.getEmpName().setLastName("Taylor");
        System.out.println("Clone Name changed to: " +
                cloned.getEmpName());

        System.out.println("Original Name after modification: " +
                original.getEmpName());

        if (!original.getEmpName().getLastName().equals(cloned.getEmpName().getLastName())) {
            System.out.println(">>> Deep copy successful! Modifying clone did not affect the original. <<<");
        } else {
            System.out.println(">>> Shallow copy detected! Original was affected. <<<");
        }
    }
}