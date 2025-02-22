package com.booleanuk.core;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArticleTest {

    @Test
    public void shouldCheckOutArticleIfAvailable() {
        Library library = new Library();
        Author author = new Author("Petros Mylonas", "Petros.Mylonas@email.com", "www.petrosmylonas.com");
        Article article = new Article("Java for Beginners",author);
        library.addToStock(article);

        Assertions.assertEquals("item has been checked out", library.checkOutItem("Java for Beginners"));
    }

    @Test
    public void shouldDeclineArticleIfNotAvailableToCheckout() {
        Library library = new Library();
        Author author = new Author("Petros Mylonas", "Petros.Mylonas@email.com", "www.petrosmylonas.com");
        Article article = new Article("Java for Beginners",author);
        library.addToStock(article);
        library.checkOutItem("Java for Beginners");

        Assertions.assertEquals("item is currently on loan", library.checkOutItem("Java for Beginners"));
    }

    @Test
    public void shouldCheckInArticleIfOnLoan() {
        Library library = new Library();
        Author author = new Author("Petros Mylonas", "Petros.Mylonas@email.com", "www.petrosmylonas.com");
        Article article = new Article("Java for Beginners",author);
        library.addToStock(article);
        library.checkOutItem("Java for Beginners");

        Assertions.assertEquals("item has been checked in", library.checkInItem("Java for Beginners"));
    }

    @Test
    public void shouldDeclineCheckInArticleIfNotOnLoan() {
        Library library = new Library();
        Author author = new Author("Petros Mylonas", "Petros.Mylonas@email.com", "www.petrosmylonas.com");
        Article article = new Article("Java for Beginners",author);
        library.addToStock(article);

        Assertions.assertEquals("item is not currently on loan", library.checkInItem("Java for Beginners"));
    }
}
