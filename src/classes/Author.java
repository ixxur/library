package classes;

public class Author extends Persoana {
    private Date birthDay;
    private Date deathDay;
    private String description;
    private double rating;

    public Author(String firstName, String lastName, Date birthDay, Date deathDay, String description, double rating) {
        super(firstName, lastName);
        this.birthDay = birthDay;
        this.deathDay = deathDay;
        this.description = description;
        this.rating = rating;
    }

    public Author(String firstName, String lastName, Date birthDay, String description, double rating) {
        super(firstName, lastName);
        this.birthDay = birthDay;
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
            return "AUTHOR: \n" +
                    "Name: " + firstName + ' ' + lastName + '\n' +
                    "Birthdate: " + birthDay + '\n' +
                    "Description: " + description + '\n' +
                    "Rating: " + rating + '\n';
        else return "AUTHOR: \n" +
                "Name: " + firstName + ' ' + lastName + '\n' +
                "Lived between: " + birthDay + " - " + deathDay + '\n' +
                "Description: " + description + '\n' +
                "Rating: " + rating + '\n';
    }

}
