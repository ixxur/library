package files;

import classes.*;
import classes.Reader;

import java.io.*;
import java.util.ArrayList;

import static files.WriteInCSV.timeStamp;

public class ReadFromCSV {
    private static ReadFromCSV instance;

    private ReadFromCSV() throws FileNotFoundException {
    }

    public static ReadFromCSV getInstance() throws FileNotFoundException {
        if (instance == null)
            instance = new ReadFromCSV();
        return instance;
    }

    public static void readFromReader(ArrayList<Reader> readerList){
        String fileName = "src\\files\\Reader.csv";
        BufferedReader fileReader = null;
        try {
            fileReader = new BufferedReader(new FileReader(fileName));
            fileReader.readLine();
            String line = "";
            while ((line = fileReader.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length > 0) {
                    Reader reader = new Reader(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4]);
                    readerList.add(reader);
                }
            }
            //for (Reader reader : readerList) {
            //    System.out.println(reader.toString());
            //}
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        timeStamp("Read from Reader.csv");

    }

    public static void readFromAuthor(ArrayList<Author> authorList) {

        String fileName = "src\\files\\Author.csv";
        BufferedReader fileReader = null;
        try {
            fileReader = new BufferedReader(new FileReader(fileName));
            fileReader.readLine();
            String line = "";
            while ((line = fileReader.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length > 0) {
                    Author author = new Author(tokens[0], tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4], tokens[5], Double.parseDouble(tokens[6]));
                    authorList.add(author);
                }
            }
         //   for (Author author : authorList) {
          //      System.out.println(author.toString());

            } catch (FileNotFoundException e) {
            e.printStackTrace();
            } catch (IOException e) {
            e.printStackTrace();
        }
        timeStamp("Read from Author.csv");
    }

    public static void readFromEbook(ArrayList<Ebook> ebookList, ArrayList<Author> authorList) {

        String fileName = "src\\files\\Ebook.csv";
        BufferedReader fileReader = null;
        try {
            fileReader = new BufferedReader(new FileReader(fileName));
            fileReader.readLine();
            String line = "";
            while ((line = fileReader.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length > 0) {
                    Author a = new Author();
                    for(Author author : authorList){
                        String name = author.getFirstName() + " " + author.getLastName();
                        if (tokens[1].equals(name))
                            a = new Author(author);
                        break;
                    }
                    Book ebook = new Ebook(tokens[0], a, tokens[2], Double.parseDouble(tokens[3]), Boolean.parseBoolean(tokens[4]), tokens[5], Double.parseDouble(tokens[6]), Double.parseDouble(tokens[7]));
                    ebookList.add((Ebook)ebook);
                }
            }
            //for(Ebook ebook : ebookList.subList(0,ebookList.size()/2))
             //   System.out.println(ebook.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        timeStamp("Read from Ebook.csv");
    }

    public static void readFromAudioBook (ArrayList<AudioBook> audioBookList, ArrayList<Author> authorList){
        String fileName = "src\\files\\AudioBook.csv";
        BufferedReader fileReader = null;
        try {
            fileReader = new BufferedReader(new FileReader(fileName));
            fileReader.readLine();
            String line = "";
            while ((line = fileReader.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length > 0) {
                    Author a = new Author();
                    for(Author author : authorList){
                        String name = author.getFirstName() + " " + author.getLastName();
                        if (tokens[1].equals(name))
                            a = new Author(author);
                        break;
                    }
                    Book audiobook = new AudioBook(tokens[0], a, tokens[2], Double.parseDouble(tokens[3]), Boolean.parseBoolean(tokens[4]), tokens[5], Double.parseDouble(tokens[6]), Double.parseDouble(tokens[7]), Double.parseDouble(tokens[8]));
                    audioBookList.add((AudioBook)audiobook);
                }
            }
          //  for(AudioBook audioBook : audioBookList.subList(0,audioBookList.size()/2))
          //      System.out.println(audioBook.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        timeStamp("Read from Audiobook.csv");

    }

    public static void readFromPublishedEdition (ArrayList<PublishedEdition> publishedEditions, ArrayList<Author> authorList){

        String fileName = "src\\files\\PublishedEdition.csv";
        BufferedReader fileReader = null;
        try {
            fileReader = new BufferedReader(new FileReader(fileName));
            fileReader.readLine();
            String line = "";
            while ((line = fileReader.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length > 0) {
                    Author a = new Author();
                    for(Author author : authorList){
                        String name = author.getFirstName() + " " + author.getLastName();
                        if (tokens[1].equals(name))
                            a = new Author(author);
                        break;
                    }
                    Book publishedEdition = new PublishedEdition(tokens[0], a, tokens[2], Double.parseDouble(tokens[3]), Boolean.parseBoolean(tokens[4]), tokens[5], Integer.parseInt(tokens[6]), tokens[7]);
                    publishedEditions.add((PublishedEdition) publishedEdition);
                }
            }
           // for(PublishedEdition publishedEdition : publishedEditions.subList(0,publishedEditions.size()/2))
           //     System.out.println(publishedEdition.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        timeStamp("Read from PublishedEdition.csv");
    }

}

