import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Book[] books = new Book[10];
        books[0] = new ProgrammingBook("01", "CSS", 24.99, "Mr.John", "English", "ada");
        books[1] = new ProgrammingBook("02", "C++", 42.99, "Mr.Smith", "English", "dome");
        books[2] = new ProgrammingBook("03", "Java", 39.99, "Mr.William", "Java", "cold");
        books[3] = new ProgrammingBook("04", "JavaScript", 34.99, "Miss.Anna", "English", "meal");
        books[4] = new ProgrammingBook("05", "C", 19.99, "Miss.Rose", "English", "fish");
        books[5] = new FictionBook("06", "The Martian", 19.99, "Ridley Scott", "fiction");
        books[6] = new FictionBook("07", "Ex Machina", 9.99, "Alex Garland", "fiction");
        books[7] = new FictionBook("08", "Pacific Rim", 14.99, "Guillermo Del Toro", "fiction");
        books[8] = new FictionBook("09", "Interstellar", 19.99, "Christopher Nolan", "fiction");
        books[9] = new FictionBook("10", "Inception", 19.99, "Christopher Nolan", "fiction");

        for (Book book : books) {
            if (book instanceof ProgrammingBook) {
                System.out.println(book);
            } else {
                System.out.println(book);
            }
        }
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the language: ");
        String language = input.nextLine();
        System.out.println("Enter the category: ");
        String category = input.nextLine();
        System.out.println("Total of 10 books are: " + Total(books) +"$");
        System.out.println("The number of books whose language is " + language + ": " + Java(books, language));
        System.out.println("The number of books whose category is " + category + ": " + Fiction(books, category));
        System.out.println("Number of books priced less than 100: " + Price(books));
    }

    public static double Total(Book[] arr) {
        double total = 0;
        for (Book i: arr) {
            total += i.getPrice();
        }
        return Math.round(total);
    }

    public static int Java(Book[] arr, String language) {
        int count = 0;
        for (Book i: arr) {
            if (i instanceof ProgrammingBook && ((ProgrammingBook) i).getLanguage().equals(language)) {
                count++;
            }
        }
        return count;
    }

    public static int Fiction(Book[] arr, String category) {
        int count = 0;
        for (Book i: arr) {
            if (i instanceof FictionBook && ((FictionBook) i).getCategory().equals(category)) {
                count++;
            }
        }
        return count;
    }

    public static int Price(Book[] arr) {
        int count = 0;
        for (Book i: arr) {
            if(i instanceof FictionBook && i.getPrice() < 100) {
                count++;
            }
        }
        return count;
    }
}