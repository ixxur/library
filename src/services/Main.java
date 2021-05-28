package services;

import classes.*;
import crud.DeleteMethods;
import crud.InsertMethods;
import crud.SelectMethods;
import crud.UpdateMethods;
import files.ReadFromCSV;
import files.WriteInCSV;

import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;




public class Main {

    public static void main(String[] args) throws ParseException, IOException, SQLException {

      //Creating the object with which we are going to call the methods from Service Class
        Service service = new Service();

        //======Creating arrays for every object type=====

        ArrayList<Reader> readerList = new ArrayList<Reader>();
        ArrayList<Author> authorList = new ArrayList<Author>();
        ArrayList<Book> bookList = new ArrayList<Book>();
        ArrayList<PublishedEdition> publsihedList = new ArrayList<PublishedEdition>();
        ArrayList<Ebook> ebookList = new ArrayList<Ebook>();
        ArrayList<AudioBook> audioBookList = new ArrayList<AudioBook>();
        ArrayList<Subscription> subscriptionList = new ArrayList<Subscription>();

        //======Creating customers and adding information to them=======

        Reader r1 = new Reader("Maria", "Popescu", "10092324", "078264234", "jf@gmail.com");
        Reader r2 = new Reader("Dragos", "Ionita", "828740740", "07982747", "khgbfer@fmsf.vo");
        Reader r3 = new Reader("Ruxandra", "Oprea", "923740275", "07274624", "jbfkbwf@com.com");
        Reader r4 = new Reader("Ana", "Popescu", "192301823", "0723648234", "sjnfkjsc@yahoo.cm");
        Reader r5 = new Reader("Marius", "Manolache", "923041048", "07287648", "jffjwf@marius");
        Reader r6 = new Reader("Izabel","Ionescu","827348782","07364536273","afcnksefd@tt.to");

        readerList.add(r1);
        readerList.add(r2);
        readerList.add(r3);
        readerList.add(r4);
        readerList.add(r5);
        readerList.add(r6);

        //=======Creating authors and adding information to them========

        Author a1 = new Author("Liviu", "Rebreanu",1, "1885-11-27","1944-09-01", "was a romanian novelist - playwright and journalist", 3.0);
        Author a2 = new Author("Ion", "Creanga",2, "1837-03-01", "1889-12-31", "was a romanian writer - raconteur and schoolteacher", 4.2);
        Author a3 = new Author("Mircea", "Cartarescu",3, "1956-06-01", null, "is a romanian novelist - poet - literary critic", 3.8);
        Author a4 = new Author("George S", "Clason",4, "1874-11-07","1957-04-07", "was an american author", 4.1);
        Author a6 = new Author("J.K.", "Rowling",6, "1965-07-31", null, "is a british author and philanthropist", 5.0);
        Author a7 = new Author("Mihai", "Eminescu",7, "1850-01-15","1889-06-15", "was the most famous and influential Romanian poet", 4.7);

        authorList.add(a1);
        authorList.add(a2);
        authorList.add(a3);
        authorList.add(a4);
        authorList.add(a6);
        authorList.add(a7);

        //=======Creating books/ebooks/audiobooks/published books and adding information to them======

        Book b1 = new PublishedEdition("Ion", a1, "realism", 2.2, true, "principesa", 399, "1920");
        Book b2 = new Ebook("Amintiri din copilarie", a2, "autobiografie", 4.5, true, "www.amintiri.ro", 20.99, 89);
        Book b3 = new AudioBook("Travesti", a3, "jurnal", 3.9, false, "www.travesti.ro", 27.89, 200, 3.7);
        Book b4 = new PublishedEdition("Secretele Sucesului", a4, "dezvoltare personala", 4.8, true, "delfinul de aur", 237, "1936");
        Book b5 = new Ebook("Cel mai bogat om din Babilon", a4, "educatie financiara", 3.7, true, "www.babilon.com", 18.50, 120);
        Book b6 = new AudioBook("Harry Potter", a6, "fiction", 5.0, true, "www.harrypotter.com", 89.99, 620, 39.2);
        Book b7 = new PublishedEdition("Poezii", a7, "poezie", 3.9, true, "pagini de aur", 121, "1879");
        Book b8 = new PublishedEdition("Harap-Alb", a2, "kids", 4.3, true, "principesa", 30, "1877");
        Book b9 = new Ebook("The Art of Public Speaking", a4, "dezvoltare personala", 4.2, true, "www.dale.com", 36.00, 189);
        Book b10 = new AudioBook("Fantastic Beasts and Where to Find Them", a6, "fiction", 4.0, true, "www.fantasticbeasts.com", 140.99, 376, 19.5);

        bookList.add(b1);
        bookList.add(b2);
        bookList.add(b3);
        bookList.add(b4);
        bookList.add(b5);
        bookList.add(b6);
        bookList.add(b7);
        bookList.add(b8);
        bookList.add(b9);
        bookList.add(b10);

        //======Adding the objects to the arrays======
        publsihedList.add((PublishedEdition) b1);
        publsihedList.add((PublishedEdition) b4);
        publsihedList.add((PublishedEdition) b7);
        publsihedList.add((PublishedEdition) b8);
        ebookList.add((Ebook) b2);
        ebookList.add((Ebook) b5);
        ebookList.add((Ebook) b9);
        audioBookList.add((AudioBook) b3);
        audioBookList.add((AudioBook) b6);
        audioBookList.add((AudioBook) b10);

        BorrowedBook bb1 = new BorrowedBook(b1, "2020-08-12", "2020-10-13");
        BorrowedBook bb2 = new BorrowedBook(b4, "2020-01-05", null);
        BorrowedBook bb3 = new BorrowedBook(b2, "2021-03-07", null);
        BorrowedBook bb4 = new BorrowedBook(b3, "2020-12-23", "2021-10-10");
        BorrowedBook bb5 = new BorrowedBook(b5, "2019-03-31", null);
        BorrowedBook bb6 = new BorrowedBook(b6, "2018-08-12", null);
        BorrowedBook bb7 = new BorrowedBook(b7, "2020-12-03", "2020-12-15");
        BorrowedBook bb8 = new BorrowedBook(b8, "2019-07-22", "2019-09-18");
        BorrowedBook bb9 = new BorrowedBook(b9, null, null);
        BorrowedBook bb10 = new BorrowedBook(b10, null, null);

        ArrayList<BorrowedBook> l1 = new ArrayList<BorrowedBook>();
        ArrayList<BorrowedBook> l2 = new ArrayList<BorrowedBook>();
        ArrayList<BorrowedBook> l3 = new ArrayList<BorrowedBook>();
        ArrayList<BorrowedBook> l4 = new ArrayList<BorrowedBook>();
        ArrayList<BorrowedBook> l5 = new ArrayList<BorrowedBook>();

        l1.add(bb1);
        l1.add(bb2);
        l1.add(bb3);
        l2.add(bb3);
        l2.add(bb4);
        l2.add(bb5);
        l3.add(bb6);
        l3.add(bb7);
        l3.add(bb8);
        l4.add(bb9);
        l4.add(bb10);
        l5.add(bb1);
        l5.add(bb7);

        //=====Populating subscription instances======
        Subscription s1 = new Subscription("2021-04-10", "2021-05-10", r1, l1, null, audioBookList);
        Subscription s2 = new Subscription("2020-03-17", "2020-04-17", r2, l2, ebookList, null);
        Subscription s3 = new Subscription("2020-05-28", "2020-06-28", r3, l3, null, null);
        Subscription s4 = new Subscription("2019-09-23", "2019-10-23", r4, l4, null, audioBookList);
        Subscription s5 = new Subscription("2021-03-03", "2021-04-03", r5, l5, ebookList, audioBookList);

        subscriptionList.add(s1);
        subscriptionList.add(s2);
        subscriptionList.add(s4);
        subscriptionList.add(s3);
        subscriptionList.add(s5);


        //****************** OPERATIONS ***********************


        //1******** Display the list of readers in alphabetical order ********
        //service.sortReadersByName(readerList);


        //2******** Check if author already exists in the database *********
        //System.out.println(service.checkAuthor("Ion Creanga",authorList));

        //3******** Display all authors with rating >= 4.5 *********
        //System.out.println(service.topAuthor(authorList));


        //4******** Create new subscription for a new reader ********
        //service.createSubs("18316378163",subscriptionList,readerList);


        //5******** Calculate total amount for a specific subscription ********
        //System.out.println(service.totalPaymentSubscription(5,subscriptionList) + " RON");


        //6******** Sort the books by publishing year in ascending order ********
        //service.sortBooksByYear(publsihedList);


        //7******* Check if reader already exists *********
        //System.out.println(service.checkReader("923740275",readerList));


        //8******* Check if book exists in the library
        //System.out.println(service.checkBookIsInList("Cartea junglei", bookList));


        //9******* Display all books that are part of a certain category *******
        //service.showBooksInCategory("educatie financiara", bookList);


        //10******* Display the readers whom subscription expired ********
        //service.showExpiredSubs(subscriptionList);


        //===========================ETAPA 2==============================

        //WriteInCSV.writeInReader(readerList);
        //WriteInCSV.writeInAuthor(authorList);
        //WriteInCSV.writeInAudioBook(audioBookList);
        //WriteInCSV.writeInEbook(ebookList);
        //WriteInCSV.writeInPublishedEdition(publsihedList);


        //ReadFromCSV.readFromReader(readerList);
        //ReadFromCSV.readFromAuthor(authorList);
        //ReadFromCSV.readFromEbook(ebookList,authorList);
        //ReadFromCSV.readFromAudioBook(audioBookList,authorList);
        ReadFromCSV.readFromPublishedEdition(publsihedList,authorList);


        //==========================ETAPA 3==================================
/*
        ArrayList<Reader> readerList = new ArrayList<Reader>();
        ArrayList<Author> authorList = new ArrayList<Author>();
        ArrayList<PublishedEdition> publsihedList = new ArrayList<PublishedEdition>();
        ArrayList<Ebook> ebookList = new ArrayList<Ebook>();
        ArrayList<AudioBook> audioBookList = new ArrayList<AudioBook>();

        Author a1 = new Author("Liviu", "Rebreanu",1, "1885-11-27","1944-09-01", "was a romanian novelist - playwright and journalist", 3.0);
        Author a2 = new Author("Ion", "Creanga",2, "1837-03-01", "1889-12-31", "was a romanian writer - raconteur and schoolteacher", 4.2);
        Author a3 = new Author("Mircea", "Cartarescu",3,"1956-06-01", null, "is a romanian novelist - poet - literary critic", 3.8);
        Author a4 = new Author("George S", "Clason", 4,"1874-11-07","1957-04-07", "was an american author", 4.1);
        Author a6 = new Author("J.K.", "Rowling",5, "1965-07-31", null, "is a british author and philanthropist", 5.0);
        Author a7 = new Author("Mihai", "Eminescu",6, "1850-01-15","1889-06-15", "was the most famous and influential Romanian poet", 4.7);

        Reader r1 = new Reader("Maria", "Popescu", "10092324", "078264234", "jf@gmail.com");
        Reader r2 = new Reader("Dragos", "Ionita", "828740740", "07982747", "khgbfer@fmsf.vo");
        Reader r3 = new Reader("Ruxandra", "Oprea", "923740275", "07274624", "jbfkbwf@com.com");
        Reader r4 = new Reader("Ana", "Popescu", "192301823", "0723648234", "sjnfkjsc@yahoo.cm");
        Reader r5 = new Reader("Marius", "Manolache", "923041048", "07287648", "jffjwf@marius");
        Reader r6 = new Reader("Izabel","Ionescu","827348782","07364536273","afcnksefd@tt.to");

        readerList.add(r1);
        readerList.add(r2);
        readerList.add(r3);
        readerList.add(r4);
        readerList.add(r5);
        readerList.add(r6);

        Book b1 = new PublishedEdition("Ion", a1, "realism", 2.2, true, "principesa", 399, "1920");
        Book b2 = new Ebook("Amintiri din copilarie", a2, "autobiografie", 4.5, true, "www.amintiri.ro", 20.99, 89);
        Book b3 = new AudioBook("Travesti", a3, "jurnal", 3.9, false, "www.travesti.ro", 27.89, 200, 3.7);
        Book b4 = new PublishedEdition("Secretele Sucesului", a4, "dezvoltare personala", 4.8, true, "delfinul de aur", 237, "1936");
        Book b5 = new Ebook("Cel mai bogat om din Babilon", a4, "educatie financiara", 3.7, true, "www.babilon.com", 18.50, 120);
        Book b6 = new AudioBook("Harry Potter", a6, "fiction", 5.0, true, "www.harrypotter.com", 89.99, 620, 39.2);
        Book b7 = new PublishedEdition("Poezii", a7, "poezie", 3.9, true, "pagini de aur", 121, "1879");
        Book b8 = new PublishedEdition("Harap-Alb", a2, "kids", 4.3, true, "principesa", 30, "1877");
        Book b9 = new Ebook("The Art of Public Speaking", a4, "dezvoltare personala", 4.2, true, "www.dale.com", 36.00, 189);
        Book b10 = new AudioBook("Fantastic Beasts and Where to Find Them", a6, "fiction", 4.0, true, "www.fantasticbeasts.com", 140.99, 376, 19.5);

        publsihedList.add((PublishedEdition) b1);
        publsihedList.add((PublishedEdition) b4);
        publsihedList.add((PublishedEdition) b7);
        publsihedList.add((PublishedEdition) b8);
        ebookList.add((Ebook) b2);
        ebookList.add((Ebook) b5);
        ebookList.add((Ebook) b9);
        audioBookList.add((AudioBook) b3);
        audioBookList.add((AudioBook) b6);
        audioBookList.add((AudioBook) b10);

        InsertMethods insert = new InsertMethods();
        SelectMethods select = new SelectMethods();
        DeleteMethods delete = new DeleteMethods();
        UpdateMethods update = new UpdateMethods();

          delete.deleteAuthor(5);
*/
    }
}
