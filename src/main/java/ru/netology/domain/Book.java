package ru.netology.domain;

public class Book extends Product{
    private String author;

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

    public Book() {
        super();
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + super.getId() +
                ", name='" + super.getName() +
                ", price=" + super.getPrice() +
                ", author='" + getAuthor() +
                "'}";
    }
}
