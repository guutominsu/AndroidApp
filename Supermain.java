
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class Supermain {

	public static void main(String[] args){
		 final JFrame main = new JFrame("Main"); 
		
		main.setSize(700,700);
		main.setBackground(Color.RED); 
		 
		
       
		
		final Summation summation = new Summation();
		summation.setSize (160, 300);
		
        final Difference difference = new Difference();
		difference.setSize(160,300);
		
		final Multiplication multiplication = new Multiplication();
		multiplication.setSize(160,300);
		
		final Division division = new Division();
		division.setSize(160,300);
		
		final PictureQuestions pictureQuestions = new PictureQuestions();
		pictureQuestions.setSize(700,700);
		
		
		
		
		main.setVisible(false);
		
		//Make links to different types of questions in the main menu, using GridLayout
		final String[] names =
			{ "Understanding (Pie)", "Understanding (Line)","Summation", "Subtraction", "Multiplication", "Division",  "Fraction in pictures", "Exit"};
		
		GridLayout menu = new GridLayout(8,1,5,5); 
		
		main.setLayout(menu); 
	
		JButton[] buttons = new JButton[names.length]; 
		//adding all  buttons into the main menu 
		for ( int count = 0; count < names.length; count++ )
		 {
		buttons[ count ] = new JButton( names[ count ] );
		buttons[count].setBackground(Color.CYAN); 
		buttons[count].setFont(new Font("Arial", Font.BOLD, 40));
		main.add( buttons[ count ] ); // add button to JFrame
		} 
		
		//Button listeners to open frames of quizzes when the button is clicked
		
		buttons[2].addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 //main.setVisible(false);
	        	 summation.setVisible(true);
	         }
	});
		
		buttons[1].addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 //main.setVisible(false);
	        	 final DrawLi line = new DrawLi();
	             line.setSize(1000,600);
	         }
	});
		
		buttons[0].addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 //main.setVisible(false);
	        	 final DrawPie pie = new DrawPie(); 
	        	 pie.setSize(1000,700); 
	         }
	});
		
		buttons[3].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				difference.setVisible(true); 
			}
		});
		
		buttons[4].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				multiplication.setVisible(true); 
			}
		});
		
		buttons[5].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				division.setVisible(true); 
			}
		});
		
		buttons[6].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				pictureQuestions.setVisible(true); 
			}
		});
		
		buttons[7].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0); 
			}
		});
		
		
	   main.setVisible(true);
	}
}

	
	
	
