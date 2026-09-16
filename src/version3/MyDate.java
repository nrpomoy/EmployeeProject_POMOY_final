package version3;

import java.util.Objects;

public class MyDate implements Cloneable {
    private int day;
    private int month;
    private int year;

    public MyDate() {
        this.day = 1;
        this.month = 1;
        this.year = 2000;
    }

    public MyDate(int day, int month, int year) {
        setMonth(month);
        setDay(day);
        setYear(year);
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (day >= 1 && day <= 31) {
            this.day = day;
        } else {
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
            this.month = 1;
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year > 0) {
            this.year = year;
        } else {
            this.year = 2000;
        }
    }

    public void displayDate() {
        System.out.println("Date: " + this.toString());
    }

    @Override
    public String toString() {
        String monthName = "";
        switch (this.month) {
            case 1:  monthName = "Jan"; break;
            case 2:  monthName = "Feb"; break;
            case 3:  monthName = "Mar"; break;
            case 4:  monthName = "Apr"; break;
            case 5:  monthName = "May"; break;
            case 6:  monthName = "Jun"; break;
            case 7:  monthName = "Jul"; break;
            case 8:  monthName = "Aug"; break;
            case 9:  monthName = "Sep"; break;
            case 10: monthName = "Oct"; break;
            case 11: monthName = "Nov"; break;
            case 12: monthName = "Dec"; break;
            default: monthName = "Jan"; break;
        }
        return String.format("%02d %s %04d", this.day, monthName, this.year);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MyDate other = (MyDate) obj;
        return day == other.day && month == other.month && year == other.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }

    @Override
    public MyDate clone() {
        try {
            return (MyDate) super.clone();
        } catch (CloneNotSupportedException e) {
            return new MyDate(this.day, this.month, this.year);
        }
    }
}