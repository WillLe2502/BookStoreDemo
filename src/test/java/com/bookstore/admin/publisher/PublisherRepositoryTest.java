package com.bookstore.admin.publisher;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.bookstore.admin.entity.Genre;
import com.bookstore.admin.entity.Publisher;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)

public class PublisherRepositoryTest {
	
	@Autowired
	private PublisherRepository repo;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void testCreateNewGenre() {
		Publisher book1 = new Publisher("Fiction");

		Publisher savedBook = repo.save(book1);

		assertThat(savedBook.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testListAllGenre() {
		Iterable<Publisher> listPublishers = repo.findAll();
		listPublishers.forEach(publisher -> System.out.println(publisher));
	}

	@Test
	public void testGetGenreById() {
		Publisher publisher = repo.findById(1).get();
		System.out.println(publisher);
		assertThat(publisher).isNotNull();
	}
	
	@Test
	public void testUpdateGenreDetails() {
		Publisher publisher = repo.findById(1).get();
		publisher.setName("Heartstopper");

		repo.save(publisher);
	}
	
	@Test
	public void testDeleteGenre() {
		Integer publisherId = 3;
		repo.deleteById(publisherId);

	}

}
