package com.bookstore.admin.genre;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.bookstore.admin.entity.Genre;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)

public class GenreRepositoryTest {
	
@Autowired
private GenreRepository repo;

@Autowired
private TestEntityManager entityManager;

@Test
	public void testCreateNewGenre() {
		Genre book1 = new Genre("Fiction");

		Genre savedBook = repo.save(book1);

		assertThat(savedBook.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testListAllGenre() {
		Iterable<Genre> listBooks = repo.findAll();
		listBooks.forEach(genre -> System.out.println(genre));
	}

	@Test
	public void testGetGenreById() {
		Genre genre = repo.findById(1).get();
		System.out.println(genre);
		assertThat(genre).isNotNull();
	}
	
	@Test
	public void testUpdateGenreDetails() {
		Genre genre = repo.findById(1).get();
		genre.setName("Heartstopper");

		repo.save(genre);
	}
	
	@Test
	public void testDeleteGenre() {
		Integer genreId = 3;
		repo.deleteById(genreId);

	}

}
