package com.example.graphql.controller

import com.example.graphql.model.Author
import com.example.graphql.model.Book
import com.example.graphql.repository.AuthorRepository
import com.example.graphql.repository.BookReporsitory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

import java.time.LocalDate


class BookInput{
    String name
    int yearOfRelease
    String publisherName
    String authorName
    String authorDob

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    int getYearOfRelease() {
        return yearOfRelease
    }

    void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease
    }

    String getPublisherName() {
        return publisherName
    }

    void setPublisherName(String publisherName) {
        this.publisherName = publisherName
    }

    String getAuthorName() {
        return authorName
    }

    void setAuthorName(String authorName) {
        this.authorName = authorName
    }

    String getAuthorDob() {
        return authorDob
    }

    void setAuthorDob(String authorDob) {
        this.authorDob = authorDob
    }

    BookInput(String name, int yearOfRelease, String publisherName, String authorName, String authorDob) {
        this.name = name
        this.yearOfRelease = yearOfRelease
        this.publisherName = publisherName
        this.authorName = authorName
        this.authorDob = authorDob
    }

    BookInput() {
    }
}

@RestController
class appController {

    @Autowired
    private BookReporsitory bookReporsitory

    @Autowired
    private AuthorRepository authorRepository

    @QueryMapping
    List<Book> books(){
        return bookReporsitory.findAll();
    }

    @QueryMapping
    Book bookById(@Argument Long id){
        return bookReporsitory.findById(id).orElse(
                new Book(
                        "No Book",
                        2023,
                        "Amelia",
                        List.of(
                                new Author(
                                        "Barath",
                                        LocalDate.of(1999, 5, 31)
                                )
                        )
                )
        )
    }


    @MutationMapping
    Book addBook(@Argument BookInput book){
        Author author = new Author(
                book.getAuthorName(),
                LocalDate.parse(book.getAuthorDob())
        )
        Book newBook = new Book(
                book.getName(),
                book.getYearOfRelease(),
                book.getPublisherName(),
                List.of(author)
        )
        return bookReporsitory.save(newBook)
    }

    @GetMapping("/")
    List<Book> getBooks(){
        return bookReporsitory.findAll();
    }


}

