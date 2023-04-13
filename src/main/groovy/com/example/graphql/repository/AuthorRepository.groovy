package com.example.graphql.repository

import com.example.graphql.model.Author
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorRepository extends JpaRepository<Author, Long>{

}