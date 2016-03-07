
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
/**
 * Custom Graphics Example: Using key/button to move a line left or right.
 */
@SuppressWarnings("serial")
public class DrawLi extends JFrame {
   // Name-constants for the various dimensions
   public static final int CANVAS_WIDTH = 700;
   public static final int CANVAS_HEIGHT = 1000;
   public static final Color CANVAS_BACKGROUND = Color.YELLOW;
   private DrawCanvas canvas; // the custom drawing canvas (extends JPanel)
 
  
   public DrawLi() {
      // Set up a panel for the butt¡×ons
      JPanel btnPanel = new JPanel(new FlowLayout());
      JButton btnLeft = new JButton("Submit");
      btnLeft.setFont(new Font("Arial", Font.PLAIN, 20));
      btnPanel.add(btnLeft);
      btnLeft.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
           int m = canvas.howManyFilled(); 
           if (m == canvas.randomN){
        	   JOptionPane.showMessageDialog(canvas, String.format("Correct", e.getActionCommand()));
        	   setVisible(false);
        	   dispose();
        	   
       
        	   try {
				this.finalize();
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}            	   
           }
           else{
        	   JOptionPane.showMessageDialog(canvas, String.format("Incorrect", e.getActionCommand()));
           }
            canvas.repaint();
            requestFocus(); // change the focus to JFrame to receive KeyEvent
            
         }
      });
      
 
      // Set up a custom drawing JPanel
      int randomN=(int) (1+(Math.random()*(10-1)));
      int randomD=(int) (2+(Math.random()*(10-2)));
      if (randomN>=randomD){
      	randomN=randomD-1;
      }
  	
      canvas = new DrawCanvas(100,300,100,5,randomD,randomN, randomD);
      canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
      canvas.addMouseListener(canvas); 
 
      // Add both panels to this JFrame
      Container cp = getContentPane();
      cp.setLayout(new BorderLayout());
      cp.add(canvas, BorderLayout.CENTER);
      cp.add(btnPanel, BorderLayout.SOUTH);
 
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Handle the CLOSE button
      setTitle("Pie");
      pack();           // pack all the components in the JFrame
      setVisible(true); // show it
      requestFocus();   // set the focus to JFrame to receive KeyEvent
   }
 
 
   /**
    * DrawCanvas (inner class) is a JPanel used for custom drawing
    */
   class DrawCanvas extends JPanel implements MouseListener{
	 //array saves information if parts changed color or didn't. If changed then false, if not then true
	 		boolean[] toggle; 
	 		//x coordinate of center of a pie 
	 	    int x; 
	 	    // y coordinate of center of a pie
	 	    int y;
	 	    // radius of a pie 
	 	    int length; 
	 	    // number of parts of a pie
	 	    int width;
	 	    int numberOfParts;
	 	    //color of a pie
	 	    Color color;
	 	    // random numerator of a fraction 
	 	    int randomN;
	 	    // random denominator of a fraction 
	 	    int randomD;
	 	    int howManyfilled = 0;
	 	    
	       
	       public DrawCanvas (int x, int y, int length, int width, int numberOfParts, int randomN, int randomD){
	     	  this.x=x; 
	       	this.y=y;
	       	this.length=length;		
	       	this.numberOfParts=numberOfParts;
	       	this.randomN=randomN;
	       	this.randomD=randomD; 
	       	this.width = width;

	     	// number of element of array toggle is determined by number of parts 
	     	toggle = new boolean[this.numberOfParts];
	     	// at first set all element true 
	     	for (int k=0; k<toggle.length; k++ ){
	     		toggle[k]=true;
	     	}
	       }
	       
	       
	       
	      /**
	       * paint pie  
	       */
	       public void paintComponent(Graphics g){
	   		int x1,y1; // coordinates of another rectangle 
	   		//draw rectangles numberOfParts times 
	   		for (int i=1; i<=this.numberOfParts; i++ ){
	   			int length = this.length*i;
	   			g.setColor(Color.BLACK);
	   			g.fillRect(this.x, this.y, length, this.width);
	   			
	   		}
	   		
	   		g.setColor(Color.RED);
	   		//Draw triangles several times as divisions of parts of a line
	   		for (int i=0; i<=this.numberOfParts; i++ ){
	   			int length = this.length*i; 
	   			x1 = this.x+length; 
	   			y1 = this.y+this.width+10;
	   			Polygon tri=new Polygon();
	   			tri.addPoint(x1,y1); 
	   			tri.addPoint(x1-10,y1+15);
	   			tri.addPoint(x1+10,y1+15); 
	   			g.fillPolygon(tri); 
	   		}
	   		Fraction first = new Fraction (this.randomN, this.randomD);
	   		g.setColor(Color.black);
	   		String task = new String ("Click the point in a line to make the same proportion as  " + first.toString());
	   		Font font = new Font("Serif", Font.BOLD, 25);
	     	g.setFont(font);
	       	g.drawString(task,50, 40);
	   		
	   	}
	   	
	       //Return the number of part where mouse is clicked, using coordinates of mouse click
	   	private int getPointNumber(int xMouse, int yMouse){
	   		int diffX=xMouse - this.x; 
	   		int n=diffX/this.length; 
	   		return n;
	   	
	   	    
	   	}
	   	
	   	// Paint rectangles n times to paint the line
	   	public void paintRec(int n){
	   		Graphics g = this.getGraphics(); 
	   		g.setColor(Color.CYAN);
	   		int x = this.x;
	   		int y = this.y;
	   		
	   		if (toggle[0]==true){
	   			g.setColor(Color.CYAN);
	   		g.fillRect(x,y,this.length*n,this.width);
	   		toggle[n-1]=false; 
	   		}
	   		else {
	   			g.setColor(Color.BLACK);
	   			g.fillRect(x,y,this.length*n,this.width);
	   			toggle[n-1]=true;
	   		}
	   		
	   	}
	   	
	   	
      
      /**
       * return how many of parts changed the color 
       * @return a number how many of them are filled 
       */
    
     
      /**
       * When mouse is clicked the color changes     	
       */
      public void mouseClicked(MouseEvent e){
  	    
          
          int xMouse=e.getX();
          int yMouse=e.getY();
          int n = this.getPointNumber(xMouse, yMouse);
          System.out.println("Mouse clicked (# of clicks: "+n);
          paintRec(n);
          this.howManyfilled = n;
      }
      public int howManyFilled(){
  	   
  	   	return howManyfilled; 
  	   }
      public void mousePressed(MouseEvent e) {}
      public void mouseReleased(MouseEvent e) {}
      
      public void mouseEntered(MouseEvent e) {}
      
      public void mouseExited(MouseEvent e) {}
      
      
   }
      
   
   /*
   public static void main(String[] args) {
      // Run GUI codes on the Event-Dispatcher Thread for thread safety
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new DrawLi(); // Let the constructor do the job
         }
      });
   }
   */
}

