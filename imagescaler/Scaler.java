
/*
 * ScrollbarTest.java er en kildefil til boken "Objektorientert programmering med Java"
 * 
 * ****    Tredje opplag   ****
 * 
 * Boken er utgitt på http://www.fagbokforlaget.no
 * 
 * ISBN 978-82-7674-748-5
 * 
 * Viggo Holmstedt 2002 - 2019
 * -------------------------------------------
 * File location: kap_08/
 * Last modified: 2019-01-18 01:31
 * 

 */ 



/*

   Demonstrerer bruk av ScrollBar for å endre fargen i et tekstvindu.
   Mønsteret for å bruke lyttere er akkurat det samme som for ActionListener.
   Se også bruk av JOptionPane
*/

import java.awt.*;
import java.awt.event.*;

import javax.swing.JOptionPane;


public class Scaler extends Frame implements AdjustmentListener {
	
    private	Scrollbar windowScroller = new Scrollbar(Scrollbar.HORIZONTAL, 20, 0, 20, 101);
    
    private	Label l = new Label("Bruk scrollbar-objektene for å endre fargen", Label.CENTER);
    private	TextArea t = new TextArea();
	
    // https://stackoverflow.com/questions/29910748/storage-of-object-references-inside-a-object-in-java-memory-model
    private ScalableWindow imagewindow; //Laget en referenase, og kun en instanse av ImageWindow
   
    //Constructor
    public Scaler () {
    	
       windowScroller.addAdjustmentListener(this);

        add(l, "North");
        add(t);
        Panel p = new Panel();
        p.setLayout(new GridLayout(3, 0));
        p.add(windowScroller);
      
        add(p, "South");
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Sikker?") == JOptionPane.OK_OPTION) {
                    System.exit(0);
                }
            }

        });
        setSize(400, 600);
        
        setVisible(true);
    }

	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
		//Lagrerer verdien. Kan også hentes fra windowScroller.getValue();
		int verdiHentetFraWindowscroll = e.getValue();
		//Setter verdien, til referansen
		imagewindow.setTitle(String.valueOf(verdiHentetFraWindowscroll));
		imagewindow.redraw(verdiHentetFraWindowscroll);
	}


	public void setWindow(ScalableWindow mywindow) {
		// TODO Auto-generated method stub
		this.imagewindow = mywindow;
		
	}

} //Class ends
