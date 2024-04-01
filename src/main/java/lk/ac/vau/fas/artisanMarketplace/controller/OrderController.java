package lk.ac.vau.fas.artisanMarketplace.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ac.vau.fas.artisanMarketplace.models.Orders;
@RestController
@RequestMapping("/order")
public class OrderController extends GenericController<Orders,Long> {

}
