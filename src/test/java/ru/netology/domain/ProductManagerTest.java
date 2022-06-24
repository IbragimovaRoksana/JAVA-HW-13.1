package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    Product countMonteCristo = new Book(413, "count Monte Cristo", 1200, "A. Dyuma");
    Product theWitcher = new Book(449, "The Witcher", 1900, "A. Sapkovskiy");
    Product onegin = new Book(404, "Onegin", 780, "A. Pushkin");
    Product gameOfTrones = new Book(425, "Game Of Trones", 2300, "J. Martin");
    Product lordOfTheRings = new Book(490, "Lord Of The Rings", 2400, "J.R. Tolkin");
    Product samsung = new Book(400, "Samsung in the life", 540, "Samseong Gurub");
    Product samsungPhone = new Smartphone(567, "SamsungGalaxyS9Plus", 30000, "Samseong Gurub");
    Product xiaomiF2 = new Smartphone(577, "XiaomiPocoF2Pro", 40000, "Xiaomi Corporation");
    Product xiaomiRedmi9 = new Smartphone(526, "XiaomiRedmi9", 10000, "Xiaomi Corporation");
    Product iPhone = new Smartphone(510, "Iphone6", 20000, "Apple Computer");
    Product zeroPhone = new Smartphone();
    Product zeroBook = new Book();

    @BeforeEach
    void setUp(){
        manager.add(countMonteCristo);
        manager.add(theWitcher);
        manager.add(onegin);
        manager.add(gameOfTrones);
        manager.add(lordOfTheRings);
        manager.add(samsung);
        manager.add(samsungPhone);
        manager.add(xiaomiF2);
        manager.add(xiaomiRedmi9);
        manager.add(iPhone);
    }

    @Test
    void shouldAddProduct(){
        Product[] actual = manager.getAll();
        Product[] expected = new Product[]{countMonteCristo, theWitcher, onegin, gameOfTrones,
                lordOfTheRings, samsung, samsungPhone, xiaomiF2, xiaomiRedmi9, iPhone};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById(){
        manager.removeById(490);
        Product[] actual = manager.getAll();
        Product[] expected = new Product[]{countMonteCristo, theWitcher, onegin, gameOfTrones,
                samsung, samsungPhone, xiaomiF2, xiaomiRedmi9, iPhone};
        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldSearchByNameBook(){
        Product[] actual = manager.searchBy("Onegin");
        Product[] expected = new Product[]{onegin};
        String text = onegin.toString();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNameSmartphone(){
        Product[] actual = manager.searchBy("Iphone6");
        Product[] expected = new Product[]{iPhone};
        String text = iPhone.toString();
        assertArrayEquals(expected, actual);
    }

}