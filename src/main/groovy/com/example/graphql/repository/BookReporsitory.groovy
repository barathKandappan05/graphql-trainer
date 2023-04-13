package com.example.graphql.repository

import com.example.graphql.model.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface BookReporsitory extends JpaRepository<Book, Long>{
}