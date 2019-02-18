
/*
 * ImageTest.java er en kildefil til boken "Objektorientert programmering med Java"
 * 
 * ****    Tredje opplag   ****
 * 
 * Boken er utgitt på http://www.fagbokforlaget.no
 * 
 * ISBN 978-82-7674-748-5
 * 
 * Viggo Holmstedt 2002 - 2019
 * -------------------------------------------
 * File location: kap_07/
 * Last modified: 2019-01-28 01:59
 * 

 */ 

/*
 *
 * Prøvekjør: 
 * Hva skjer hvis meldingen componentResized ikke kjører repaint?
 * Sjekk ved å forandre vinduets størrelse med musepekeren.
 *
 * For noen skjer det at bildet ikke oppdateres automatisk. Da hjelper det 
 * å bruke componentResized og repaint. På andre maskiner skjer det 
 * oppdateringen uten at du behøver å bruke componentResized og repaint.
 *
*/


import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.net.URL;

public class ScalableWindow extends Frame  {

	private Image bilde = null;
	
	public void redraw(int verdiHentetFraScrollbar) {
		//Hentet en verdi mellom 20, og 100
		//Hvordan adjuster jeg bildet med denne verdien? Hvilken metode bruker	
	}

	public ScalableWindow() {
		setTitle("ScalableWindow ");
		addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		
		});
        
        // Frame er en subklasse etter klassen Component		
		addComponentListener(new ComponentAdapter() {

		    public void componentResized(ComponentEvent componentEvent) {
		    	repaint();
		    	
		    }

		});

		//Size for FRAME, NOT IMAGE
		setSize(900, 600);
		getImage();
		setVisible(true);
		
		
	}

	protected void getImage() {
		try {
			URL u = new URL("https://obj.holmstedt.no/pics/26815574_835191906649288_7507950488720876851_n.jpg");
			bilde = Toolkit.getDefaultToolkit().getImage(u);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	public void paint(Graphics g) {
		g.translate(getInsets().left, getInsets().top);
		
		
		if (bilde != null) {
			g.drawImage(bilde, 20, 20, getWidth(), getHeight(), this);
			
		}
	}

}

