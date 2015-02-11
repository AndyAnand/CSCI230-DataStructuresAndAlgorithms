package stringPackage;

import java.util.Scanner;

/** 
This class was created in order to accomplish the first assignment of the Data Structures and Algorithms course.
It first receives a set of characters from the keyboard, stores it in a 1D char array. After that another 
1D array is created and filled with the reverse content of the user input. Lastly, the reverse content is
printed.
@author Andy Gajadhar
@since August 22, 2014
NOTE: Everything was tested and found to be working, that is: Reading a string from keyboard, reversing it and
printing it on screen.
*/ 

public class StringReversal {
	
	/**
	The readInput method reads an string from the keyboard and stores it in a 1D char array.
	It was created for internal use only.
	@return The 1D char array containing the read characters.
	*/
	private char[] readInput(){
		Scanner in = new Scanner(System.in);
		String typed = in.next();
		
		in.close();
		System.out.println("The input String is: " + typed);
		
		return typed.toLowerCase().toCharArray();
	}
	
	/**
	The reverse method process an 1D char array returning a new one with reverse content.
	It was created for internal use only.
	@param string The 1D char array to be reversed.
	@return A 1D char array with reversed content
	*/
	private String reverse(char[] string){
		char[] reverseString = new char[string.length];
		
		for(int i = 0; i < string.length; i++){
			reverseString[i] = string[string.length-1-i];
		}
		
		return new String(reverseString);
	}
	
	/**
	The getReverseString method is responsible for doing all the job. It gets some characters from keyboard, reverse
	and outputs them as String.
	@return A reversed String of the content read by the keyboard.
	*/
	public String getReverseString(){
		char[] input = readInput();
		
		return reverse(input);
	}
	
	/**
	Just using StringReversal Class.
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringReversal s = new StringReversal();
		
		System.out.println("The reversed String is: " + s.getReverseString());
	}

}
