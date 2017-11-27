/**
 * 
 * @author Lee
 *
 */

public class Item 
{
	private String name;  // Item name.
	private boolean used; // Has the item been used?
	
	public Item()
	{
		this.setName("NA");
		this.used = false;
	}
	
	public Item(String name)
	{
		this.setName(name);
		this.used = false;
	}


// Getters:
	
	public String getName()
	{
		return this.name;
	}
	
	public boolean isUsed()
	{
		return this.used;
	}


// Setters:	
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setUsed(boolean used)
	{
		this.used = used;
	}
}
