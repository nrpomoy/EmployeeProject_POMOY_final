package version2;

public class Name {
    private String firstName;
    private String middleName; // optional
    private String lastName;
    private String suffix;     // optional

    public Name() {
        this("N/A", null, "N/A", null);
    }

    public Name(String firstName, String lastName) {
        this(firstName, null, lastName, null);
    }

    public Name(String firstName, String middleName, String lastName) {
        this(firstName, middleName, lastName, null);
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

    public void displayName() {
        System.out.println("Name: " + this.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(firstName);
        if (middleName != null && !middleName.trim().isEmpty()) {
            sb.append(" ").append(middleName);
        }
        sb.append(" ").append(lastName);
        if (suffix != null && !suffix.trim().isEmpty()) {
            sb.append(" ").append(suffix);
        }
        return sb.toString();
    }
}