package de.ks.kalaha.controller;

import de.ks.kalaha.model.Kalaha;
import de.ks.kalaha.model.Through;
import de.ks.kalaha.model.util.ThroughSet;

public class GameLogicController {
	
	private Kalaha kalaha;
	private int movesCurrentPlayer = 1;
	

	public GameLogicController(Kalaha kalaha) {
		this.kalaha = kalaha;
	}
	
	//TODO private
	public void takeTurn(Through selectedThrough){
		moveSeeds(selectedThrough);
		checkEnd();
		if(movesCurrentPlayer == 0){ 
			kalaha.setCurrentPlayer(kalaha.getCurrentPlayer().getNextPlayer()); //Set nextPlayer as currentPlayer
			movesCurrentPlayer = 1;
		}
		
	}
	
	//TODO private
	public void moveSeeds(Through source){
		movesCurrentPlayer --;
		int seedsInSource = source.getSeed();
		Through lastThroughGetSeed = source;
		
		for(int i = 0; i < seedsInSource; i++){
			Through targetThrough = source;
			//set next Through
			for(int j = 0; j < i + 1 ; j++){
				targetThrough = targetThrough.getNextThrough();
			}
			
			//put seeds in next Throughs
			if(!(targetThrough.isKalaha() == true 
					&& targetThrough.getPlayer() != kalaha.getCurrentPlayer())){ //skip opponents Kalaha
				source.setSeed(source.getSeed() - 1);
				targetThrough.setSeed(targetThrough.getSeed() + 1);
			}else{
				seedsInSource ++; //When skipping opponent Kalaha, you have this seed to set in the next Through
			}
			
			lastThroughGetSeed = targetThrough;
		}
		//check if there must be a bag
		if(lastThroughGetSeed.getPlayer() == kalaha.getCurrentPlayer() 
				&& lastThroughGetSeed.isKalaha() == false
				&& lastThroughGetSeed.getSeed() == 1){
			bag(lastThroughGetSeed);
		}
		//check if player gets an extra move
		if(lastThroughGetSeed.getPlayer() == kalaha.getCurrentPlayer() 
				&& lastThroughGetSeed.isKalaha() == true){
			movesCurrentPlayer ++;
		}
	}
	
	//TODO private
	public void bag(Through source) {
		Through playersKalaha = kalaha.getCurrentPlayer().getThroughs().hasKalaha(true).first();
		Through target = source.getOpposite();
		
		playersKalaha.setSeed(playersKalaha.getSeed() + source.getSeed() + target.getSeed());
		
		source.setSeed(0);
		target.setSeed(0);
		
		
	}

	//TODO private
	public boolean checkEnd(){
		ThroughSet currentPlayerThroughs = kalaha.getCurrentPlayer().getThroughs().hasKalaha(false);
		for (Through through : currentPlayerThroughs) {
			if(through.getSeed() != 0){
				return false;
			}
		}
		return true;
	}
	
	public void handleClickOnThrough(){
		
	}

	public Kalaha getKalaha(){
		return this.kalaha;
	}

}
