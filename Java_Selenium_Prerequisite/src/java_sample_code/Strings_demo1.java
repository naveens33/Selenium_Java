//Code to understand split and parseInt 
package java_sample_code;

import java.util.Scanner;

public class Strings_demo1 {

	public static void main(String[] args) {
		double num=1000,balance;
		String spent;
		System.out.println("Enter the amount to be drawn: ");
		Scanner sc=new Scanner(System.in);
	    spent=sc.next();
	    String number[]=spent.split("\\.");
	    number[1]=number[1]+"."+number[2];
		balance=1000-Float.parseFloat(number[1]);
		System.out.println("balance :Rs."+balance);
		System.out.println("spent :Rs."+number[1]);
	}
}
