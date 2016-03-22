package board;
import pieces.*;


import java.util.ArrayList;

import Controller.*;

/**
 * @author Siddharth Murali
 * @author Karthik Nair
 * 
 */

import pieces.BishopPiece;
import pieces.KingPiece;
import pieces.KnightPiece;
import pieces.PawnPiece;
import pieces.QueenPiece;
import pieces.RookPiece;
import util.Coordinates;

public class ChessBoard {
	public int count = 0;
	public static final int rank = 8;
	public static final int file = 8;
	public BoardSquares[][] board;
	public boolean isBlackTurn = true;


	public static boolean isEqual(Object o1, Object o2) {
	    return o1 == o2 || (o1 != null && o1.equals(o2));
	}
	
	public ChessBoard(){

		board = new BoardSquares[rank][file];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = new BoardSquares(new Coordinates(i, j), null);

			}
		}

		this.loadGameBoard();

	}

	public void loadGameBoard(){

		char color = 0;

		for(int i = 0; i < file; i++){

			for(int j = 0; j < rank; j++){

				if(i == 0 || i == 7){

					if(i == 0){
						color = 'b';
					}else{
						color = 'w';
					}


					switch(j){

					case 0: board[i][j].piece = new RookPiece(color);			
					break;
					case 1: board[i][j].piece = new KnightPiece(color);
					break;
					case 2: board[i][j].piece = new BishopPiece(color);
					break;
					case 3: board[i][j].piece = new QueenPiece(color);
					break;
					case 4: board[i][j].piece = new KingPiece(color);
					break;
					case 5: board[i][j].piece = new BishopPiece(color);
					break;	
					case 6: board[i][j].piece = new KnightPiece(color);
					break;
					case 7: board[i][j].piece = new RookPiece(color);
					break;
					default: break;
					}
				}
				else if(i == 1 || i == 6){
					if(i == 1){
						color = 'b';
					}else{
						color = 'w';
					}
					board[i][j].piece = new PawnPiece(color);
				}
			}
		}

	}

	public void movePiece(Coordinates cellOne, Coordinates cellTwo, String promo){
		BoardSquares begin = this.getFileRank(cellOne);
		BoardSquares end = this.getFileRank(cellTwo);
		char type = 0;

		//this.printColors();

		ChessPiece pieceToMove = begin.piece;
		ChessPiece pieceToKill = end.piece;
		boolean pathBlocked = this.pieceInPath(cellOne, cellTwo);

		if(begin.equals(end)){
			System.out.println();
			System.out.println("Illegal move, try again");
			System.out.println();
			return;
		}else if(pieceToMove == null){
			System.out.println("Illegal move, try again");
			return;
		}
		
		else if(pieceToMove.color == 'b' && getBlackTurn() == false){
			System.out.println();
			System.out.println("Illegal move, try again");
			System.out.println();
			return;
		}
		else if(pieceToMove.color == 'w' && getBlackTurn() == true){
			System.out.println();
			System.out.println("Illegal move, try again");
			System.out.println();
			return;
		}
		
		else if(pieceToKill != null){
			type = 'c';
			if(pieceToKill.color == 'b' && getBlackTurn() == true){
				System.out.println();
				System.out.println("Illegal move, try again");
				System.out.println();
				return;
			}
			if(pieceToKill.color == 'w' && getBlackTurn() == false){
				System.out.println();
				System.out.println("Illegal move, try again");
				System.out.println();
				return;
			}
		}
		if(checked(begin.piece, cellOne, cellTwo)){
			System.out.println();
			System.out.println("King is in Check");
			System.out.println();
		}
			
		if(pieceToMove.validMove(cellOne, cellTwo, type, pathBlocked)){
			this.move(cellOne, cellTwo);
		}	
	}


	private boolean pieceInPath(Coordinates start, Coordinates end) {


		if (start.hasSameFileAs(end)) {

			if (start.rankC < end.rankC) {
				for (int i = start.rankC + 1; i < end.rankC; i++) {
					if (board[i][start.fileC].isEmpty()) {
						return true;
					}
				}
			} else {
				for (int i = start.rankC - 1; i > end.rankC; i--) {
					if (board[i][start.fileC].isEmpty()) {
						return true;
					}
				}
			}

		} else if (start.hasSameRankAs(end)) {
			if (start.fileC < end.fileC) {
				for (int i = start.fileC + 1; i < end.fileC; i++) {
					if (board[start.rankC][i].isEmpty()) {
						return true;
					}
				} 
			} else {
				for (int i = start.fileC - 1; i > end.fileC; i--) {
					if (board[start.rankC][i].isEmpty()) {
						return true;
					}
				} 
			}
		} else if (start.isDiagonalTo(end)) {

			if (start.isAdjacentTo(end)) {
				if (!((BoardSquares) this.squareAt(end)).isEmpty()){
					return true;
				} else {

					int changeInFile;
					int changeInRank;

					int currentRank = start.rankC;
					int currentFile = start.fileC;

					if (end.fileC > start.fileC) {
						changeInFile = 1;
					} else {
						changeInFile = -1;
					}

					if (end.rankC > start.rankC) {
						changeInRank = 1;
					} else {
						changeInRank = -1;
					}

					currentRank += changeInRank;
					currentFile += changeInFile;

					while (currentFile != end.fileC && currentRank != end.rankC) {

						currentFile += changeInFile;
						currentRank += changeInRank;
					}
				}
			}


		}
		return false;
	}
	private Object squareAt(Coordinates coor) {
		return board[coor.rankC][coor.fileC];
	}
	
	private boolean checked(ChessPiece piece, Coordinates begin, Coordinates end){
		int currRank = end.rankC;
		int currFile = end.fileC;
		BoardSquares diagonalRight = this.board[end.rankC+1][end.fileC+1];
		BoardSquares diagonalLeft = this.board[end.rankC+1][end.fileC-1];
		BoardSquares left = this.board[end.rankC][end.fileC-1];
		BoardSquares right = this.board[end.rankC][end.fileC+1];
		BoardSquares up = this.board[end.rankC+1][end.fileC];
		BoardSquares down = this.board[end.rankC-1][end.fileC];
		
		if(piece.type.equals("PAWN")){
			if(diagonalRight.piece == null){
				return false;
			}
			if(diagonalLeft.piece == null){
				return false;
			}
			if(diagonalRight.piece.type.equals("KING") && diagonalRight.piece.isBlack != getBlackTurn()){
				return true;
			}
			if(diagonalLeft.piece.type.equals("KING") && diagonalRight.piece.isBlack != getBlackTurn()){
				return true;
			}
		}
		return false;
	}

	public void move(Coordinates cellOne, Coordinates cellTwo){
		
		this.board[cellOne.rankC][cellOne.fileC].piece.move++;
		this.board[cellTwo.rankC][cellTwo.fileC].piece = this.board[cellOne.rankC][cellOne.fileC].piece;
		this.board[cellOne.rankC][cellOne.fileC].piece = null;
		this.count++;
		this.isBlackTurn = (count % 2 == 0);
	}

	public String toString() {
		String str = "";
		int count = 8;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				str += this.board[i][j].toString() + " ";
			}

			str += (count) + "\n";
			count--;
		}

		str += " a  b  c  d  e  f  g  h\n";

		return str;
	}

	public boolean getBlackTurn(){
		return !isBlackTurn;
	}

	private BoardSquares getFileRank(Coordinates coor){
		return board[coor.rankC][coor.fileC];
	}

}
