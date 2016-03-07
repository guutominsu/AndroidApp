import java.util.ArrayList;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.* ;

import java.util.Scanner;
import java.util.List;

import javax.swing.JLabel;


public class Fraction {
int numer; // numerator of a fraction
int denom; // denominator of a fraction 


public Fraction(){
	int randomNum = (int) (1+(Math.random()*(10-1)));
	int randomDen = (int) (1+(Math.random()*(10-1)));
	
	
	while(randomNum>=randomDen){
		randomNum = (int) (1+(Math.random()*(10-1)));
		randomDen = (int) (1+(Math.random()*(10-1)));
	}
	this.numer=randomNum;
	this.denom=randomDen;
}
public Fraction (int numer, int denom){
	
	
	
	this.numer=numer;
	this.denom=denom;
}

public int getNumer(){
	return numer;
}
public int getDenom(){
	return denom;
}

//Add one fractio to another
public Fraction sum(Fraction x){
	Fraction answer;
	int den = denom*x.getDenom();
	int num = numer*x.getDenom()+denom*x.getNumer(); 
	 
	answer = new Fraction(num,den);
	answer = reduce(answer);
	return answer;
}

//Subtract one fraction to another 
public Fraction difference(Fraction x){
	Fraction answer;
	int d = denom*x.getDenom();
	int n = numer*x.getDenom()-denom*x.getNumer();
	answer = new Fraction(n,d);
	answer = reduce(answer);
	return answer;
}
//multiply two fractions
public Fraction multiply(Fraction x){
	Fraction answer;
	int d = denom*x.getDenom();
	int n = numer*x.getNumer();
	answer = new Fraction(n,d);
	answer = reduce(answer);
	return answer;
}

// divide two fractions 
public Fraction divide(Fraction x){
	Fraction answer;
	int d = denom*x.getNumer();
	int n = numer*x.getDenom();
	answer = new Fraction (n,d);
	answer = reduce(answer);
	return answer;
}

// Collect prime factors of a number into array list (this is for reduce())
public static List<Integer> primeFactors(int number) {
	  int n = number;
	  List<Integer> factors = new ArrayList<Integer>();
	  for (int i = 2; i <= n; i++) {
	    while (n % i == 0) {
	      factors.add(i);
	      n/=i;

	    }
	  }
	  return factors;
	}

// Reduce a fraction 
public static Fraction reduce(Fraction x){
	Fraction answer; 
	List<Integer> factors1 = primeFactors(x.numer);
	List<Integer> factors2 = primeFactors(x.denom);
	Integer[] factorsN=factors1.toArray(new Integer[factors1.size()]);
	Integer[] factorsD=factors2.toArray(new Integer[factors2.size()]);
	for (int i=0; i<factorsN.length; i++){
		for (int n=0; n<factorsD.length;n++){
			if (factorsN[i]==factorsD[n]){
				factorsN[i]=1;
				factorsD[n]=1;
			}
		
		}
	}
    int num=1;
	for (int k=0; k<factorsN.length; k++){
		num=num*factorsN[k];
			}
	int denom=1;
	for (int g=0; g<factorsD.length; g++){
		denom=denom*factorsD[g];
	}
	answer = new Fraction (num,denom);
	return answer;
}
	
	//Write fractions in String
public String toString()
{
return (Integer.toString(numer) + "/" +
         Integer.toString(denom));
}
public boolean check(Fraction fractionB){
	int nA = this.numer;
	int dA = this.denom;
	int nB = fractionB.getNumer();
	int dB = fractionB.getDenom();
	
	if (nA*dB == dA*nB){
		return true;
	}
	else {
		return false;
	}
}
}

