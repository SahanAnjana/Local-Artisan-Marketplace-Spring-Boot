package lk.ac.vau.fas.artisanMarketplace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.ac.vau.fas.artisanMarketplace.models.User;
import lk.ac.vau.fas.artisanMarketplace.repo.UserRepo;
@Service
public class UserService extends GenericService<User, Long>{
	@Autowired
	private UserRepo repo;
	
	public User userByName(String name) {
		return repo.getUser(name);
	}
}
