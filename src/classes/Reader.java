package classes;

public class Reader extends Persoana {
    private Date birthDay;
    private String CNP;
    private String nrTel;
    private String mail;
    private Subscription idSubs;

    public Reader(String firstName, String lastName, Date birthDay, String CNP, String nrTel, String mail, Subscription idSubs) {
        super(firstName, lastName);
        this.birthDay = birthDay;
        this.CNP = CNP;
        this.nrTel = nrTel;
        this.mail = mail;
        this.idSubs = idSubs;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String getNrTel() {
        return nrTel;
    }

    public void setNrTel(String nrTel) {
        this.nrTel = nrTel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getIdSubs() {
        return idSubs.getIdSubscription();
    }

    public void setIdSubs(Subscription idSubs) {
        this.idSubs = idSubs;
    }

    @Override
    public String toString() {
        return "Lastname: " + lastName + '\n' +
                "Firstname: '" + firstName + '\n' +
                "CNP: " + CNP + '\n' +
                "Contacts: " + nrTel + ", " + mail + '\n' +
                "Birthdate: " + birthDay + '\n' +
                "Subscription ID: " + idSubs + '\n';
    }

    //De facut alta interfata
    @Override
    public int compareTo(Persoana p) {
        return super.compareTo(p);
    }
}
