package version1;

public class PieceWorkerEmployee {
    private int empID;
    private String empName;
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee(){
        this.empID = 0;
        this.empName = "N/A";
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0.0;
    }

    public PieceWorkerEmployee(int empID, String empName){
        this.empID = empID;
        this.empName = empName;
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0.0;
    }

    public PieceWorkerEmployee(int empID, String empName, int totalPiecesFinished, double ratePerPiece){
        this.empID = empID;
        this.empName = empName;
        this.totalPiecesFinished = totalPiecesFinished;
        this.ratePerPiece = ratePerPiece;
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

    public int getTotalPiecesFinished(){
        return totalPiecesFinished;
    }

    public void setTotalPiecesFinished(int totalPiecesFinished){
        this.totalPiecesFinished = totalPiecesFinished;
    }

    public double getRatePerPiece(){
        return ratePerPiece;
    }

    public void setRatePerPiece(double ratePerPiece){
        this.ratePerPiece = ratePerPiece;
    }

    public double computeSalary(){
        double basePay = totalPiecesFinished * ratePerPiece;
        double bonusRule = totalPiecesFinished / 100;
        double bonusPay = bonusRule * (100 * ratePerPiece);
        return basePay + bonusPay;
    }

    public void displayPieceWorkerEmployee() {
        System.out.printf("ID: %d | Name: %s | Pieces Finished: %d | Rate/Piece: ₱%.2f%n",
                empID, empName, totalPiecesFinished, ratePerPiece);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PieceWorker Employee [ID: ").append(empID)
                .append(", Name: ").append(empName)
                .append(", Pieces: ").append(totalPiecesFinished)
                .append(", Rate: ₱").append(String.format("%.2f", ratePerPiece))
                .append(", Total Salary: ₱").append(String.format("%,.2f", computeSalary()))
                .append("]");
        return sb.toString();
    }
}
