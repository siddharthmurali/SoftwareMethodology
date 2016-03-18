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
	}
	
	public void printBoard(){
		System.out.println(this.control.getBoardString());
	}
	
	public void printPrompt(){
		System.out.println(control.blackTurn() ? "Black's turn: " : "White's turn: ");
	}
	
}
