package com.bookstore.admin.book;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.bookstore.admin.book.BookRepository;
import com.bookstore.admin.entity.Book;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class BookRepositoryTest {
	@Autowired
	private BookRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateNewBook() {
		Book book1 = new Book("All The Light We Cannot See");

		Book savedBook = repo.save(book1);

		assertThat(savedBook.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testListAllBooks() {
		Iterable<Book> listBooks = repo.findAll();
		listBooks.forEach(book -> System.out.println(book));
	}
	
	@Test
	public void testGetBookById() {
		Book book = repo.findById(1).get();
		System.out.println(book);
		assertThat(book).isNotNull();
	}
	
	@Test
	public void testUpdateBookDetails() {
		Book book = repo.findById(1).get();
		book.setName("Heartstopper");

		repo.save(book);
	}
	
	@Test
	public void testDeleteBook() {
		Integer bookId = 3;
		System.out.println();
		System.out.println();
		repo.deleteById(bookId);

	}
}
