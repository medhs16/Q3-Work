import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Recursion extends JPanel implements ActionListener{
	/* this method should recursive draw concentric rings */
	public void concentricCircles(Graphics g, int width, int x, int y) {
		//if width is 1, too small!
		if (width <= 1) return;
		else {
			
			
			g.drawOval(x, y, width, width);
		
			concentricCircles (g, width-10, x+5, y+5);
			
		}
		 
		
		
		
	}
	
	public void loops(Graphics g, int width, int x, int y, int trueX, int trueY, double angle) {
		//if width is 1, too small!
		if (angle > 6.5) return;
		else {g.setColor(Color.green);
		g.drawOval(x,  y,  width,  width);
		loops(g, width+10, trueX +(int)((width+10)/2*Math.cos(angle+0.2))- (width+10/2), 
			trueY+(int)((width+10)/2*Math.sin(angle+0.2))- (width+10/2), trueX, trueY, angle+0.2);
		}
		 
		
		
		
	}
	public void picture(Graphics g, int width, int x, int y, int trueX, int trueY, double angle, int x2, int y2, int width2) {
		if (angle> 6.5) {
			return;
		}
		else {
			//g.drawLine(x2, y2, x, y);
			g.drawOval(x2, y2, width2, width2);
			g.drawOval(x, y, width, width);
			picture(g, width+10, trueX +(int)((width+10)/2*Math.cos(angle+0.2))- (width+10/2), 
					trueY+(int)((width+10)/2*Math.sin(angle+0.2))- (width+10/2), trueX, trueY, angle+0.2, x2-6, y2-6, width2+12);
		}
		 
		
		
		
	}
	
	public void squares(Graphics g, int len, int x, int y) {
		//add the additional parameters (arguments) so that you can call
		//on the method recursively
		g.drawRect((int)(x-len*0.5), (int)(y-len*0.5), len, len);
		
		for (int i=0; i<8; i++) {
			int newlen = len/3;
			if (newlen > 1) {
			squares(g, newlen, x+len, y);
			squares(g, newlen, x+len, y+len);
			squares(g, newlen, x+len, y-len);
			squares(g, newlen, x, y+len);
			squares(g, newlen, x, y-len);
			squares(g, newlen, x-len, y);
			squares(g, newlen, x-len, y+len);
			squares(g, newlen, x-len, y-len);
			}
		}
	}
	
	public void clover(Graphics g, int width, int x, int y, int s) { //What additional variables will you need to draw the shape?
		if (s<=0) {
			return;
		}
		else {
			g.drawOval(x, y,  width-(8*s), width-(8*s));
			clover(g,width,x,y,s-1);
		}
		
	}
	public void clover2(Graphics g, int width, int x, int y, int s) { //What additional variables will you need to draw the shape?
		if (s<=0) {
			return;
		}
		else {
			g.drawOval(x-200+(8*s), y,  width-(8*s), width-(8*s));
			clover2(g,width,x,y,s-1);
		}		
	}
	public void clover3(Graphics g, int width, int x, int y, int s) { //What additional variables will you need to draw the shape?
		if (s<=0) {
			return;
		}
		else {
			g.drawOval(x, y-200+(8*s),  width-(8*s), width-(8*s));
			clover3(g,width,x,y,s-1);
		}	
	}
	public void clover4(Graphics g, int width, int x, int y, int s) { //What additional variables will you need to draw the shape?
		if (s<=0) {
			return;
		}
		else {
			g.drawOval(x-200+(8*s), y-200+(8*s),  width-(8*s), width-(8*s));
			clover4(g,width,x,y,s-1);
		}
	}
	


	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, 2000, 2000);

		g.setColor(Color.pink);
		this.clover(g, 200, 250, 250, 25);
		this.clover2(g, 200, 250, 250, 25);
		this.clover3(g, 200, 250, 250, 25);
		this.clover4(g, 200, 250, 250, 25);
		this.squares(g,133,200,600);
		this.loops(g, 10, 700, 700,700,700 ,0);
		g.setColor(Color.cyan);
		this.picture(g, 10, 400, 400,400,400 ,0, 335,245, 10);
	} //my code should go above this bracket unless I know about classes
	
	
	public static void main(String[] arg) {
		
		// line of code to create a MethodPractice object
		Recursion m = new Recursion();
	
	}// end of main method body 
	
	
	//constructor for the class
	//kind of looks like a method but no return type!!!
	public Recursion() {
		JFrame f = new JFrame("Recursive Methods");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		f.setSize(800,600);
		f.add(this);
		f.setVisible(true);
		
	}
	Timer t = new Timer(16, this);
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}

}//last curly - do not delete