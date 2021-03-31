package services;

import classes.PublishedEdition;

import java.util.Comparator;

public class SortByYear implements Comparator<PublishedEdition> {
    public int compare(PublishedEdition y1, PublishedEdition y2){
        if(y1.getPublishingYear() == y2.getPublishingYear())
            return y1.getTitle().compareTo(y2.getTitle());
        else return y1.getPublishingYear().compareTo(y2.getPublishingYear());
    }
}
