import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.event.*;
import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;


public class Summation extends JFrame {
	private static final long serialVersionUID = 1L;
	  int userN; // numerator input by user
	  int userD; // denominator input by user
	   JTextField numerator = new JTextField(); // Text field where user input numerator 
	   JTextField denominator = new JTextField(); //Text field where user input denominator 
	   
	   JTextField numerator2 = new JTextField(); // Text field where user input numerator 
	   JTextField denominator2 = new JTextField(); //Text field where user input denominator
	   int userN2; // numerator input by user
		  int userD2; // denominator input by user
		  
		  JTextField numerator3 = new JTextField(); // Text field where user input numerator 
		   JTextField denominator3 = new JTextField(); //Text field where user input denominator
		   int userN3; // numerator input by user
			  int userD3; // denominator input by user
	     int correct=0;
	
public Summation(){
		setLocationRelativeTo(null);
	    setLayout(new BorderLayout());
	    
	 
		final CardLayout cards = new CardLayout();
		final JPanel cardPanel = new JPanel();
		cardPanel.setLayout(cards);
		JPanel firstCard = new JPanel();
		firstCard.setBackground(Color.GREEN);
		
		Fraction fractionA = new Fraction ();
		Fraction fractionB = new Fraction ();
		final Fraction answer = fractionA.sum(fractionB);
		
		final Fraction fractionA2 = new Fraction ();
		final Fraction fractionB2 = new Fraction ();
		final Fraction answer2 = fractionA2.sum(fractionB2);
		
		final Fraction fractionA3 = new Fraction ();
		final Fraction fractionB3 = new Fraction ();
		final Fraction answer3 = fractionA3.sum(fractionB3);
		
	   numerator = new JTextField("",2);
	   numerator.setFont(new Font("Arial", Font.PLAIN, 20));
	   denominator = new JTextField ("", 2); 
	   denominator.setFont(new Font("Arial", Font.PLAIN, 20));
	   numerator2 = new JTextField("", 2);
	   numerator2.setFont(new Font("Arial", Font.PLAIN, 20));
	   denominator2 = new JTextField ("", 2); 
	   denominator2.setFont(new Font("Arial", Font.PLAIN, 20));
	   numerator3 = new JTextField("", 2);
	   numerator3.setFont(new Font("Arial", Font.PLAIN, 20));
	   denominator3 = new JTextField ("", 2); 
	   denominator3.setFont(new Font("Arial", Font.PLAIN, 20));
	   JButton submit = new JButton ("Submit");
	   submit.setFont(new Font("Arial", Font.PLAIN, 20));
	   submit.setSize(100,100);
	   JButton submit2 = new JButton ("Submit"); 
	   submit2.setFont(new Font("Arial", Font.PLAIN, 20));
	   JButton submit3 = new JButton ("Submit"); 
	   submit3.setFont(new Font("Arial", Font.PLAIN, 20));
	   
	   
	   
	   //Elements of card layout 
	   JPanel secondCard = new JPanel();
	   secondCard.setBackground(Color.BLUE);
	   JPanel thirdCard = new JPanel(); 
	   thirdCard.setBackground(Color.CYAN);
	   JPanel fourthCard = new JPanel();
	   fourthCard.setBackground(Color.YELLOW);
	   JLabel out = new JLabel("out of 3 is correct");
	   fourthCard.add(out);
		cardPanel.add(firstCard, "First");
		cardPanel.add(secondCard, "Second");
		cardPanel.add(thirdCard, "Third");
		cardPanel.add(fourthCard, "Fourth");
		
		cardPanel.setSize(300,300);
		 
		 Border outline = BorderFactory.createLineBorder(Color.black);
		final JPanel tabsPanel = new JPanel();
	        tabsPanel.setBorder(outline);
		 JPanel fraction = question(fractionA, fractionB); 
		tabsPanel.add(fraction);
		tabsPanel.setSize(300,500);
		
		//Elements of the first panel of card layout 
		
		BufferedImage linePicture = null;
	 		try{
	 	linePicture = ImageIO.read(new File("line.png"));
	 		}
	 		catch(IOException ex) {
	 			
	 		}
	 		JLabel picLabel = new JLabel(new ImageIcon(linePicture));
	 		JLabel picLabel2 = new JLabel(new ImageIcon(linePicture));
	 		JLabel picLabel3 = new JLabel(new ImageIcon(linePicture));
	 		
	 		
	 		JLabel ans = new JLabel("  Answer:      ");
	 		JLabel ans2 = new JLabel("  Answer:       ");
	 		JLabel ans3 = new JLabel("  Answer:       ");
	 		
	    	ans.setFont(new Font("Arial", Font.PLAIN, 20));	
	    	ans2.setFont(new Font("Arial", Font.PLAIN, 20));
	    	ans3.setFont(new Font("Arial", Font.PLAIN, 20));
	    		
    		
	   firstCard.setLayout(new FlowLayout());
	   firstCard.add(ans);
	   firstCard.add(numerator);
	   firstCard.add(picLabel);
	   firstCard.add(denominator);
	   firstCard.add(submit); 
	   firstCard.setSize(300,300);
	   
	   // When user clicks the button it checks if he input the right value
	   submit.addActionListener (new ActionListener(){
	    	  public void actionPerformed (ActionEvent event){
	    		  String userIn = numerator.getText();
	    	        String userIn2 = denominator.getText();
	    	        
	    	        try{
	    	        	userN = Integer.parseInt( userIn );
	    	        	userD = Integer.parseInt (userIn2);
	    	    
	    	        	
	    	        
	    	        }
	    	        catch (NumberFormatException nfe){
	    	        	JOptionPane.showMessageDialog(Summation.this, String.format("Input integer value", event.getActionCommand()));
	    	        }
	    	        
	    	        userN = Integer.parseInt( userIn );
    	        	userD = Integer.parseInt (userIn2);
	    	        
	    	    	 
	    	    	/*Checks if user input answer correctly or not 
	    	    	 * if user answers correctly, then show 'correct' message and increase the number of correctly answered questions
	    	    	 * if not, leave the number of correctly answered question
	    	    	 */
    	        	Fraction user = new Fraction (userN, userD);
	    	    	if (user.check(answer)){
	    	    		JOptionPane.showMessageDialog(Summation.this, String.format("Correct", event.getActionCommand()));
	    	    		//setVisible(false);
	    	    		//dispose(); 
	    	    		cards.next(cardPanel);
	    	    		correct=correct+1; 
	    	    		JPanel fraction = question(fractionA2, fractionB2);
	    	    		tabsPanel.removeAll();
	    	    		tabsPanel.add(fraction);
	    	    		
	    	    		
	    	    		
	    	    	}
	    	    	else{
	    	    		JOptionPane.showMessageDialog(Summation.this, String.format("Incorrect", event.getActionCommand()));
	    	    		//setVisible(false);
	    	    		//dispose(); 
	    	    		cards.next(cardPanel);
	    	    		JPanel fraction = question(fractionA2, fractionB2);
	    	    		tabsPanel.removeAll();
	    	    		tabsPanel.add(fraction);
	    	   	 }
	    	  }
	    	  });
	   //include text boxes, labels, set layout of the second card panel 
	   secondCard.setLayout(new FlowLayout());
	   secondCard.add(ans2);
	   secondCard.add(numerator2);
	   secondCard.add(picLabel2);
	   secondCard.add(denominator2);
	   secondCard.add(submit2); 
	   secondCard.setSize(300,300);
	   submit2.addActionListener (new ActionListener(){
	    	  public void actionPerformed (ActionEvent event){
	    		  String userIn = numerator.getText();
	    	        String userIn2 = denominator.getText(); 
	    	        try{
	    	        	userN2 = Integer.parseInt( userIn );
	    	        	
	    	        
	    	        }
	    	        catch (NumberFormatException nfe){
	    	        	JOptionPane.showMessageDialog(null, String.format("Input integer value", event.getActionCommand()));
	    	        }
	    	        try{
	    	        	userD2 = Integer.parseInt( userIn2 );
	    	        	
	    	        
	    	        }
	    	        catch (NumberFormatException nfe){
	    	        	JOptionPane.showMessageDialog(null, String.format("Input integer value", event.getActionCommand()));
	    	        }
	    	        userN2 = Integer.parseInt( userIn );
    	        	userD2 = Integer.parseInt (userIn2);
	    	    	
	    	      Fraction user = new Fraction (userN2, userD2);
	    	    	if (user.check(answer2)==true){
	    	    		JOptionPane.showMessageDialog(null, String.format("Correct", event.getActionCommand()));
	    	    		//setVisible(false);
	    	    		//dispose(); 
	    	    		cards.next(cardPanel);
	    	    		correct=correct+1; 
	    	    		JPanel fraction = question (fractionA3, fractionB3);
	    	    		tabsPanel.removeAll();
	    	    		tabsPanel.add(fraction);
	    	    		
	    	    		
	    	    	}
	    	    	else{
	    	    		JOptionPane.showMessageDialog(null, String.format("Incorrect", event.getActionCommand()));
	    	    		//setVisible(false);
	    	    		//dispose(); 
	    	    		cards.next(cardPanel);
	    	    		JPanel fraction = question (fractionA3, fractionB3);
	    	    		tabsPanel.removeAll();
	    	    		tabsPanel.add(fraction);
	    	   	 }
	    	  }
	    	  });
	 //include text boxes, labels, set layout of the second card panel 
	   thirdCard.setLayout(new FlowLayout());
	   thirdCard.add(ans3);
	   thirdCard.add(numerator3);
	   thirdCard.add(picLabel3);
	   thirdCard.add(denominator3);
	   thirdCard.add(submit3); 
	   thirdCard.setSize(300,300);
	   submit3.addActionListener (new ActionListener(){
	    	  public void actionPerformed (ActionEvent event){
	    		  String userIn = numerator.getText();
	    	        String userIn2 = denominator.getText(); 
	    	        try{
	    	        	userN3 = Integer.parseInt( userIn );
	    	        	
	    	        
	    	        }
	    	        catch (NumberFormatException nfe){
	    	        	JOptionPane.showMessageDialog(null, String.format("Input integer value", event.getActionCommand()));
	    	        }
	    	        try{
	    	        	userD3 = Integer.parseInt( userIn2 );
	    	        	
	    	        
	    	        }
	    	        catch (NumberFormatException nfe){
	    	        	JOptionPane.showMessageDialog(null, String.format("Input integer value", event.getActionCommand()));
	    	        }
	    	        userN3 = Integer.parseInt( userIn );
    	        	userD3 = Integer.parseInt (userIn2);
	    	    	
	    	    	Fraction user = new Fraction (userN3, userD3);
	    	    	if (user.check(answer3)){
	    	    		JOptionPane.showMessageDialog(Summation.this, String.format("Correct", event.getActionCommand()));
	    	    		//setVisible(false);
	    	    		//dispose(); 
	    	    		cards.next(cardPanel);
	    	    		correct = correct+1; 
	    	    		tabsPanel.removeAll();
	    	    		String result = Integer.toString(correct);
	    	    		JLabel resultat = new JLabel(result);
	    	    		tabsPanel.add(resultat);
	    	    		
	    	    		System.out.println(correct);
	    	    		
	    	    		
	    	    	}
	    	    	else{
	    	    		JOptionPane.showMessageDialog(Summation.this, String.format("Incorrect", event.getActionCommand()));
	    	    		//setVisible(false);
	    	    		//dispose(); 
	    	    		cards.next(cardPanel);
	    	    		
	    	    		tabsPanel.removeAll();
	    	    		String result = Integer.toString(correct);
	    	    		JLabel resultat = new JLabel(result);
	    	    		tabsPanel.add(resultat);
	    	    		
	    	    		System.out.println(correct);
	    	   	 }
	    	  }
	    	  });
	   
	   JButton finish = new JButton ("Finish");
	   finish.setFont(new Font("Arial", Font.PLAIN, 20));
	   finish.addActionListener (new ActionListener(){
	    	  public void actionPerformed (ActionEvent event){
	    		  dispose();
	    		  cardPanel.repaint();
	              requestFocus();}
	   });
	   fourthCard.add(finish);
	   
	   
	   add(tabsPanel,BorderLayout.NORTH);
	   add(cardPanel,BorderLayout.CENTER);
	   
	   
	   
	   
		
	}
	// method to create fractions in standard form using 4 integers     
public static JPanel question (Fraction fractionA, Fraction fractionB){
	GridLayout grid = new GridLayout(3,3,0,0);
	int numerator1 = fractionA.getNumer();
	int numerator2 = fractionB.getNumer();
	int denominator1 = fractionA.getDenom();
	int denominator2 = fractionB.getDenom();
	String num1 = Integer.toString(numerator1);
	String num2 = Integer.toString(numerator2);
	String den1 = Integer.toString(denominator1);
	String den2 = Integer.toString(denominator2);
	JLabel n1 = new JLabel(num1);
	n1.setFont(new Font("Arial", Font.PLAIN, 20));
	JLabel n2 = new JLabel(num2);
	n2.setFont(new Font("Arial", Font.PLAIN, 20));
	JLabel d1 = new JLabel(den1);
	d1.setFont(new Font("Arial", Font.PLAIN, 20));
	JLabel d2 = new JLabel(den2);
	d2.setFont(new Font("Arial", Font.PLAIN, 20));
	JPanel panel = new JPanel(grid);
	panel.add(n1);
	panel.add(new JLabel(""));
	panel.add(n2);
	JLabel operation1 = new JLabel(" - ");
	operation1.setFont(new Font("Arial", Font.PLAIN, 20));
	panel.add(operation1);
	JLabel operation = new JLabel("+");
	operation.setFont(new Font("Arial", Font.PLAIN, 20));
	panel.add(operation);
	JLabel operation2 = new JLabel(" - ");
	operation2.setFont(new Font("Arial", Font.PLAIN, 20));
	panel.add(operation2);
	panel.add(d1);
	panel.add(new JLabel(""));
	panel.add(d2);
	
	return (panel); 
	
}


}
	
	
