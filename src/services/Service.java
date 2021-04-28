package services;

import files.WriteInCSV;
import classes.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Objects;

import static files.WriteInCSV.timeStamp;
import static java.lang.Integer.parseInt;

public class Service{

    public boolean checkReader(String _cnp, ArrayList<Reader> listOfReaders) {
        timeStamp("Checked if reader already exists in database");
        for (int i = 0; i < listOfReaders.size(); i++) {
            String cnp = listOfReaders.get(i).getCNP();
            if (Objects.equals(cnp, _cnp) == true)
                return true;
        }
        return false;
    }

    public Subscription createSubs(String _cnp, ArrayList<Subscription> subs , ArrayList<Reader> readers){
        timeStamp("Created subscription for new client");
        boolean ok = false;
        for(int i = 0; i < subs.size(); i++){
            if(subs.get(i).getReaderCNP() == _cnp)
                ok = true;
        }
        if(ok == false) {
            Reader r = new Reader("","",_cnp,"","");
            readers.add(r);
            Subscription newSubs = new Subscription("","",r,null,null,null);
            subs.add(newSubs);
            System.out.println("Set data on new reader with CNP " + _cnp);
            return newSubs;
        }
        return null;
    }

    public double totalPaymentSubscription(int id, ArrayList<Subscription>subs){

        double sum = 0;
        for(int i = 0; i < subs.size(); i++){
            if(subs.get(i).getIdSubscription() == id) {
                for (int j = 0; j < subs.get(i).getListE().size(); j++) {
                    sum += subs.get(i).getListE().get(j).getPrice();
                }
                for (int j = 0; j < subs.get(i).getListA().size(); j++) {
                    sum += subs.get(i).getListA().get(j).getPrice();
                }
            }
        }
        System.out.print("You bought books worth ");
        timeStamp("Calculated total amount of income for a subscription");
        return sum;
    }

    public String topAuthor (ArrayList<Author> a1){
        for(int i = 0; i < a1.size(); i++){
            if(a1.get(i).getRating() >= 4.5) {
                timeStamp("Listed authors with rating greater than 4.5");
                return a1.get(i).getFirstName() + " " + a1.get(i).getLastName() + " rating: " + a1.get(i).getRating();
            }
        }
        timeStamp("Listed authors with rating greater than 4.5");
        return null;
    }

    public boolean checkAuthor(String _name, ArrayList<Author>listOfAuthors){

        for(int i = 0; i < listOfAuthors.size(); i++){
            String name = listOfAuthors.get(i).getFirstName() + " " + listOfAuthors.get(i).getLastName();
            if(Objects.equals(name, _name) == true){
                timeStamp("Checked if author already exists in the database");
                return true;
            }

        }
        timeStamp("Checked if author already exists in the database");
        return false;
    }

    public boolean checkBookIsInList(String _title, ArrayList<Book> bookArrayList){

        for(int i = 0; i < bookArrayList.size(); i++){
            String title = bookArrayList.get(i).getTitle();
            if(Objects.equals(title, _title) == true) {
                timeStamp("Checked if book is in list");
                return true;
            }
        }
        timeStamp("Checked if book is in list");
        return false;


    }

    public void showBooksInCategory(String _category, ArrayList<Book>bookArrayList){
        for(int i = 0; i < bookArrayList.size(); i++){
            if(bookArrayList.get(i).getCategory() == _category)
            System.out.println("-> " + bookArrayList.get(i).getTitle() + " by " + bookArrayList.get(i).getAuthor());
        }
        timeStamp("ShowBooksInCategory");

    }

    public void showExpiredSubs(ArrayList<Subscription> subs){

        DateFormatter df = new DateFormatter();
        Date todayDate = new Date();

        for(int i = 0; i < subs.size(); i++){
           if (todayDate.after(df.stringToDate(subs.get(i).getEndSubs())))
               System.out.println("-> " + subs.get(i).getReader());
        }
        timeStamp("showExpiredSubscriptions");
    }

    public int forgottenBooks(ArrayList<BorrowedBook> bb){
        int count = 0;
        for(int i = 0; i < bb.size(); i++){
            if(bb.get(i).getBackDay() == null)
                count++;
        }
        timeStamp("Listed borrowed books that have not been returned yet");
        return count;
    }

    public void sortReadersByName(ArrayList<Reader> readerList){

        Collections.sort(readerList, new SortByName());
         for(int i = 0; i < readerList.size(); i++){
             System.out.println(readerList.get(i).getLastName() + " " + readerList.get(i).getFirstName() + " CNP: " + readerList.get(i).getCNP());
         }
        timeStamp("Sorted clients by name");
    }

    public void sortBooksByYear(ArrayList<PublishedEdition> publishedList){

        Collections.sort(publishedList, new SortByYear());
        for (int i = 0; i < publishedList.size(); i++) {
          System.out.println(publishedList.get(i).getTitle() + " by " + publishedList.get(i).getAuthor() + " " + publishedList.get(i).getPublishingYear());
        }
        timeStamp("Sorted books by publishing year");
    }
}
