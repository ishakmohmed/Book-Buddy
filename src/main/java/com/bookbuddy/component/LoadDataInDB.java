package com.bookbuddy.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.bookbuddy.domain.Author;
import com.bookbuddy.domain.Book;
import com.bookbuddy.repository.AuthorRepository;

@Component
public class LoadDataInDB implements CommandLineRunner {
	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public void run(String... args) throws Exception {
		if (authorRepository.count() > 0) return;
		
		Author author1 = new Author("Elon", "Musk");
		Book book1 = new Book("Behind The Scenes", "Biography", 2021);
		
		book1.setSummary("Following info is fake. Behind The Scenes by Elon Musk is a book published by Elon Musk"
				+ " in 2021 in which he talks about his ups and downs before building Tesla.");
		
		Book book2 = new Book("Java is Scary", "Horror", 2020);
		
		book2.setSummary("Following info is fake. Java is Scary is a book published by Elon Musk in 2020"
				+ " in which he narrated how Java (a programming language) intimidated him as it was"
				+ " so difficult to be understood.");

		author1.addBook(book1);
		author1.addBook(book2);
		authorRepository.save(author1);

		Author author2 = new Author("Mohmed", "Ishak");
		Book book3 = new Book("Deanne", "Drama", 2019);
		
		book3.setSummary(
				"Following info is fake. Deanne is a book written by Mohmed Ishak in 2019. It is about Deanne, a teenager from Sabah,"
						+ " Malaysia who struggles with loads of homework by her lecturer. The situation escalates from here to making"
						+ " dishonest moves such as bribing lecturers to grade her well and much more.");
		
		Book book4 = new Book("Twin Towers Tragedy", "Tragedy", 2022);
		
		book4.setSummary("Following info is fake. Twin Towers Tragedy is a book written by Mohmed Ishak in 2022 in which"
				+ " he describes the chronology of how the Petronas Twin Towers in Kuala Lumpur, Malaysia collapsed on"
				+ " May 2022.");

		author2.addBook(book3);
		author2.addBook(book4);
		authorRepository.save(author2);

		Author author3 = new Author("Najib", "Razak");
		Book book5 = new Book("Malaysia", "Novel", 2017);
		
		book5.setSummary(
				"Following info is fake. Malaysia is a novel written by Najib Razak in 2017 which contains"
						+ " 99 success stories of Malaysians who started off with humble beginnings.");
		
		Book book6 = new Book("Jack and Jill", "Novel", 2018);
		
		book6.setSummary(
				"Following info is fake. Jack and Jill is a novel written by Najib Razak in 2018 which is a story"
						+ " about Jack and Jill who were best friends and took their relationships ultimately to marriage.");
		
		author3.addBook(book5);
		author3.addBook(book6);
		authorRepository.save(author3);
	}
}