package lk.ac.vau.fas.artisanMarketplace.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ac.vau.fas.artisanMarketplace.models.CartItem;
@RestController
@RequestMapping("/cartitem")
public class CartItemController extends GenericController<CartItem,Long> {

}
