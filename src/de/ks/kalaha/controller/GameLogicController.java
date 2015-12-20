package de.ks.kalaha.controller;

import de.ks.kalaha.model.Kalaha;
import de.ks.kalaha.model.Through;

public class GameLogicController {
	
	private Kalaha kalaha;

	public GameLogicController(Kalaha kalaha) {
		this.kalaha = kalaha;
	}
	
	private void takeTurn(){
		
	}
	
	public void moveSeeds(Through source){
		int seedsInSource = source.getSeed();
		for(int i = 0; i < seedsInSource; i++){
			Through targetThrough = source;
			for(int j = 0; j < i + 1 ; j++){
				targetThrough = targetThrough.getNextThrough();
			}
			
			source.setSeed(source.getSeed() - 1);
			targetThrough.setSeed(targetThrough.getSeed() + 1);
			
			if(targetThrough.getPlayer() == kalaha.getCurrentPlayer() && targetThrough.getSeed() == 1){
				bag(targetThrough);
			}
		}
	}
	
	public void bag(Through source) {
		Through playersKalaha = kalaha.getCurrentPlayer().getThroughs().hasKalaha(true).first();
		Through target = source.getOpposite();
		
		playersKalaha.setSeed(playersKalaha.getSeed() + source.getSeed() + target.getSeed());
		
		source.setSeed(0);
		target.setSeed(0);
		
		
	}

	private boolean checkEnd(){
		return false;
	}

	public Kalaha getKalaha(){
		return this.kalaha;
	}
}
