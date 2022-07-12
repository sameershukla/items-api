package com.example.microservicedebugging.controller;

import java.io.InvalidObjectException;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservicedebugging.dto.Item;
import com.example.microservicedebugging.dto.ItemNotFoundException;

import io.micrometer.core.annotation.Timed;

/**
 * REST Endpoint 
 * @author Sameer Shukla
 *
 */
@RestController
public class Controller {

	org.slf4j.Logger logger = LoggerFactory.getLogger(Controller.class);

	private List<Item> itemList = List.of(new Item(10, "Item1"), new Item(20, "Item2"));

	@GetMapping(path = "/items")
	@Timed(value = "items", description = "Time Taken to Return Items")
	public List<Item> getItems() {
		logger.info("Returning Items List");
		return itemList;
	}

	@GetMapping(path = "/items/{itemId}")
	@Timed(value = "itemId", description = "Tike Taken to Return Specific Item")
	public Item getItem(@PathVariable Integer itemId) throws ItemNotFoundException{
		return itemList.stream().filter(item -> item.getId() == itemId).findFirst()
				.orElseThrow(IllegalArgumentException :: new);
	}

	@PostMapping(path = "/items")
	@Timed(value = "itemId", description = "Add items")
	public Item addItem(@RequestBody Item item) throws InvalidObjectException {
		logger.info("Inside POST:", item);
		if(item.getItemName().length() > 10)
			throw new InvalidObjectException("Invalid Item Name Length");
		return item;
	}
}
