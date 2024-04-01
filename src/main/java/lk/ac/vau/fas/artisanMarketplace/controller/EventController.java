package lk.ac.vau.fas.artisanMarketplace.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ac.vau.fas.artisanMarketplace.models.Event;
@RestController
@RequestMapping("/event")
public class EventController extends GenericController<Event,Long> {

}
