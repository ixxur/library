package classes;

public class Persoana implements ComparablePers<Persoana> {

    protected String firstName;
    protected String lastName;

    public Persoana(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Firstname: " + firstName + '\n' +
                "Lastname: " + lastName + '\n';
    }

    @Override
    public int compareTo(Persoana p) {
        String fullName = this.lastName + this.firstName;
        String pFullName = p.lastName + p.firstName;
        return fullName.compareTo(pFullName);

    }
}
