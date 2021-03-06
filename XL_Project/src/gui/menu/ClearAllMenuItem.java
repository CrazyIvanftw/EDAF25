package gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.event.EventListenerList;

import gui.SubmitEvent;
import gui.SubmitListener;

class ClearAllMenuItem extends JMenuItem implements ActionListener {
    
	private static final long serialVersionUID = 1L;
	
	private EventListenerList listenerList = new EventListenerList();

	public ClearAllMenuItem() {
        super("Clear all");
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        fireSubmitEvent(new SubmitEvent(this, null, "clearAll"));
    }
    
    //---------------------------------------------------------------
  	// add/remove SubmitListeners and fire SubmitEvent
  	//---------------------------------------------------------------
  	
  	/** Add a SubmitListener to the eventListenerList */
  	public void addSubmitListener(SubmitListener listener){
  		listenerList.add(SubmitListener.class, listener);
  	}
  	
  	/** Remove a SubmitListener from the eventListenerList */
  	public void removeSubmitListener(SubmitListener listener){
  		listenerList.remove(SubmitListener.class, listener);
  	}
  	
  	/** Call submitEventOccured() on every SubmitListener in the eventListenerList */
  	public void fireSubmitEvent(SubmitEvent submit){
      	Object[] listeners = listenerList.getListenerList();
  		for(Object l : listeners){
  			if(l instanceof SubmitListener){
  				((SubmitListener) l).submitEventOccured(submit);
  			}
  		}
    }
    
    
    
}