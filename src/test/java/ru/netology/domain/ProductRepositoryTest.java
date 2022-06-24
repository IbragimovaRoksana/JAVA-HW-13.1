package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    Product countMonteCristo = new Book(413, "count Monte Cristo", 1200, "A. Dyuma");
    Product theWitcher = new Book(449, "The Witcher", 1900, "A. Sapkovskiy");
    Product onegin = new Book(404, "Onegin", 780, "A. Pushkin");
    Product gameOfTrones = new Book(354, "Game Of Trones", 2300, "J. Martin");
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
        repository.save(countMonteCristo);
        repository.save(theWitcher);
        repository.save(onegin);
        repository.save(gameOfTrones);
        repository.save(lordOfTheRings);
        repository.save(samsung);
        repository.save(samsungPhone);
        repository.save(xiaomiF2);
        repository.save(xiaomiRedmi9);
        repository.save(iPhone);
    }

    @Test
    void shouldSave(){
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{countMonteCristo, theWitcher, onegin, gameOfTrones,
                lordOfTheRings, samsung, samsungPhone, xiaomiF2, xiaomiRedmi9, iPhone};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById(){
        repository.removeById(400);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{countMonteCristo, theWitcher, onegin, gameOfTrones,
                lordOfTheRings, samsungPhone, xiaomiF2, xiaomiRedmi9, iPhone};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldCatchException(){
        assertThrows(NotFoundException.class, () -> repository.removeById(40));
    }

    @Test
    void shouldAddProductExist(){
        assertThrows(AlreadyExistsException.class, () ->repository.save(onegin));
    }

}