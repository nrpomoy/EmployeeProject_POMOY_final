package version2;

public class Name {
    private String firstName;
    private String middleName; // optional
    private String lastName;
    private String suffix;     // optional

    public Name() {
        this.firstName = "N/A";
        this.middleName = "N/A";
        this.lastName = "N/A";
        this.suffix = "";
    }

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.middleName = "N/A";
        this.lastName = lastName;
        this.suffix = "";
    }

    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = "";
    }

    public Name(String firstName, String middleName, String lastName, String suffix) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    private String getMiddleInitial() {
        if (middleName != null && !middleName.trim().isEmpty() && !middleName.equalsIgnoreCase("N/A")) {
            return middleName.trim().substring(0, 1).toUpperCase() + ".";
        }
        return "";
    }

    public void displayName() {
        String mi = getMiddleInitial();
        if (mi.isEmpty()) {
            System.out.printf("%s, %s%n", lastName, firstName);
        } else {
            System.out.printf("%s, %s %s%n", lastName, firstName, mi);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(lastName).append(", ").append(firstName);

        String mi = getMiddleInitial();
        if (!mi.isEmpty()) {
            sb.append(" ").append(mi);
        }

        if (suffix != null && !suffix.trim().isEmpty()) {
            sb.append(" ").append(suffix.trim());
        }

        return sb.toString();
    }
}