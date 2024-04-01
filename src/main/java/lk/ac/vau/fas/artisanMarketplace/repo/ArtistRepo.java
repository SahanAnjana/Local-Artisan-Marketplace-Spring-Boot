package lk.ac.vau.fas.artisanMarketplace.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import lk.ac.vau.fas.artisanMarketplace.models.Artist;
@Repository
public interface ArtistRepo extends GenericRepo<Artist,Long> {
	@Query("SELECT a FROM Artist a WHERE a.username = ?1")
	public Artist getArtist(String name);
}
