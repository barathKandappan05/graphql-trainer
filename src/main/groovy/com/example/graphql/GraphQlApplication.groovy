package com.example.graphql

import com.example.graphql.model.Author
import com.example.graphql.model.Book
import com.example.graphql.repository.BookReporsitory
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

import java.time.LocalDate

@SpringBootApplication
class GraphQlApplication {

	static void main(String[] args) {
		SpringApplication.run(GraphQlApplication, args)
	}

    @Bean
    ApplicationRunner applicationRunner(BookReporsitory bookReporsitory) {
        return (args) ->
                bookReporsitory.save(new Book(
                        "Java JPA",
                        2022,
                        "Amelia",
                        List.of(
                                new Author(
                                        "Vishal",
                                        LocalDate.of(1970, 1, 1)
                                ),
                                new Author(
                                        "Puru",
                                        LocalDate.of(1980, 1, 1)
                                )
                        )
                ))
    }

}
