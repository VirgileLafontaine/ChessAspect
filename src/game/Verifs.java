package game;
import agent.Move;
import game.Board;
public class Verifs {
	
	
	public boolean moveIsLegit(Move mov, Board brd){
		//deplacement sur place
		if (mov.xI==mov.xF && mov.yI==mov.yF){return false;}
		
		//case vide
		if (!brd.getGrid()[mov.xI][mov.yI].isOccupied()){return false;}
		
		//piece IA
		if (brd.getGrid()[mov.xI][mov.yI].getPiece().getPlayer() == 1){return false;}
		
		//depart ou arrivée hors tableau
		if (	mov.xI <'a' || mov.xI > 'h' || mov.xF < 'a' || mov.xF> 'h'||
				mov.yI <0 || mov.yI > 7 || mov.xF < 0 || mov.xF> 7){
			return false;
		}
		switch (brd.getGrid()[mov.xI][mov.yI].getPiece().toString()){
		case "P" :
			//mange une piece adverse
			if ((mov.xF==mov.xI+1 || mov.xF==mov.xI-1) && mov.yF == mov.yF+1 && brd.getGrid()[mov.xI][mov.yI].isOccupied()){
				if (brd.getGrid()[mov.xI][mov.yI].getPiece().getPlayer() == 1){
					return true;
				}
			}
			//deplace pos départ
			if (mov.yI==2){
				if (mov.yF == mov.yI+2 && !brd.getGrid()[mov.xI][mov.yI+1].isOccupied() ){
					return true;
				}
			}
			//déplace
			if (mov.yF == mov.yI+1){
				return true;
			}
			break;
		case "T" :
			
		}
		
		return true;
	}
}
