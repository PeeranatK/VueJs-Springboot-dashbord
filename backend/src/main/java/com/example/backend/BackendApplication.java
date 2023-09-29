package com.example.backend;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	public class Book {
        private Integer id = 1;
        private String title = "title";
        private String author = "author";

        public String getTitle() {
			return title;
		}
		public Integer getId() {
			return id;
		}
		public String getAuthor() {
			return author;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
    }

	@GetMapping("/hello")
	public List<Book> hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		List<Book> books = new ArrayList<>();
		Book book1 = new Book();
		Book book2 = new Book();
		book2.setId(2);
		book2.setAuthor("name");

		books.add(book1);
		books.add(book2);

      	return books;
    }

	@Autowired
	private TestQuery testQuery;

	@GetMapping("/Test")
	public List<TestEntity> test() {
		List<TestEntity> testEntity = new ArrayList<TestEntity>();
		testQuery.findAll().forEach(testEntity::add);
      	return testEntity;
    }
}
