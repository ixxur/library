package classes;

public class Persoana {

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
}
