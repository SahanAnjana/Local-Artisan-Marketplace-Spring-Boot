package lk.ac.vau.fas.artisanMarketplace.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
@Entity
public class User extends Person {
	
	@OneToOne(mappedBy = "user")
	private Cart cart;
	
	@OneToMany(mappedBy = "user")
	private List<Orders> orders;
	@ManyToMany(mappedBy = "user")
	private List<Product> favorite;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Cart cart, List<Orders> orders, List<Product> favorite) {
		super();
		this.cart = cart;
		this.orders = orders;
		this.favorite = favorite;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	public List<Product> getFavorite() {
		return favorite;
	}
	public void setFavorite(List<Product> favorite) {
		this.favorite = favorite;
	}
	
	
}
