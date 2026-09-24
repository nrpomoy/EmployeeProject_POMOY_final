package version5;

import java.util.Objects;

public class PieceWorkerEmployee extends Employee {
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        super();
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0.0;
    }

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, int totalPiecesFinished, double ratePerPiece) {
        super(empID, empName, birthDate, dateHired);
        setTotalPiecesFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
    }

    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public void setTotalPiecesFinished(int totalPiecesFinished) {
        if (totalPiecesFinished >= 0) {
            this.totalPiecesFinished = totalPiecesFinished;
        } else {
            this.totalPiecesFinished = 0;
        }
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }

    public void setRatePerPiece(double ratePerPiece) {
        if (ratePerPiece >= 0) {
            this.ratePerPiece = ratePerPiece;
        } else {
            this.ratePerPiece = 0.0;
        }
    }

    @Override
    public double computeSalary(int currentMonth) {
        double basePay = this.totalPiecesFinished * this.ratePerPiece;
        double bonusPay = (this.totalPiecesFinished / 100) * (10 * this.ratePerPiece);
        double totalSalary = basePay + bonusPay;

        if (getBirthDate() != null && getBirthDate().getMonth() == currentMonth) {
            totalSalary += 5000.00;
        }
        return totalSalary;
    }

    public void displayPieceWorkerEmployee() {
        super.displayEmployee();
        System.out.printf(" | Pieces Finished: %d | Rate/Piece: ₱%.2f%n", this.totalPiecesFinished, this.ratePerPiece);
    }

    @Override
    public String toString() {
        return String.format("PieceWorkerEmployee [ID: %d, Name: %s, Total Salary: ₱%,.2f]",
                getEmpID(), getEmpName(), computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        PieceWorkerEmployee other = (PieceWorkerEmployee) obj;
        return totalPiecesFinished == other.totalPiecesFinished &&
                Double.compare(other.ratePerPiece, ratePerPiece) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalPiecesFinished, ratePerPiece);
    }

    @Override
    public PieceWorkerEmployee clone() {
        return (PieceWorkerEmployee) super.clone();
    }
}