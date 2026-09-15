package version2;

public class PieceWorkerEmployee {
    private int empID;
    private Name empName;
    private int totalPiecesFinished;
    private double ratePerPiece;
    private MyDate birthDate;
    private MyDate dateHired;

    public PieceWorkerEmployee(){
        this.empID = 0;
        this.empName = new Name();
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0.0;
        this.birthDate = new MyDate();
        this.dateHired = new MyDate();
    }

    public PieceWorkerEmployee(int empID, Name empName){
        this.empID = empID;
        this.empName = empName;
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0.0;
        this.birthDate = new MyDate();
        this.dateHired = new MyDate();
    }

    public PieceWorkerEmployee(int empID, Name empName, int totalPiecesFinished, double ratePerPiece){
        this.empID = empID;
        this.empName = empName;
        this.totalPiecesFinished = totalPiecesFinished;
        this.ratePerPiece = ratePerPiece;
        this.birthDate = new MyDate();
        this.dateHired = new MyDate();
    }

    public PieceWorkerEmployee(int empID, Name empName, int totalPiecesFinished, double ratePerPiece, MyDate birthDate, MyDate dateHired){
        this.empID = empID;
        this.empName = empName;
        this.totalPiecesFinished = totalPiecesFinished;
        this.ratePerPiece = ratePerPiece;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
    }

    public int getEmpID(){
        return empID;

    }
    public void setEmpID(int empID){
        this.empID = empID;
    }

    public Name getEmpName(){
        return empName;

    }
    public void setEmpName(Name empName){
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
        double basePay = totalPiecesFinished * ratePerPiece;
        double bonusRule = totalPiecesFinished / 100.0;
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
