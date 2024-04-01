package lk.ac.vau.fas.artisanMarketplace.models;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Temporal(TemporalType.TIMESTAMP)
    private Timestamp placedTime;
    private BigDecimal totalprice;
    private int quantity;
    @JsonIgnore
    @ManyToOne
    private User user;
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Orders(Long id, User user, Timestamp placedTime, BigDecimal totalprice, Integer quantity) {
		super();
		this.id = id;
		this.user = user;
		this.placedTime = placedTime;
		this.totalprice = totalprice;
		this.quantity = quantity;
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
	public Timestamp getPlacedTime() {
		return placedTime;
	}
	public void setPlacedTime(Timestamp placedTime) {
		this.placedTime = placedTime;
	}
	public BigDecimal getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(BigDecimal totalprice) {
		this.totalprice = totalprice;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
    
}
