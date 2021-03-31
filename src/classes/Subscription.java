package classes;

import java.util.ArrayList;
import java.util.Objects;

public class Subscription {
    private int idSubscription;
    private Date beginSubs;
    private Date endSubs;
    private boolean valid;
    private Reader reader;
    private static int countSubs = 1;
    private ArrayList<BorrowedBook> listB = new ArrayList<BorrowedBook>();
    private ArrayList<Ebook> listE = new ArrayList<Ebook>();
    private ArrayList<AudioBook> listA = new ArrayList<AudioBook>();
    private ArrayList<ArrayList<Book>> list = new ArrayList<>();



    public Subscription(String startDay, String startMonth, String startYear, String endDay, String endMonth, String endYear, Reader reader, ArrayList<BorrowedBook> listB, ArrayList<Ebook> listE, ArrayList<AudioBook> listA) {
        this.idSubscription = countSubs;
        this.beginSubs = new Date(startDay, startMonth, startYear);
        this.endSubs = new Date(endDay, endMonth, endYear);
        this.valid = true;
        this.reader = reader;
        this.listB = listB;
        this.listE = listE;
        this.listA = listA;
        countSubs++;
    }

    public int getIdSubscription() {
        return idSubscription;
    }

    public Date getBeginSubs() {
        return beginSubs;
    }

    public void setBeginSubs(Date beginSubs) {
        this.beginSubs = beginSubs;
    }

    public Date getEndSubs() {
        return endSubs;
    }

    public void setEndSubs(Date endSubs) {
        this.endSubs = endSubs;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getReader() {
        return reader.getFirstName() + " " + reader.getLastName() + " " + reader.getCNP();
    }

    public String getReaderCNP(){
        return reader.getCNP();
    }


    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public static int getCountSubs() {
        return countSubs;
    }

    public ArrayList<BorrowedBook> getList() {
        return listB;
    }

    public void addBorrowedBook(BorrowedBook borrowedBook){
        listB.add(borrowedBook);
    }

    public void showBorrowedBook(){
        for(int i = 0; i < listB.size(); i++){
            System.out.println(listB.get(i).getIdBook() + " " + listB.get(i).getTitle());
        }
    }

    public boolean checkAlreadyBorrowed(String title){
        for(int i = 0; i < listB.size(); i++){
            String _title = listB.get(i).getTitle();
            if(Objects.equals(title, _title) == true)
                return true;
        }
        return false;
    }

    public ArrayList<BorrowedBook> getListB() {
        return listB;
    }

    public void setListB(ArrayList<BorrowedBook> listB) {
        this.listB = listB;
    }

    public ArrayList<Ebook> getListE() {
        return listE;
    }

    public void setListE(ArrayList<Ebook> listE) {
        this.listE = listE;
    }

    public ArrayList<AudioBook> getListA() {
        return listA;
    }

    public void setListA(ArrayList<AudioBook> listA) {
        this.listA = listA;
    }

    public void setList(ArrayList<ArrayList<Book>> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        if(valid == true)
         return "Subscription with ID " + idSubscription +
                " is valid and ends on " + endSubs + "\n" +
                 "List of borrowed books: \n" + listB;
        else {
            return "Subscription with ID " + idSubscription + " has expired. Please renew. \n"+
                    "List of borrowed books: \n" + listB;
        }

    }


}
