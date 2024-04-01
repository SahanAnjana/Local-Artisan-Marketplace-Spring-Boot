package lk.ac.vau.fas.artisanMarketplace.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
@Entity
public class Artist extends Person {
	private String bio;
	@OneToMany(mappedBy = "artist")
	private List<Product> products;
	@JsonIgnore
	@ManyToMany(mappedBy = "artists")
    private List<Event> events;
	public Artist() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Artist(String bio, List<Product> products, List<Event> events) {
		super();
		this.bio = bio;
		this.products = products;
		this.events = events;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public List<Event> getEvents() {
		return events;
	}
	public void setEvents(List<Event> events) {
		this.events = events;
	}
    
}
