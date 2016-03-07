import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class PictureQuestions extends JFrame{
	String[] pictures;
	Fraction[] answers;
	int randomNumber;
	int userN; 
	int userD; 
	JTextField numerator = new JTextField(); 
	JTextField denominator = new JTextField();   
	boolean[] toggle;
	int userN2; 
	int userD2; 
	JTextField numerator2 = new JTextField(); 
	JTextField denominator2 = new JTextField(); 
	int userN3; 
	int userD3; 
	JTextField numerator3 = new JTextField(); 
	JTextField denominator3 = new JTextField(); 
	
	
	int correct = 0;
	
	public PictureQuestions(){
		setLocationRelativeTo(null);
	    setLayout(new BorderLayout());
	    
		final CardLayout cards = new CardLayout();
		final JPanel cardPanel = new JPanel();
		cardPanel.setLayout(cards);
		JPanel firstCard = new JPanel();
		firstCard.setBackground(Color.GREEN);
		

		   JPanel secondCard = new JPanel();
		   JPanel thirdCard = new JPanel();
		   JPanel fourthCard = new JPanel();
		   secondCard.setBackground(Color.RED);
		   thirdCard.setBackground(Color.CYAN);
		   fourthCard.setBackground(Color.ORANGE);
			cardPanel.add(firstCard, "First");
			cardPanel.add(secondCard, "Second");
			cardPanel.add(thirdCard,"Third");
			cardPanel.add(fourthCard,"Fourth");
			cardPanel.setSize(300,300);
	    JLabel out = new JLabel("out of 3 is correct");
	    fourthCard.add(out);
		FlowLayout flow = new FlowLayout();
		setLayout(flow);
		pictures = new String[6]; 
		pictures[0]="pic1.png";
		pictures[1]="pic2.png";
		pictures[2]="pic3.png";
		pictures[3]="pic4.png";
		pictures[4]="pic5.png";
		pictures[5]="pic6.png";
		
		answers = new Fraction[6];
		answers[0]= new Fraction(2,3);
		answers[1]= new Fraction(5,9);
		answers[2]= new Fraction(3,8);
		answers[3]= new Fraction(5,9);
		answers[4]= new Fraction(4,9);
		answers[5]= new Fraction(4,9);
		
		toggle = new boolean[6];
		for (int k=0; k<toggle.length; k++ ){
    		toggle[k]=false;
    	}
      
      
		
		//this.randomPicture();
		
		BufferedImage fractionPicture = null;
		try{
	fractionPicture = ImageIO.read(new File(pictures[0]));
		}
		catch(IOException ex) {
			
		}
		JLabel picLabel = new JLabel(new ImageIcon(fractionPicture));
		 
       numerator = new JTextField("Enter numerator", 20);
 	   denominator = new JTextField ("Enter denomiator", 20); 
 	  numerator2 = new JTextField("Enter numerator", 20);
	   denominator2 = new JTextField ("Enter denomiator", 20); 
	   numerator3 = new JTextField("Enter numerator", 20);
	   denominator3 = new JTextField ("Enter denomiator", 20); 
 	   
 	  //String userIn = numerator.getText();
      //String userIn2 = denominator.getText();
 	  
 	   Border outline = BorderFactory.createLineBorder(Color.black);
		final JPanel tabsPanel = new JPanel();
	        tabsPanel.setBorder(outline);
	        tabsPanel.add(picLabel);
 	  
  	   firstCard.setLayout(new FlowLayout());
      // firstCard.add(picLabel);
       firstCard.add(numerator);
       firstCard.add (denominator);
       firstCard.setSize(300,300);
       
       secondCard.add(numerator2);
       secondCard.add (denominator2);
       secondCard.setSize(300,300);
       
       thirdCard.add(numerator3);
       thirdCard.add (denominator3);
       thirdCard.setSize(300,300);
       
       
       
       
        
        JButton submit = new JButton ("Submit");
        JButton submit2 = new JButton ("Submit");
        JButton submit3 = new JButton ("Submit");
        
        firstCard.add(submit);
        secondCard.add(submit2);
        thirdCard.add(submit3);
        
	
        
        submit.addActionListener (new ActionListener(){
	    	  public void actionPerformed (ActionEvent arf0){
	    	  
	  String userIn = numerator.getText();
	  String userIn2 = denominator.getText();  	
	  userN = Integer.parseInt( userIn );
  	  userD = Integer.parseInt( userIn2 );
	    	    	
	    	     Fraction userInput = new Fraction(userN, userD);
	    	   	 Fraction rightAnswer = getAnswer();
	    
	  
	    	   if (userN==2 && userD==3){
	    		  JOptionPane.showMessageDialog(PictureQuestions.this, String.format("Correct", arf0.getActionCommand()));
   	    		
   	    		toggle[randomNumber]=true;
   	    		cards.next(cardPanel);
   	    		BufferedImage fractionPicture = null;
   	 		try{
   	 	fractionPicture = ImageIO.read(new File(pictures[3]));
   	 		}
   	 		catch(IOException ex) {
   	 			
   	 		}
   	 		JLabel picLabel = new JLabel(new ImageIcon(fractionPicture));
   	    		tabsPanel.removeAll();
   	    		
	    		tabsPanel.add(picLabel);
	    		correct=correct+1;
	    		System.out.println(correct);
	    	   }
	    	   
   	    	else {
   	    		JOptionPane.showMessageDialog(PictureQuestions.this, String.format("Incorrect", arf0.getActionCommand()));
   	    		/*
   	    		
	    		setVisible(false);
	    		dispose(); 
	    		toggle[randomNumber]=true;
	    		*/
   	    		BufferedImage fractionPicture = null;
   	   	 		try{
   	   	 	fractionPicture = ImageIO.read(new File(pictures[3]));
   	   	 		}
   	   	 		catch(IOException ex) {
   	   	 			
   	   	 		}
   	    		JLabel picLabel = new JLabel(new ImageIcon(fractionPicture));
   	    		tabsPanel.removeAll();
   	    		
	    		tabsPanel.add(picLabel);
	    		

	    	   }
	    	  }
	    	  });
        
        submit2.addActionListener (new ActionListener(){
        	public void actionPerformed (ActionEvent arf0){
	    	  
	  String userIn = numerator2.getText();
	  String userIn2 = denominator2.getText();  	
	  userN2 = Integer.parseInt( userIn );
	  userD2 = Integer.parseInt( userIn2 );
	    	    	
	    
	  
	    	   if (userN2==5 && userD2==9){
	    		  JOptionPane.showMessageDialog(PictureQuestions.this, String.format("Correct", arf0.getActionCommand()));
 	    		
 	    		toggle[randomNumber]=true;
 	    		cards.next(cardPanel);
 	    		BufferedImage fractionPicture = null;
 	 		try{
 	 	fractionPicture = ImageIO.read(new File(pictures[5]));
 	 		}
 	 		catch(IOException ex) {
 	 			
 	 		}
 	 		JLabel picLabel = new JLabel(new ImageIcon(fractionPicture));
 	    		tabsPanel.removeAll();
 	    		
	    		tabsPanel.add(picLabel);
	    		correct=correct+1;
	    		System.out.println(correct);
	    	   }
 	    	else {
 	    		JOptionPane.showMessageDialog(PictureQuestions.this, String.format("Incorrect", arf0.getActionCommand()));
 	    		/*
 	    		
	    		setVisible(false);
	    		dispose(); 
	    		toggle[randomNumber]=true;
	    		*/
 	    		cards.next(cardPanel);
 	    		BufferedImage fractionPicture = null;
 	 		try{
 	 	fractionPicture = ImageIO.read(new File(pictures[5]));
 	 		}
 	 		catch(IOException ex) {
 	 			
 	 		}
 	 		JLabel picLabel = new JLabel(new ImageIcon(fractionPicture));
 	    		tabsPanel.removeAll();
 	    		
	    		tabsPanel.add(picLabel);

	    	   }
	    	  }
	    	  });
       add(tabsPanel,BorderLayout.NORTH);  
 	   add(cardPanel,BorderLayout.CENTER);
 	  
 	   
 	   
 	   submit3.addActionListener (new ActionListener(){
 		  public void actionPerformed (ActionEvent arf0){
	    	  
	  String userIn = numerator3.getText();
	  String userIn2 = denominator3.getText();  	
	  userN3 = Integer.parseInt( userIn );
	  userD3 = Integer.parseInt( userIn2 );
	    	    	
	    
	  
	    	   if (userN3==4 && userD3==9){
	    		  JOptionPane.showMessageDialog(PictureQuestions.this, String.format("Correct", arf0.getActionCommand()));
	    		   correct=correct+1;
	    		toggle[randomNumber]=true;
	    		cards.next(cardPanel);
	    		
	    		tabsPanel.removeAll();
	    		String result = Integer.toString(correct);
	    		JLabel resultat = new JLabel(result);
	    		tabsPanel.add(resultat);
	    		
	    		System.out.println(correct);
	    	   }
	    	else {
	    		JOptionPane.showMessageDialog(PictureQuestions.this, String.format("Incorrect", arf0.getActionCommand()));
	    		/*
	    		
	    		setVisible(false);
	    		dispose(); 
	    		toggle[randomNumber]=true;
	    		*/
	    		cards.next(cardPanel);
	    		tabsPanel.removeAll();
	    		String result = Integer.toString(correct);
	    		JLabel resultat = new JLabel(result);
	    		tabsPanel.add(resultat);

	    	   }
	    	  }
	    	  });
     add(tabsPanel,BorderLayout.NORTH);  
	   add(cardPanel,BorderLayout.CENTER);
	   
	    	  
	}
	
	
	public Fraction getAnswer(){
		return answers[randomNumber];
	
	}
	public String getPicture(int pictureNumber){
		return pictures[pictureNumber];
	}
    public void randomPicture(){
    	int numberOfPictures = pictures.length;
    	while (true){
    		randomNumber = (int) (Math.random()*(numberOfPictures));	
    	if(toggle[randomNumber]==false)	
    	break;
    	}
    	this.showPicture(randomNumber);
    	System.out.println(randomNumber);
    }
   
    
    private void showPicture(int number){
    	BufferedImage fractionPicture = null;
		try{
	fractionPicture = ImageIO.read(new File(pictures[number]));
		}
		catch(IOException ex) {
			
		}
		JLabel picLabel = new JLabel(new ImageIcon(fractionPicture));
		
		add(picLabel);
    	
    }
}
