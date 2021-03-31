package classes;

public class Reader extends Persoana {
    private String CNP;
    private String nrTel;
    private String mail;

    public Reader(String firstName, String lastName, String CNP, String nrTel, String mail) {
        super(firstName, lastName);
        this.CNP = CNP;
        this.nrTel = nrTel;
        this.mail = mail;
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

    @Override
    public String toString() {
        return super.toString() +
                "CNP: " + CNP + '\n' +
                "Telephone: " + nrTel + '\n' +
                "Mail: " + mail + '\n';
    }

   // @Override
    //public int compareTo(Persoana p) {
     //   return super.compareTo(p);
    //}
}
