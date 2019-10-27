//**************************************************************************************
//Team 7
//Mansion Escape
//COSC 3324 Object Oriented Programming
//Date: 11/10/2017
// @author: Lupe Garcia
//**************************************************************************************
//Prologue:  This class will be used to instantiate item objects in the game.  Items will exist within the game's rooms
//			 and can be picked up from the player.  Items are also passed to the inventory class when the player picks them up.

//Beginning of class Item
public class Item {
	
	//Item variables
	//quantity: a value to identify the number of a type a item available.
	//itemName: item name, identifies name of item
	private String itemName;
	private int itemQuantity;
	
	//Item constructor initializes item variables when instantiated
	public Item(String itemName, int itemQuantity) {
		
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
	}
	
	//Copy Constructor
	//will make a copy of the Item object
	public Item(Item object) {
		itemName = object.itemName;
		itemQuantity = object.itemQuantity;
	}
	
	//default constructor 
	public Item() {
		itemName = null;
		itemQuantity = 0;
	}
	
	//Setters
	//Method to set the name of the item
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	//Method to set the quantity of the item
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	
		//Method to get item name
	public String getItemName() {
		return itemName;
	}
	
	//Method to get item quantity
	public int getItemQuantity() {
		return itemQuantity;
	}
	
	//toString method to print itemName and quantity
	@Override
	public String toString() {
		return String.format("Item: %s%nQuantity: %s%n"
					,getItemName(), getItemQuantity());
	}
}


