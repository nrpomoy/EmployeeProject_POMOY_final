import version2.HourlyEmployee;
import version2.PieceWorkerEmployee;
import version2.CommissionEmployee;
import version2.BasePlusCommissionEmployee;
import version2.Name;
import version2.MyDate;

public class Main2 {
    public static void main(String[] args) {
        System.out.println("--- Name & Date Output Verification ---");
        Name standaloneName = new Name("Alice", "M.", "Smith");
        MyDate standaloneDate = new MyDate(18, 9, 2026);
        standaloneName.displayName();
        standaloneDate.displayDate();
        System.out.println();

        MyDate dob1 = new MyDate(18, 9, 2000);  // Birth month: September (9)
        MyDate hired1 = new MyDate(1, 6, 2022);

        MyDate dob2 = new MyDate(20, 11, 1998); // Birth month: November (11)
        MyDate hired2 = new MyDate(10, 5, 2021);

        System.out.println("--- Hourly Employee Payroll Test ---");
        Name name1 = new Name("Alice", "M.", "Smith");
        HourlyEmployee he1 = new HourlyEmployee(101, name1, dob1, hired1, 45.0f, 200.00);

        System.out.println("[displayHourlyEmployee()]");
        he1.displayHourlyEmployee();

        System.out.println("[toString()]");
        System.out.println(he1);

        System.out.println("[Birthday Incentive Check]");
        System.out.printf("Regular Month (Oct) Salary: ₱%.2f%n", he1.computeSalary(10));
        System.out.printf("Birth Month (Sep) Salary (+₱5,000.00): ₱%.2f%n%n", he1.computeSalary(9));

        System.out.println("--- Piece Worker Employee Payroll Test ---");
        Name name2 = new Name("Bob", "C.", "Jones", "Jr.");
        PieceWorkerEmployee pw1 = new PieceWorkerEmployee(201, name2, dob2, hired2, 250, 15.00);

        System.out.println("[displayPieceWorkerEmployee()]");
        pw1.displayPieceWorkerEmployee();

        System.out.println("[toString()]");
        System.out.println(pw1);

        System.out.println("[Birthday Incentive Check]");
        System.out.printf("Regular Month (Oct) Salary: ₱%.2f%n", pw1.computeSalary(10));
        System.out.printf("Birth Month (Nov) Salary (+₱5,000.00): ₱%.2f%n%n", pw1.computeSalary(11));

        System.out.println("--- Commission Employee Payroll Test ---");
        Name name3 = new Name("Diana", "Prince");
        CommissionEmployee ce1 = new CommissionEmployee(301, name3, dob1, hired1, 75000.00);

        System.out.println("[displayCommissionEmployee()]");
        ce1.displayCommissionEmployee();

        System.out.println("[toString()]");
        System.out.println(ce1);

        System.out.println("[Birthday Incentive Check]");
        System.out.printf("Regular Month (Oct) Salary: ₱%.2f%n", ce1.computeSalary(10));
        System.out.printf("Birth Month (Sep) Salary (+₱5,000.00): ₱%.2f%n%n", ce1.computeSalary(9));

        System.out.println("--- Base Plus Commission Employee Payroll Test ---");
        Name name4 = new Name("Fiona", "G.", "Gallagher", "III");
        BasePlusCommissionEmployee bp1 = new BasePlusCommissionEmployee(401, name4, dob2, hired2, 35000.00, 15000.00);

        System.out.println("[displayBasePlusCommissionEmployee()]");
        bp1.displayBasePlusCommissionEmployee();

        System.out.println("[toString()]");
        System.out.println(bp1);

        System.out.println("[Birthday Incentive Check]");
        System.out.printf("Regular Month (Oct) Salary: ₱%.2f%n", bp1.computeSalary(10));
        System.out.printf("Birth Month (Nov) Salary (+₱5,000.00): ₱%.2f%n", bp1.computeSalary(11));
    }
}