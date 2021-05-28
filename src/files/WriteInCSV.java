package files;

import classes.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Timestamp;

public class WriteInCSV {
    private static WriteInCSV instance;
     private WriteInCSV() {
    }

    public static WriteInCSV getInstance(){
         if(getInstance() == null)
             instance = new WriteInCSV();
         return instance;
    }

    public static void timeStamp(String actionName){

        try{
            File file = new File("src\\files\\Reader.csv");
            boolean ok = file.isFile();
            FileWriter fileWriter = new FileWriter("src\\files\\Reader.csv", true);

            if(!ok) {
                String fileHeader = "actionName,dateAndTime\n";
                fileWriter.append(fileHeader.toString() + "\n");
            }
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            fileWriter.append(actionName.toString());
            fileWriter.append(",");
            fileWriter.append(timestamp.toString());
            fileWriter.append("\n");

            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeInReader (ArrayList<Reader>readerList){
        String fileHeader = "firstName,lastName,CNP,nrTel,mail";

        try{
            FileWriter fileWriter = new FileWriter("src\\files\\Reader.csv");
            fileWriter.append(fileHeader.toString() + "\n");
            for(Reader reader : readerList){
                fileWriter.append(String.valueOf(reader.getFirstName()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(reader.getLastName()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(reader.getCNP()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(reader.getNrTel()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(reader.getMail()));
                fileWriter.append("\n");
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        timeStamp("Wrote in Reader.csv");

    }

    public static void writeInAuthor(ArrayList<Author> authorList){

         String fileHeader = "firstName,lastName,bDay,bMonth,bYear,dDay,dMonth,dYear,description,rating";

         try{
             FileWriter fileWriter = new FileWriter("src\\files\\Author.csv");
             fileWriter.append(fileHeader.toString() + "\n");
             for(Author author : authorList){
                 fileWriter.append(String.valueOf(author.getFirstName()));
                 fileWriter.append(",");
                 fileWriter.append(String.valueOf(author.getLastName()));
                 fileWriter.append(",");
                 fileWriter.append(String.valueOf(author.getBirthDay()));
                 fileWriter.append(",");
                 fileWriter.append(String.valueOf(author.getDeathDay()));
                 fileWriter.append(",");
                 fileWriter.append(String.valueOf(author.getDescription()));
                 fileWriter.append(",");
                 fileWriter.append(String.valueOf(author.getRating()));
                 fileWriter.append("\n");
             }
             fileWriter.flush();
             fileWriter.close();
         } catch (IOException e) {
             e.printStackTrace();
         }
        timeStamp("Wrote in Author.csv");
    }

    public static void writeInAudioBook(ArrayList<AudioBook> audioBooks){

         String fileHeader = "title,author,category,rating,availability,url,price,size,duration";
        try{
            FileWriter fileWriter = new FileWriter("src\\files\\AudioBook.csv");
            fileWriter.append(fileHeader.toString() + "\n");
            for(AudioBook audioBook : audioBooks){
                fileWriter.append(String.valueOf(audioBook.getTitle()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(audioBook.getAuthor()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(audioBook.getCategory()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(audioBook.getRating()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(audioBook.isAvailable()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(audioBook.getUrlAddress()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(audioBook.getPrice()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(audioBook.getSizeInMb()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(audioBook.getDurationInHours()));
                fileWriter.append("\n");
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        timeStamp("Wrote in AudioBook.csv");
    }

    public static void writeInEbook(ArrayList<Ebook> Ebooks){

         String fileHeader = "title,author,category,rating,availability,url,price,size";
        try{
            FileWriter fileWriter = new FileWriter("src\\files\\Ebook.csv");
            fileWriter.flush();
            fileWriter.append(fileHeader.toString() + "\n");
            for(Ebook ebook : Ebooks){
                fileWriter.append(String.valueOf(ebook.getTitle()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(ebook.getAuthor()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(ebook.getCategory()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(ebook.getRating()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(ebook.isAvailable()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(ebook.getUrlAddress()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(ebook.getPrice()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(ebook.getSizeInMb()));
                fileWriter.append("\n");
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        timeStamp("Wrote in Ebook.csv");
     }

     public static void writeInPublishedEdition(ArrayList<PublishedEdition> publishedEditions){

         String fileHeader = "title,author,category,rating,availability,edition,pagesNumber,publishingYear\n";
         try{
             FileWriter fileWriter = new FileWriter("src\\files\\PublishedEdition.csv");
             fileWriter.append(fileHeader.toString());
             for(PublishedEdition book : publishedEditions){
                 fileWriter.append(String.valueOf(book.getTitle()));
                 fileWriter.append(",");
                 fileWriter.append(String.valueOf(book.getAuthor()));
                 fileWriter.append(",");
                 fileWriter.append(String.valueOf(book.getCategory()));
                 fileWriter.append(",");
                 fileWriter.append(String.valueOf(book.getRating()));
                 fileWriter.append(",");
                 fileWriter.append(String.valueOf(book.isAvailable()));
                 fileWriter.append(",");
                 fileWriter.append(String.valueOf(book.getEdition()));
                 fileWriter.append(",");
                 fileWriter.append(String.valueOf(book.getPagesNumber()));
                 fileWriter.append(",");
                 fileWriter.append(String.valueOf(book.getPublishingYear()));
                 fileWriter.append("\n");
             }

             fileWriter.flush();
             fileWriter.close();


         } catch (IOException e) {
             e.printStackTrace();
         }
         timeStamp("Wrote in PublishedEdition.csv");
     }


}
