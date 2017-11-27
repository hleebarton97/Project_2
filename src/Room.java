import java.util.ArrayList;

/**
 * 
 * @author Lee
 *
 */

public class Room 
{
	private String name;
	private ArrayList<Item> items;
	
// Constructors:
	
	/**
	 * 
	 */
	public Room()
	{
		this.items = new ArrayList<Item>();
		this.setName(null);
	}
	
	public Room(String name)
	{
		this.items = new ArrayList<Item>();
		this.setName(name);
	}
	
	/**
	 * 
	 * @param name
	 * @param inventory
	 */
	public Room(String name, ArrayList<Item> items)
	{
		this.setName(name);
		this.setItems(items);
	}
	
	
// Getters:
	
	/**
	 * 
	 * @return
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Item> getItems()
	{
		return this.items;
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public Item getItemWithName(String name)
	{
		for(Item item : this.items)
		{
			if(item.getName().equals(name))
				return item;
		}
		return null;
	}

	
// Setters:
	
	/**
	 * 
	 * @param name
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * 
	 * @param items
	 */
	public void setItems(ArrayList<Item> items)
	{
		this.items = items;
	}
	
// Functions:
	
	/**
	 * 
	 * @param item
	 */
	public void addItem(Item item)
	{
		this.items.add(item);
	}
	
	/**
	 * 
	 * @param name
	 */
	public void addItem(String name)
	{
		Item item = new Item(name);
		this.items.add(item);
	}
}
