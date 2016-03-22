package app;

import board.*;
import pieces.*;
import view.view;
import Controller.Controller;

import java.util.*;

/**
 * 
 * 
 * 
 * @author Siddharth Murali
 * @author Karthik Nair
 * 
 *
 */


public class Chess {
	
	public static void main(String[] args){
		Controller control = new Controller();
		view v = new view(control);
		
		Scanner scan = new Scanner(System.in);
		
		while (!control.endGame){
			v.printBoard();
			v.printPrompt();
			String arg = scan.nextLine();
			try {
				v.argument(arg);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
