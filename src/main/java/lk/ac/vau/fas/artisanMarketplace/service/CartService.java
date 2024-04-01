package lk.ac.vau.fas.artisanMarketplace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.ac.vau.fas.artisanMarketplace.models.Cart;
import lk.ac.vau.fas.artisanMarketplace.repo.CartRepo;
@Service
public class CartService extends GenericService<Cart, Long>{
	@Autowired
	private CartRepo repo;
	
	public Cart cartByUid(int uid) {
		return repo.getCart(uid);
	}
}
