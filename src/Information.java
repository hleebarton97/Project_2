import javax.swing.JTextPane;

/**
 * Information class requires a text pane and handles the information
 * being written to the player.
 * 
 * This allows the lore of the game to be created.
 */


public class Information 
{
	
	private JTextPane infoPane;	// Our JTextPane to write information to.
    
	/**
	 * Constructor must accept a JTextPane object.
	 * @param infoPane
	 */
    public Information(JTextPane infoPane)
    {
        this.setInformation(infoPane);
        //this.writeInformation(); // Start of game information.
    }
    
// Setter
    /**
     * Sets the JTextPane to the passed in JTextPane to write information to.
     * @param infoPane
     */
    public void setInformation(JTextPane infoPane)
    {
    	this.infoPane = infoPane;
    }

// Getter
    /**
     * Gets the current JTextPane.
     * @return
     */
    public JTextPane getInformation()
    {
        return this.infoPane;
    }

    
    /**
     * Write the string passed in to the current JTextPane.
     * @param info
     */
    public void writeInformation(String info)
    {
        this.infoPane.setText(info);
    }

}
