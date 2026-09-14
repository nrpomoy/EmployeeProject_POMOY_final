package version2;

public class MyDate {
    private String day;
    private int date;
    private int month;
    public int year;

    public MyDate() {
        this("Monday", 1, 1, 2026);
    }

    public MyDate(int month, int date, int year) {
        this("N/A", date, month, year);
    }

    public MyDate(String day, int date, int month, int year) {
        this.day = day;
        this.date = date;
        this.month = month;
        this.year = year;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isSameMonthAndDay(MyDate other) {
        return other != null && this.month == other.month && this.date == other.date;
    }

    public void displayMyDate() {
        System.out.println("Date: " + this.toString());
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d (%s)", month, date, year, day);
    }
}