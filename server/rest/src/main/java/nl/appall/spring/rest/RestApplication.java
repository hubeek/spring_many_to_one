package nl.appall.spring.rest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}

	@Bean
	public CommandLineRunner mappingDemo(BookRepository bookRepository,
										 PageRepository pageRepository) {
		return args -> {

			// create a new book
			Book book = new Book("Java 101", "John Doe", "123456");

			// save the book
			bookRepository.save(book);
			pageRepository.save(new Page(65, "Java 8 contents", "Java 8", book));
			pageRepository.save(new Page(95, "Concurrency contents", "Concurrency", book));
		};
	}
}
