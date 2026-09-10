import version1.HourlyEmployee;
import version1.PieceWorkerEmployee;
import version1.CommissionEmployee;
import version1.BasePlusCommissionEmployee;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        HourlyEmployee he1 = new HourlyEmployee(101, "Alice Smith");
        he1.setTotalHoursWorked(45.0f);
        he1.setRatePerHour(200.00);

        HourlyEmployee he2 = new HourlyEmployee(102, "John Doe", 38.0f, 150.00);

        sb.append("--- Hourly Employee Test ---\n")
                .append("[displayHourlyEmployee()]\n");
        System.out.print(sb.toString());
        sb.setLength(0);

        he1.displayHourlyEmployee();
        he2.displayHourlyEmployee();

        sb.append("\n[toString()]\n")
                .append(he1.toString()).append("\n")
                .append(he2.toString()).append("\n\n");

        PieceWorkerEmployee pw1 = new PieceWorkerEmployee(201, "Bob Jones");
        pw1.setTotalPiecesFinished(250);
        pw1.setRatePerPiece(15.00);

        PieceWorkerEmployee pw2 = new PieceWorkerEmployee(202, "Charlie Brown", 415, 20.00);

        sb.append("--- Piece Worker Employee Test ---\n")
                .append("[displayPieceWorkerEmployee()]\n");
        System.out.print(sb.toString());
        sb.setLength(0);

        pw1.displayPieceWorkerEmployee();
        pw2.displayPieceWorkerEmployee();

        sb.append("\n[toString()]\n")
                .append(pw1.toString()).append("\n")
                .append(pw2.toString()).append("\n\n");

        CommissionEmployee ce1 = new CommissionEmployee(301, "Diana Prince");
        ce1.setTotalSale(75000.00);

        CommissionEmployee ce2 = new CommissionEmployee(302, "Evan Wright", 550000.00);

        sb.append("--- Commission Employee Test ---\n")
                .append("[displayCommissionEmployee()]\n");
        System.out.print(sb.toString());

        ce1.displayCommissionEmployee();
        ce2.displayCommissionEmployee();

        sb.append("\n[toString()]\n")
                .append(ce1.toString()).append("\n")
                .append(ce2.toString()).append("\n\n");

        BasePlusCommissionEmployee bp1 = new BasePlusCommissionEmployee(401, "Fiona Gallagher");
        bp1.setTotalSale(35000.00);
        bp1.setBaseSalary(15000.00);

        BasePlusCommissionEmployee bp2 = new BasePlusCommissionEmployee(402, "George Clark", 120000.00, 25000.00);

        sb.append("--- Base Plus Commission Employee Test ---\n")
                .append("[displayBasePlusCommissionEmployee()]\n");
        System.out.print(sb.toString());
        sb.setLength(0);

        bp1.displayBasePlusCommissionEmployee();
        bp2.displayBasePlusCommissionEmployee();

        sb.append("\n[toString()]\n")
                .append(bp1.toString()).append("\n")
                .append(bp2.toString()).append("\n");

        System.out.print(sb.toString());
    }
}