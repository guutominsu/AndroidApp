
import java.awt.*;

import java.awt.event.*;

import javax.swing.*;
/**
 * Custom Graphics Example: Using key/button to move a line left or right.
 */
@SuppressWarnings("serial")
public class DrawPie extends JFrame {
   // Name-constants for the various dimensions
   public static final int CANVAS_WIDTH = 700;
   public static final int CANVAS_HEIGHT = 1000;
   public static final Color CANVAS_BACKGROUND = Color.YELLOW;
   private DrawCanvas canvas; // the custom drawing canvas (extends JPanel)
 
  
   public DrawPie() {
      // Set up a panel for the butt��ons
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
           requestFocus();
             // change the focus to JFrame to receive KeyEvent
         }
      });
      
 
      // Set up a custom drawing JPanel
      int randomN=(int) (1+(Math.random()*(10-1)));
      int randomD=(int) (2+(Math.random()*(10-2)));
      if (randomN>=randomD){
      	randomN=randomD-1;
      }
  	
      canvas = new DrawCanvas(300, 300, 200,  randomD, Color.RED, randomN, randomD);
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
	    int radius; 
	    // number of parts of a pie
	    int numberOfParts;
	    //color of a pie
	    Color color;
	    // random numerator of a fraction 
	    int randomN;
	    // random denominator of a fraction 
	    int randomD;
	    
      
      public DrawCanvas (int x, int y, int radius, int numberOfParts, Color color, int randomN, int randomD){
    	  this.x=x; 
      	this.y=y;
      	this.radius=radius;		
      	this.numberOfParts=numberOfParts;
      	this.randomN=randomN;
      	this.randomD=randomD; 
      	
      	this.color=color;
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
      public void paintComponent(Graphics g) {
 
    	  super.paintComponent(g);
          // start angle of an arc 
          int startAngle=0; 
          /*pie can have different number of parts and different number of parts means different angles of arcs.
      	 * As whole angle of a pie is 360, then each arcs must have angle 360 divided number of parts. 
      	 */
      	int arcAngle=360/this.numberOfParts; 
      	/* x1 - new arc's relative to the bounding rectangle's top-left x coordinate
      	 * y1 - new arc's relative to the bounding rectangle's top-left y coordinate 
      	 */
      	int x1, y1; 
      	/*draw equal arcs number of parts times to make a pie
      	 * 
      	 */
      	for (int i=1; i<=this.numberOfParts; i++ ){
      		//start angle of each arcs can be found by multiplying number of previous arcs minus 1 to arc angle
      		startAngle = (i-1)*arcAngle;
      		//convert cosine of start angle into radian value
      		double radians = Math.toRadians((double)startAngle);
      		x1 = this.x +(int) (this.radius*Math.cos(radians)); 
      		y1 = this.y +(int) (this.radius*Math.sin(radians));
      		g.setColor(this.color);	
      	g.fillArc(this.x-this.radius, this.y-this.radius, this.radius*2, this.radius*2, startAngle, arcAngle);

       
      	
      	}
     	g.setColor(Color.BLACK);
     	//draw lines to separate each arcs
     	for (int i=1; i<=this.numberOfParts; i++ ){
     		startAngle = (i-1)*arcAngle;
     		double radians = Math.toRadians((double)startAngle);
     		x1 = this.x +(int) (this.radius*Math.cos(radians)); 
     		y1 = this.y +(int) (this.radius*Math.sin(radians));
     		g.drawLine(this.x,this.y, x1, y1);
     		
     	}
     	g.drawArc(this.x-this.radius, this.y-this.radius, this.radius*2, this.radius*2, 0, 360);
     	//Create an object using class Fraction for the task 
     	Fraction first = new Fraction (this.randomN, this.randomD);
     	//Show task 
     	String task = new String ("Paint pieces of the pie to make the same proportion as  "+first.toString());
     	Font font = new Font("Serif", Font.BOLD, 25);
     	g.setFont(font);
     	g.drawString(task,40,50);
     	

     	//"Paint appropriate amount of parts to make the same proprtion as"+
      }
       /**this method returns what part of the pie mouse clicked 
         xMouse = x coordinate of mouse clicked point 
         yMouse = y coordinate of mouse clicked point 
         */ 
      private int getSectorNumber(int xMouse, int yMouse){
    	   	double angle=0.0;
    	   	int n;
    	   	// diffX is difference between x coordinate of center of the pie and x coordinate of mouse clicked point
    		// diffY is difference between y coordinate of center of the pie and y coordinate of mouse clicked point 
    	   	int diffX,diffY; 
    	   	diffX=this.x-xMouse;
    	   	diffY=yMouse-this.y;
    	   	if(diffX!=0){
    	   		angle=Math.toDegrees(Math.atan((double)diffY/diffX));
    	   	}
    	   	if(diffX>0 && diffY<0 ){
    	   		angle=angle+180;
    	   	}
    	   	else if(diffX>0 && diffY>=0){
    	   		angle=angle+180;
    	   	}
    	   	else if(diffX<0 && diffY>0){
    	   		angle=360+angle;
    	   	}
    	   	
    	   	int arcAngle=360/this.numberOfParts;
    	   	n = (int)angle/arcAngle; 
    	   	return n+1;
    	   	
    	   }
      /**
       * paint the clicked part into another color
       * @param n = number of a part 
       */
      public void drawSector(int n){
      	
      	Graphics g = this.getGraphics();
      	int startAngle=(n-1)*360/this.numberOfParts;
       	int arcAngle=360/this.numberOfParts;
       	int x1, y1; 
       	//if a part is not painted then draw another arc in the same place in black color. And change toggle to false as it is now in changed color. 
       	if (toggle[n-1]==true){
       	g.setColor(Color.BLACK);	
       	g.fillArc(this.x-this.radius, this.y-this.radius, this.radius*2, this.radius*2, startAngle, arcAngle);
       	toggle[n-1]=false; 
       	}
       	else {
       		g.setColor(Color.RED);	
           	g.fillArc(this.x-this.radius, this.y-this.radius, this.radius*2, this.radius*2, startAngle, arcAngle);
       		toggle[n-1]=true; 
       		g.setColor(Color.BLACK);
       	    //when arc is painted line is partially erased, so we draw it one more time 
          	for (int i=1; i<=this.numberOfParts; i++ ){
          		startAngle = (i-1)*arcAngle;
          		double radians = Math.toRadians((double)startAngle);
          		x1 = this.x +(int) (this.radius*Math.cos(radians)); 
          		y1 = this.y +(int) (this.radius*Math.sin(radians));
          		g.drawLine(this.x,this.y, x1, y1);
          	}
       	}
      }
      /**
       * return how many of parts changed the color 
       * @return a number how many of them are filled 
       */
     public int howManyFilled(){
    	   	int count= 0;
    	   	for(int i = 0; i<toggle.length; i++){
    	   		if (toggle[i]==false){
    	   			count++; 
    	   		}
    	   	}
    	   	return count; 
    	   }
     
      /**
       * When mouse is clicked the color changes     	
       */
      public void mouseClicked(MouseEvent e){
  	    
          
          int xMouse=e.getX();
          int yMouse=e.getY();
          int n = this.getSectorNumber(xMouse, yMouse);
          System.out.println("Mouse clicked (# of clicks: "+n);
          drawSector(n);
      }
      public void mousePressed(MouseEvent e) {}
      public void mouseReleased(MouseEvent e) {}
      
      public void mouseEntered(MouseEvent e) {}
      
      public void mouseExited(MouseEvent e) {}
      
      
   }
      
   
   
 
   /** The entry main() method */
   public static void main(String[] args) {
      // Run GUI codes on the Event-Dispatcher Thread for thread safety
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new DrawPie(); // Let the constructor do the job
         }
      });
   }
}