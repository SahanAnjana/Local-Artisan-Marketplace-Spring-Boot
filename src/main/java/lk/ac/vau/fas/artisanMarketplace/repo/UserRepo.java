package lk.ac.vau.fas.artisanMarketplace.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import lk.ac.vau.fas.artisanMarketplace.models.User;
@Repository
public interface UserRepo extends GenericRepo<User,Long> {
	@Query("SELECT u FROM User u WHERE u.username = ?1")
	public User getUser(String name);
}
