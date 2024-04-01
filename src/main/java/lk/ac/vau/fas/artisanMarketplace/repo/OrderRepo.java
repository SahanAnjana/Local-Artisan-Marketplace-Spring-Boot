package lk.ac.vau.fas.artisanMarketplace.repo;

import org.springframework.stereotype.Repository;

import lk.ac.vau.fas.artisanMarketplace.models.Orders;
@Repository
public interface OrderRepo extends GenericRepo<Orders,Long> {

}
