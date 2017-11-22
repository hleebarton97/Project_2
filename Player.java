/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mansion;

/**
 *
 * @author jake
 */
public class Player {
    
    private Inventory playerInventory;
    private Actions playerAction;
    private String playerName;
    
    public Player()
    {
        this.playerInventory = null;
        this.playerAction = null;
        this.playerName = null;
    }
    
    //Add copy constructor, to get specific values of an object.
    //Example
    public Player(Player obj)
    {
        setName(obj.playerName);
        setInventory(obj.playerInventory);
        setAction(obj.playerAction);
    }
    
    public Player(String name, Inventory playerInv, Actions playerAct)
    {
        this.playerName = name;
        this.playerInventory = playerInv;
        this.playerAction = playerAct;
    }
    
    public void setName(String name)
    {
        this.playerName = name;
    }
    
    public String getName()
    {
        return this.playerName;
    }
    
    public void setInventory(Inventory inv)
    {
        this.playerInventory = playerInv;
    }
    
    public Inventory getInventory()
    {
        return this.playerInventory;
    }
    
    public void setAction(Action act)
    {
        this.playerAction = act;
    }
    
    public Action getAction()
    {
        return this.playerAction;
    }
    
    @Override
    public String toString()
    {
        return String.format("Name:%s Inventory:%s Action: %s", this.getName(), 
                this.getInventory(), this.getAction());
    
    }
    
    
    
    
    
    
    
    
    
}
