package lk.ac.vau.fas.artisanMarketplace.repo;

import org.springframework.stereotype.Repository;

import lk.ac.vau.fas.artisanMarketplace.models.CartItem;
@Repository
public interface CartItemRepo extends GenericRepo<CartItem,Long> {

}
