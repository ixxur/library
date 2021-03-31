package services;

import classes.*;
import com.sun.corba.se.impl.oa.toa.TOA;

import java.util.ArrayList;
import java.util.Objects;

import static java.lang.Integer.parseInt;

public class Service{

    public boolean checkReader(String _cnp, ArrayList<Reader> listOfReaders) {
        for (int i = 0; i < listOfReaders.size(); i++) {
            String cnp = listOfReaders.get(i).getCNP();
            if (Objects.equals(cnp, _cnp) == true)
                return true;
        }
        return false;
    }

    public Subscription createSubs(String _cnp, ArrayList<Subscription> subs , ArrayList<Reader> readers){
        boolean ok = false;
        for(int i = 0; i < subs.size(); i++){
            if(subs.get(i).getReaderCNP() == _cnp)
                ok = true;
        }
        if(ok == false) {
            Reader r = new Reader("","",_cnp,"","");
            readers.add(r);
            Subscription newSubs = new Subscription("","","","","","",null,null,null,null);
            subs.add(newSubs);
            System.out.println("Set data on new reader with CNP " + _cnp);
            return newSubs;
        }
        else return null;
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
        return sum;
    }

    public String topAuthor (ArrayList<Author> a1){
        for(int i = 0; i < a1.size(); i++){
            if(a1.get(i).getRating() >= 4.5)
                return a1.get(i).getFirstName() + " " + a1.get(i).getLastName() + " rating: " + a1.get(i).getRating();
        }
        return null;
    }

    public boolean checkAuthor(String _name, ArrayList<Author>listOfAuthors){
        for(int i = 0; i < listOfAuthors.size(); i++){
            String name = listOfAuthors.get(i).getFirstName() + " " + listOfAuthors.get(i).getLastName();
            if(Objects.equals(name, _name) == true)
                return true;
        }
        return false;
    }

    public boolean checkBookIsInList(String _title, ArrayList<Book> bookArrayList){
        for(int i = 0; i < bookArrayList.size(); i++){
            String title = bookArrayList.get(i).getTitle();
            if(Objects.equals(title, _title) == true)
                return true;
        }
        return false;
    }

    public void showBooksInCategory(String _category, ArrayList<Book>bookArrayList){
        for(int i = 0; i < bookArrayList.size(); i++){
            if(bookArrayList.get(i).getCategory() == _category)
            System.out.println("-> " + bookArrayList.get(i).getTitle() + " by " + bookArrayList.get(i).getAuthor());
        }
    }

    public void showExpiredSubs(ArrayList<Subscription> subs){
        for(int i = 0; i < subs.size(); i++){
            if(subs.get(i).getEndSubs().getMonth() != "april" || subs.get(i).getEndSubs().getMonth() != "may" && parseInt(subs.get(i).getEndSubs().getYear()) <= 2021 )
                System.out.println("-> " + subs.get(i).getReader());
        }
    }

    public int forgottenBooks(ArrayList<BorrowedBook> bb){
        int count = 0;
        for(int i = 0; i < bb.size(); i++){
            if(bb.get(i).getBackDay() == null)
                count++;
        }
        return count;
    }
}
