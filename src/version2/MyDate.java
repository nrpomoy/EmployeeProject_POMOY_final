package version2;

public class MyDate {
    private int day;
    private int month;
    private int year;

    public MyDate() {
        this.day = 1;
        this.month = 1;
        this.year = 2000;
    }

    public MyDate(int day, int month, int year) {
        setYear(year);
        setMonth(month);
        setDay(day);
    }

    private int getMaxDaysInMonth(int month, int year) {
        switch (month) {
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    return 29;
                }
                return 28;
            default:
                return 31;
        }
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        int maxDays = getMaxDaysInMonth(this.month, this.year);
        if (day >= 1 && day <= maxDays) {
            this.day = day;
        } else {
            System.out.println("Invalid day! Defaulting to 1.");
            this.day = 1;
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month >= 1 && month <= 12) {
            this.month = month;
        } else {
            System.out.println("Invalid month! Defaulting to 1.");
            this.month = 1;
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year >= 1) {
            this.year = year;
        } else {
            System.out.println("Invalid year! Defaulting to 2000.");
            this.year = 2000;
        }
    }

    public void displayDate() {
        System.out.println("Date: " + this.toString());
    }

    @Override
    public String toString() {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String stringMonths = months[this.month - 1];
        return String.format("%02d %s %04d", this.day, stringMonths, this.year);
    }
}