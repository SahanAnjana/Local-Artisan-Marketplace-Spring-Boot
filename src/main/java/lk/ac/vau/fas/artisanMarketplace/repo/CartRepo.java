package lk.ac.vau.fas.artisanMarketplace.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import lk.ac.vau.fas.artisanMarketplace.models.Cart;
@Repository
public interface CartRepo extends GenericRepo<Cart,Long> {
	@Query("SELECT c FROM Cart c WHERE user.id = ?1")
	public Cart getCart(int uid);
}
