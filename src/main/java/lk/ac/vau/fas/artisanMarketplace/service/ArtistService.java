package lk.ac.vau.fas.artisanMarketplace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.ac.vau.fas.artisanMarketplace.models.Artist;
import lk.ac.vau.fas.artisanMarketplace.repo.ArtistRepo;
@Service
public class ArtistService extends GenericService<Artist, Long>{
	@Autowired
	private ArtistRepo repo;
	
	public Artist artistByName(String name) {
		return repo.getArtist(name);
	}
}
