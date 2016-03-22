package util;

/**
 * 
 * 
 * @author Siddharth Murali
 * @author Karthik Nair
 *
 */
public class Coordinates {
	
	public int fileC;
	public int rankC;
	
	public Coordinates(char file, char rank) throws Exception{
		
		int fileNUM = getFile(file);
		int rankNUM = getRank(rank);
		
		if(fileNUM > 7 || fileNUM < 0){
			System.out.println("Invalid File");
		}
		if(rankNUM > 7 || rank < 0){
			System.out.println("Invalid Rank");
		}
		
		this.fileC = fileNUM;
		this.rankC = rankNUM;
		
	}
	
	public Coordinates(int file, int rank){
		
		this.fileC = file;
		this.rankC = rank;
	}
	
	public int getFile(char file){
		
		switch(file){
			case 'a': return 0;
			case 'b': return 1;
			case 'c': return 2;
			case 'd': return 3;
			case 'e': return 4;
			case 'f': return 5;
			case 'g': return 6;
			case 'h': return 7;
		}
		return -1;	
	}
	
	public int getRank(char rank){
		int num  = Character.getNumericValue(rank);
		
		switch(num){
			case 1: return 7;
			case 2: return 6;
			case 3: return 5;
			case 4: return 4;
			case 5: return 3;
			case 6: return 2;
			case 7: return 1;
			case 8: return 0;
		}
		
		return -1;
		
	}

	public boolean isDiagonalTo(Coordinates coor) {
		if (this.equals(coor)) {
			return false;
		} else {
			int slope = this.getSlopeTo(coor);
			System.out.println("SLOPE: " +slope);
			
			if (slope == 1 || slope == -1)
				return true;
			else
				return false;
		}
	}
	
	public int getSlopeTo(Coordinates coor) {
		int rankOne = this.rankC + 1;
		int fileOne = this.fileC + 1;

		int rankTwo = coor.rankC + 1;
		int fileTwo = coor.fileC + 1;

		int denominator = fileOne - fileTwo;
		
		if (denominator != 0)
			return (rankOne - rankTwo) / denominator;
		else
			return 0;
	}

	public boolean isAdjacentTo(Coordinates coor) {
		
		if(this.rankC == coor.rankC){
			if(this.fileC <= coor.fileC + 1 && this.fileC >= coor.fileC - 1){
				return true;
			}
		}else if(this.fileC == coor.fileC){
			if (this.rankC <= coor.rankC + 1 && this.rankC >= coor.rankC - 1) {
				return true;
			}
		}
			return false;
		
	}

	public boolean hasSameFileAs(Coordinates coor) {
		if (this.fileC == coor.fileC)
			return true;
		else
			return false;
		
	}

	public boolean hasSameRankAs(Coordinates coor) {
		if (this.rankC == coor.rankC)
			return true;
		else{
			return false;
		}
	}
	
}
