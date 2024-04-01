package lk.ac.vau.fas.artisanMarketplace.models;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@JsonIgnore
	@OneToOne
    private User user;
    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItem;
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(Long id, User user, List<CartItem> cartItem) {
		super();
		this.id = id;
		this.user = user;
		this.cartItem = cartItem;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<CartItem> getCartItem() {
		return cartItem;
	}
	public void setCartItem(List<CartItem> cartItem) {
		this.cartItem = cartItem;
	}
	
	
}
