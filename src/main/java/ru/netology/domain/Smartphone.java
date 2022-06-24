package ru.netology.domain;

public class Smartphone extends Product{
    private String produce;

    public Smartphone() {
        super();
    }

    public Smartphone(int id, String name, int price, String produce) {
        super(id, name, price);
        this.produce = produce;
    }

    public String getProduce() {
        return produce;
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", price=" + super.getPrice() + '\'' +
                ", produce='" + getProduce() + '\'' +
                '}';
    }
}
