package pat刷题.DigitalLibrary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Book {
    public String digitIDNumber;
    public String bookTitle;
    public String author;
    public String[] keyWords;
    public String publisher;
    public String publishedYear;

    public Book() {
    }

    @Override
    public String toString() {
        return "book{" +
                "digitIDNumber='" + digitIDNumber + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                ", author='" + author + '\'' +
                ", keyWords=" + Arrays.toString(keyWords) +
                ", publisher='" + publisher + '\'' +
                ", publishedYear=" + publishedYear +
                '}';
    }

    public boolean includeKeyWords(String key) {
        for (String keyWord : keyWords) {
            if (keyWord.equals(key))
                return true;
        }
        return false;
    }

    public boolean judgeTheSame(String s) {
        if (digitIDNumber.equals(s) || bookTitle.equals(s) ||
        author.equals(s) || includeKeyWords(s) || publisher.equals(s)
        || publishedYear.equals(s))
            return true;
        return false;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numOfGroup = Integer.parseInt(br.readLine());
        Book[] books = new Book[numOfGroup];
        for (int i = 0; i < numOfGroup; i++) {
            Book book = new Book();
            books[i] = book;
            books[i].digitIDNumber = br.readLine();
            books[i].bookTitle = br.readLine();
            books[i].author = br.readLine();
            books[i].keyWords = br.readLine().split(" ");
            books[i].publisher = br.readLine();
            books[i].publishedYear = br.readLine();
        }

        int numOfTest = Integer.parseInt(br.readLine());
        for (int i = 0; i < numOfTest; i++) {
            String s = br.readLine();
            if (books[i].judgeTheSame(s.substring(3)))
                System.out.println(books[i].digitIDNumber);
        }
    }
}
