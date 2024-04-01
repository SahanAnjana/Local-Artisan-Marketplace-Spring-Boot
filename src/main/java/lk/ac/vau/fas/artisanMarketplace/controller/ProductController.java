package lk.ac.vau.fas.artisanMarketplace.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ac.vau.fas.artisanMarketplace.models.Product;
@RestController
@RequestMapping("/product")
public class ProductController extends GenericController<Product,Long> {

}
