package com.example.microservicedebugging.dto;

/**
 * Simple Container Object
 * 
 * @author Sameer Shukla
 *
 */
public class Item {
	
	private Integer id;
	private String itemName;
	
	public Item() {
		
	}
	
	public Item(Integer id, String item) {
		this.id = id;
		this.itemName = item;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", itemName=" + itemName + "]";
	}
	
	

}
