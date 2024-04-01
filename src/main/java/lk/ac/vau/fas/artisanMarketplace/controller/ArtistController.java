package lk.ac.vau.fas.artisanMarketplace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ac.vau.fas.artisanMarketplace.models.Artist;
import lk.ac.vau.fas.artisanMarketplace.models.Response;
import lk.ac.vau.fas.artisanMarketplace.service.ArtistService;
import lk.ac.vau.fas.artisanMarketplace.util.VarList;
@RestController
@RequestMapping("/artist")
public class ArtistController extends GenericController<Artist,Long> {
	@Autowired
	private ArtistService service;
	@Autowired
    private Response response;
	@GetMapping("/name/{name}")
	public ResponseEntity<Response> getUserByName(@PathVariable("name") String name) {
		try {
            Artist artist = service.artistByName(name);
            if (artist !=null) {
                response.setCode(VarList.RSP_SUCCESS);
                response.setMessage("Success");
                response.setContent(artist);
                return new ResponseEntity<Response>(response, HttpStatus.ACCEPTED);
            } else {
                response.setCode(VarList.RSP_NO_DATA_FOUND);
                response.setMessage("No Data Available For name: "+name);
                response.setContent(null);
                return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            response.setCode(VarList.RSP_ERROR);
            response.setMessage(e.getMessage());
            response.setContent(e);
            return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
}
