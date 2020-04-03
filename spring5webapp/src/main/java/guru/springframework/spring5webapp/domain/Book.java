package guru.springframework.spring5webapp.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	private String title;
	private String isbn;
	
	@ManyToOne
	@JoinColumn(name= "publisher_id")
	private Publisher publisher;
	
	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@ManyToMany
	@JoinTable(name= "author_book", joinColumns= @JoinColumn(name= "book_id"),
	inverseJoinColumns= @JoinColumn(name= "author_id"))
	private Set<Author> authors= new HashSet<>();
	
	public Book(String title, String isbn) {
		super();
		this.title = title;
		this.isbn = isbn;
		//this.authors = authors;
	}

	public Book() {}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
