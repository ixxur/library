package classes;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Author extends Persoana{
    private String birthDay;
    private String deathDay;
    private String description;
    private double rating;

    public Author(String firstName, String lastName, String birthDay, String deathDay, String description, double rating) {
        super(firstName, lastName);
        this.birthDay = birthDay;
        this.deathDay = deathDay;
        this.description = description;
        this.rating = rating;
    }

    public Author(){}

    public Author (@NotNull Author author){
        this.firstName = author.firstName;
        this.lastName = author.lastName;
        this.birthDay = author.birthDay;
        this.deathDay = author.deathDay;
        this.description = author.description;
        this.rating = author.rating;
    }
    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getDeathDay() {
        return deathDay;
    }

    public void setDeathDay(String deathDay) {
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
                "Lived between: " + birthDay + " and " + deathDay +
                "\nDescription: " + description + '\n' +
                "Rating: " + rating + '\n';
    }
}
