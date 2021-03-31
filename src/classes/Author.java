package classes;

import java.util.ArrayList;

public class Author extends Persoana{
    private Date birthDay;
    private Date deathDay;
    private String description;
    private double rating;

    public Author(String firstName, String lastName, String bday, String bmonth, String byear, String dday, String dmonth, String dyear, String description, double rating) {
        super(firstName, lastName);
        this.birthDay = new Date(bday, bmonth, byear);
        this.deathDay = new Date(dday, dmonth, dyear);
        this.description = description;
        this.rating = rating;
    }

    public Author(String firstName, String lastName, String bday, String bmonth, String byear, String description, double rating) {
        super(firstName, lastName);
        this.birthDay = new Date(bday, bmonth, byear);
        this.deathDay = null;
        this.description = description;
        this.rating = rating;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Date getDeathDay() {
        return deathDay;
    }

    public void setDeathDay(Date deathDay) {
        this.deathDay = deathDay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        if (deathDay == null)
            return "**AUTHOR**\n" +
                    "Name: " + firstName + ' ' + lastName + '\n' +
                    "Birthdate: " + birthDay +
                    "Description: " + description + '\n' +
                    "Rating: " + rating + '\n';
        else return "**AUTHOR** \n" +
                "Name: " + firstName + ' ' + lastName + '\n' +
                "Lived between: " + birthDay + "-" + deathDay +
                "Description: " + description + '\n' +
                "Rating: " + rating + '\n';
    }


   // @Override
    //public int compareTo(Persoana p) {
    //    return super.compareTo(p);
    //}
}
