package lk.ac.vau.fas.artisanMarketplace.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ac.vau.fas.artisanMarketplace.models.Category;
@RestController
@RequestMapping("/category")
public class CategoryController extends GenericController<Category,Long> {

}
