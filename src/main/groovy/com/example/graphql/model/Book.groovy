package com.example.graphql.model

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany


@Entity
class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id

    String name;

    @Column(name="Year of Release")
    int yearOfRelease

    Book() {
    }

    Book(String name, int yearOfRelease, String publisherName, List<Author> authors) {
        this.name = name
        this.yearOfRelease = yearOfRelease
        this.publisherName = publisherName
        this.authors = authors
    }
    String publisherName


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    List<Author> authors
}
