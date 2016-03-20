package view;
import Controller.*;
import util.*;

/**
 * 
 * @author Siddharth Murali
 * @author Karthik Nair
 *
 */
public class view {

	public Controller control;
	public boolean askForDraw;
	
	public view(Controller controller){
		this.control = controller;
	}
	
	@SuppressWarnings("null")
	public void argument(String arg){
		if(arg.equals("resign")){
			if(this.control.blackTurn() == true){
				System.out.println("White wins!");
			}
			else{
				System.out.println("Black Wins");
			}
			this.control.resignGame();
		}
		
		if(arg.contains("draw?")){
			this.askForDraw = true;
		}
		if(arg.equals("draw")){
			if(askForDraw == true){
				System.out.println("Draw");
				this.control.endGame = true;
			}
		}
		if(arg.length() == 5 && !arg.equals("draw?")){
			char fileOne = arg.charAt(0);
			char rankOne = arg.charAt(1);
			char fileTwo = arg.charAt(3);
			char rankTwo = arg.charAt(4);
		
			
		
			control.move(fileOne, rankOne, fileTwo, rankTwo, null);
		
		}
		
		if(arg.length() == 7){
			char fileOne = arg.charAt(0);
			char rankOne = arg.charAt(1);
			char fileTwo = arg.charAt(3);
			char rankTwo = arg.charAt(4);
			
			String toPromote = arg.substring(5, 6);
			
			
		
			control.move(fileOne, rankOne, fileTwo, rankTwo, toPromote);
		}
	}
	
	public void printBoard(){
		System.out.println(this.control.getBoardString());
	}
	
	public void printPrompt(){
		System.out.println(control.blackTurn() ? "Black's turn: " : "White's turn: ");
	}
	
}
