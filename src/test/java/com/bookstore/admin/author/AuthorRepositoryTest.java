package com.bookstore.admin.author;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.bookstore.admin.entity.Author;
import com.bookstore.admin.entity.Book;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class AuthorRepositoryTest {
	@Autowired
	private AuthorRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateNewAuthor() {
		Author book1 = new Author("Alice Oseman");

		Author savedBook = repo.save(book1);

		assertThat(savedBook.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testListAllAuthors() {
		Iterable<Author> listBooks = repo.findAll();
		listBooks.forEach(author -> System.out.println(author));
	}

	@Test
	public void testGetAuthorById() {
		Author author = repo.findById(3).get();
		System.out.println(author);
		assertThat(author).isNotNull();
	}
	
	@Test
	public void testUpdateAuthorDetails() {
		Author author = repo.findById(5).get();
		author.setName("Heartstopper");

		repo.save(author);
	}
	
	@Test
	public void testDeleteAuthor() {
		Integer authorId = 5;
		repo.deleteById(authorId);

	}
}
