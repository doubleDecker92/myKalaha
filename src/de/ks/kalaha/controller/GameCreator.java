package de.ks.kalaha.controller;

import java.util.ArrayList;

import de.ks.kalaha.model.Kalaha;
import de.ks.kalaha.model.Player;
import de.ks.kalaha.model.Through;
import de.ks.kalaha.model.util.ThroughSet;

public class GameCreator {
	
	private static final int THROUGHS_PRO_PLAYER = 6;
	private static final int NO_OF_SEEDS_PRO_THROUGH = 3;
	private static final int NO_OF_SEEDS_PRO_KALAHA = 0;
	private Kalaha kalaha;
	
	
	public GameCreator(ArrayList<String> players) {
		kalaha = new Kalaha();
		
		createPlayers(players);
		init();
		
	}

	private void createPlayers(ArrayList<String> players) {
		
		//create Players
		for (String playerName : players) {
			new Player()
					.withName(playerName)
					.withGame(kalaha);
				
		}
		
		//set next and previous Player
		Player prevPlayer = null;
		for (Player player : kalaha.getPlayers()) {
			if(prevPlayer != null){
				player.setPreviousPlayer(prevPlayer);
			}
			prevPlayer = player;
		}
		
		kalaha.getPlayers().first().setPreviousPlayer(prevPlayer);
		
	}

	private void init() {
		//Create Throughs and Kalahas
		for (Player player : kalaha.getPlayers()) {
			//create alle throughs and give them to the players
			for (int i = 0; i < THROUGHS_PRO_PLAYER; i++) {
				new Through()
					.withKalaha(false)
					.withSeed(NO_OF_SEEDS_PRO_THROUGH)
					.withPlayer(player);
				
			}
			//create one Kalaha for each player
			new Through()
				.withKalaha(true)
				.withSeed(NO_OF_SEEDS_PRO_KALAHA)
				.withPlayer(player);
		
		}
		
		//create opposite throughs
		ThroughSet throughsPlayer1 = kalaha.getPlayers().first().getThroughs().hasKalaha(false);
		ThroughSet throughsPlayer2 = kalaha.getPlayers().last().getThroughs().hasKalaha(false);
		
		for (int i = 0; i < throughsPlayer1.size(); i++) {
			throughsPlayer1.get(i).setOpposite(throughsPlayer2.get(i));
		}
		
		//create next and previous with throughs and kalahas
		
	}
	
	public Kalaha getKalaha(){
		return this.kalaha;
	}
}
