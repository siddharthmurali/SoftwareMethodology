package board;
import pieces.*;
import util.*;

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

	public void movePiece(Coordinates cellOne, Coordinates cellTwo, String promo) throws BadMoveException{
		BoardSquares begin = this.getFileRank(cellOne);
		BoardSquares end = this.getFileRank(cellTwo);

		//this.printColors();

		ChessPiece pieceToMove = begin.piece;
		ChessPiece pieceToKill = end.piece;

		if(begin.equals(end)){
			System.out.println("Cannot move to same spot");
		}else if(pieceToMove == null){
			System.out.println("There is no piece to move in that cell");
		}
		
		else if(pieceToMove.color == 'b' && getBlackTurn() == false){
			System.out.println("You cannot move a black piece");
		}
		else if(pieceToMove.color == 'w' && getBlackTurn() == true){
			System.out.println("You cannot move a white piece");
		}
		
		else if(pieceToKill != null){
			if(pieceToKill.color == 'b' && getBlackTurn() == true){
				System.out.println("You cannot kill your own piece");
			}
			if(pieceToKill.color == 'w' && getBlackTurn() == false){
				System.out.println("You cannot kill your own piece");
			}
		}
		this.move(cellOne, cellTwo);
	}


	private boolean boardHasPieceInPathBetween(Coordinates startAddress, Coordinates endAddress) {

		if (false) {
			System.out.println("boardHasPieceInPathBetween(" + startAddress
					+ ", " + endAddress + ");");
			System.out.println("\tstartAddress.rank = " + startAddress.rankC);
			System.out.println("\tstartAddress.file = " + startAddress.fileC);
			System.out.println("\tendAddress.rank = " + endAddress.rankC);
			System.out.println("\tendAddress.file = " + endAddress.fileC);
		}

		if (startAddress.hasSameFileAs(endAddress)) {

			if (startAddress.rankC < endAddress.rankC) {
				for (int i = startAddress.rankC + 1; i < endAddress.rankC; i++) {
					if (board[i][startAddress.fileC].isEmpty()) {
						return true;
					}
				}
			} else {
				for (int i = startAddress.rankC - 1; i > endAddress.rankC; i--) {
					if (board[i][startAddress.fileC].isEmpty()) {
						return true;
					}
				}
			}

		} else if (startAddress.hasSameRankAs(endAddress)) {
			if (startAddress.fileC < endAddress.fileC) {
				for (int i = startAddress.fileC + 1; i < endAddress.fileC; i++) {
					if (board[startAddress.rankC][i].isEmpty()) {
						return true;
					}
				} 
			} else {
				for (int i = startAddress.fileC - 1; i > endAddress.fileC; i--) {
					if (board[startAddress.rankC][i].isEmpty()) {
						return true;
					}
				} 
			}
		} else if (startAddress.isDiagonalTo(endAddress)) {

			if (false) {
				System.out.printf("\n\t\t\t%s isDiagonalTo %s\n",
						startAddress.toString(), endAddress.toString());
			}

			if (startAddress.isAdjacentTo(endAddress)) {
				if (!((BoardSquares) this.squareAt(endAddress)).isEmpty()){
					return true;
				} else {

					int changeInFile;
					int changeInRank;

					int currentRank = startAddress.rankC;
					int currentFile = startAddress.fileC;

					if (endAddress.fileC > startAddress.fileC) {
						changeInFile = 1;
					} else {
						changeInFile = -1;
					}

					if (endAddress.rankC > startAddress.rankC) {
						changeInRank = 1;
					} else {
						changeInRank = -1;
					}

					currentRank += changeInRank;
					currentFile += changeInFile;

					while (currentFile != endAddress.fileC
							&& currentRank != endAddress.rankC) {

						if (false) {
							System.out.println("\t\t\tChecking " + currentRank
									+ " " + currentFile);
						}

						if (this.board[currentRank][currentFile].isEmpty()) {
							if (false) {
								System.out.println("\t\t\tOccupied!" + currentRank
										+ " " + currentFile);
							}
							return true;
						}

						currentFile += changeInFile;
						currentRank += changeInRank;
					}
				}
			}


		}
		return false;
	}
	private Object squareAt(Coordinates endAddress) {
		// TODO Auto-generated method stub
		return null;
	}

	private boolean Check() {
		for (int currentRank = 0; currentRank < this.board.length; currentRank++) {
			for (int currentFile = 0; currentFile < this.board[currentRank].length; currentFile++) {
				if (this.board[currentRank][currentFile].isEmpty()
						&& this.board[currentRank][currentFile].piece.isBlack == this.isBlackTurn) {
					return isPieceCollidingWithKingAt(currentRank, currentFile);
				}
			}
		}

		return false;
	}

	private boolean isPieceCollidingWithKingAt(int currentRank, int currentFile) {
		ChessPiece cp = this.board[rank][file].piece;
		Coordinates startAddress = new Coordinates(rank, file);
		ArrayList<Coordinates> deepestMoves = cp.deepestMovesFrom(startAddress);

		for (int i = 0; i < deepestMoves.size(); i++) {
			if (this.kingIsFirstCollisionInPathBetween(startAddress, deepestMoves.get(i))) {
				return true;
			}
		}
		return false;
	}

	private boolean kingIsFirstCollisionInPathBetween(Coordinates startAddress, Coordinates endAddress) {

		if (startAddress.fileC == endAddress.fileC) {
			for (int i = startAddress.rankC + 1; i < endAddress.rankC; i++) {
				if (board[i][startAddress.fileC].isEmpty()) {
					return board[i][startAddress.fileC].piece instanceof KingPiece;
				}
			}
		} else if (startAddress.rankC == endAddress.rankC) {
			for (int i = startAddress.fileC + 1; i < endAddress.fileC; i++) {
				if (board[startAddress.rankC][i].isEmpty()) {
					return board[startAddress.rankC][i].piece instanceof KingPiece;
				}
			}
		} else if (startAddress.isDiagonalTo(endAddress)) {

			int changeInFile;
			int changeInRank;

			int currentRank = startAddress.rankC;
			int currentFile = startAddress.fileC;

			if (endAddress.fileC > startAddress.fileC) {
				changeInFile = 1;
			} else {
				changeInFile = -1;
			}

			if (endAddress.rankC > startAddress.rankC) {
				changeInRank = 1;
			} else {
				changeInRank = -1;
			}

			currentRank += changeInRank;
			currentFile += changeInFile;

			while (currentFile != endAddress.fileC
					&& currentRank != endAddress.rankC) {

				if (false) {
					System.out.println("\t\t\tChecking " + currentRank + " "
							+ currentFile);
				}

				if (this.board[currentRank][currentFile].isEmpty()) {
					if (false) {
						System.out.println("\t\t\tOccupied!" + currentRank
								+ " " + currentFile);
					}
					return this.board[currentRank][currentFile].piece instanceof KingPiece;
				}

				currentFile += changeInFile;
				currentRank += changeInRank;

			}
		}
		return false;
	}

	public void move(Coordinates cellOne, Coordinates cellTwo){

		this.board[cellTwo.rankC][cellTwo.fileC].piece = this.board[cellOne.rankC][cellTwo.fileC].piece;
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

	/*public void printColors(){
		for(int i = 0; i<board.length; i++){
			for(int j = 0; j<board[i].length; j++){
				if(board[i][j].piece != null){
					System.out.println("Board["+i+"]["+j+"] : "+ board[i][j].piece.color);
				}
			}
		}
	}*/

}
