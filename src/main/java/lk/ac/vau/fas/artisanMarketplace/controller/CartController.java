package lk.ac.vau.fas.artisanMarketplace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ac.vau.fas.artisanMarketplace.models.Cart;
import lk.ac.vau.fas.artisanMarketplace.models.Response;
import lk.ac.vau.fas.artisanMarketplace.service.CartService;
import lk.ac.vau.fas.artisanMarketplace.util.VarList;
@RestController
@RequestMapping("/cart")
public class CartController extends GenericController<Cart,Long> {
	@Autowired
	private CartService service;
	@Autowired
    private Response response;
	@GetMapping("/uid/{id}")
	public ResponseEntity<Response> getUserByName(@PathVariable("id") int id) {
		try {
            Cart cart = service.cartByUid(id);
            if (cart !=null) {
                response.setCode(VarList.RSP_SUCCESS);
                response.setMessage("Success");
                response.setContent(cart);
                return new ResponseEntity<Response>(response, HttpStatus.ACCEPTED);
            } else {
                response.setCode(VarList.RSP_NO_DATA_FOUND);
                response.setMessage("No Data Available For id: "+id);
                response.setContent("");
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
