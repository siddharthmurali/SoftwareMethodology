package util;

public class Coordinates {
	
	public int fileC;
	public int rankC;
	
	public Coordinates(char file, char rank){
		
		int fileNUM = getFile(file);
		int rankNUM = getRank(rank);
		
		if(file > 7 || file < 0){
			//throw error;
		}
		if(rank > 7 || rank < 0){
			//throw error;
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
			case 'a': return 1;
			case 'b': return 2;
			case 'c': return 3;
			case 'd': return 4;
			case 'e': return 5;
			case 'f': return 6;
			case 'g': return 7;
		}
		return -1;	
	}
	
	public int getRank(char rank){
		return Character.getNumericValue(rank)-1;
		
	}
	
}
