package java_sample_code;

import java.util.Scanner;

public class Strings_Con_1 {

	public static void main(String[] args) {
			String str="";
			Scanner input=new Scanner(System.in);
			System.out.print("Enter the name: ");
			str=input.nextLine();
			System.out.println("The given name is: "+str);
			System.out.println("length: "+str.length());
			System.out.println("subString1: "+str.substring(3));
			System.out.println("subString2: "+str.substring(2,4));
			System.out.println("indexOf: "+str.indexOf('o'));
			System.out.println("charAt: "+str.charAt(1));
			String[] strarray=str.split(":");
			System.out.println(strarray[0]);
			System.out.println(strarray[1]);
			System.out.println(strarray.length);
	}

}
