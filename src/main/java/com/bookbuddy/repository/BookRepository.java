package com.bookbuddy.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bookbuddy.domain.Author;
import com.bookbuddy.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	Book findByTitleContainingIgnoreCase(String bookTitle);
	List<Book> findByGenreContainingIgnoreCase(String genre);	
	List<Book> findByAuthor(Author author);
}