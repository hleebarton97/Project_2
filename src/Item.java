/**
 * Item class
 * The Item class contains fields and methods needed to realize an in game Item.
 * Fields:
 * 	name: A String containing the Item name to be displayed.
 * 	pickedUp: A boolean value to determine if the Item has been picked up by the player.
 * 	type: An integer value that determines what Node the item is used on.
 *  Date: 02 December 2017
 * OOP Project 2: The Mansion
 * @author Team 7
 */

public class Item 
{
	private String name;  // Item name to be displayed.
	private int type;	  // Item type that determines what it is used for -- value represents Node it is USED ON.
	private boolean used; // Has the item been used?
	private boolean pickedUp; // Has the item been picked up by the player?
	
	/**
	 * Initial creation of an item.
	 */
	public Item()
	{
		this.setName("");
		this.setType(-1);
		this.used = false;
		this.pickedUp = false;
	}
	
	/**
	 * Item creation with name and type already known.
	 * @param name The name of the item.
	 * @param type The type of the item.
	 */
	public Item(String name, int type)
	{
		this.setName(name);
		this.setType(type);
		this.used = false;
		this.pickedUp = false;
	}


	// Getters:
	public String getName()
	{
		return this.name;
	}
	
	public int getType()
	{
		return this.type;
	}
	
	public boolean isUsed()
	{
		return this.used;
	}
	
	public boolean isPickedUp()
	{
		return this.pickedUp;
	}


	// Setters:	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setType(int type)
	{
		this.type = type;
	}
	
	public void setUsed(boolean used)
	{
		this.used = used;
	}
	
	public void setPickedUp(boolean pickedUp)
	{
		this.pickedUp = pickedUp;
	}
}
