package services;

import classes.Reader;

import java.util.Comparator;

public class SortByName implements Comparator<Reader> {
    public int compare(Reader A, Reader B)
    {
        if(A.getLastName()==B.getLastName())
            return A.getFirstName().compareTo(B.getFirstName());
        else return A.getLastName().compareTo(B.getLastName());
    }
}
