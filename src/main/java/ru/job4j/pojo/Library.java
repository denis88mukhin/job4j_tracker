package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean Code", 300);
        Book investing = new Book("Investing", 1000);
        Book java = new Book("Philosophy Java", 500);
        Book player = new Book("Player", 250);
        Book[] books = new Book[4];
        books[0] = cleanCode;
        books[1] = investing;
        books[2] = java;
        books[3] = player;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " - " + book.getPages() + " pages.");
        }
        Book temp = new Book("", 0);
        temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        System.out.println("Change book places 0 to 3 and 3 to 0.");
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " - " + book.getPages() + " pages.");
        }
        System.out.println("Show only books.name == \"Clean code\"");
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            if ("Clean Code".equals(book.getName())) {
                System.out.println(book.getName() + " - " + book.getPages() + " pages.");
            }
        }
    }
}
