package com.example.graphql.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

import java.time.LocalDate


@Entity
class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id

    String name

    LocalDate dateOfBirth


    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    LocalDate getDateOfBirth() {
        return dateOfBirth
    }

    void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth
    }

    Author(String name, LocalDate dateOfBirth) {
        this.name = name
        this.dateOfBirth = dateOfBirth
    }

    Author() {
    }
}
