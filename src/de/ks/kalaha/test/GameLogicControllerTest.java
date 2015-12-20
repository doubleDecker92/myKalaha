package de.ks.kalaha.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import de.ks.kalaha.controller.GameCreator;
import de.ks.kalaha.controller.GameLogicController;
import de.ks.kalaha.model.Through;

public class GameLogicControllerTest {
	@Test
	public void testMoveSeeds() throws Exception {
		String alice = "Alice";
		String bob = "Bob";
		ArrayList<String> players = new ArrayList<>();
		
		players.add(bob);
		players.add(alice);
		
		GameCreator gameCreator = new GameCreator(players);
		
		GameLogicController gameLogicController = gameCreator.getGameLogicController();
		
		//test normal turn
		Through startThrough = gameCreator.getKalaha().getPlayers().first().getThroughs().hasKalaha(false).first();
		gameLogicController.moveSeeds(startThrough);
		
		assertEquals(0, startThrough.getSeed());
		assertEquals(4, startThrough.getNextThrough().getSeed());
		assertEquals(4, startThrough.getNextThrough().getNextThrough().getSeed());
		assertEquals(4, startThrough.getNextThrough().getNextThrough().getNextThrough().getSeed());
		assertEquals(3, startThrough.getNextThrough().getNextThrough().getNextThrough().getNextThrough().getSeed());
		
		
	}
	
	
	@Test
	public void testMoveSeedsWithOwnKalaharInWay() throws Exception {
		String alice = "Alice";
		String bob = "Bob";
		ArrayList<String> players = new ArrayList<>();
		
		players.add(bob);
		players.add(alice);
		
		GameCreator gameCreator = new GameCreator(players);
		
		GameLogicController gameLogicController = gameCreator.getGameLogicController();
		
		//test move with kalahar in the row
		
		Through startThrough = gameCreator.getKalaha().getCurrentPlayer().getThroughs().hasKalaha(true).first().getPreviousThrough();
		gameLogicController.moveSeeds(startThrough);
		
		assertEquals(0, startThrough.getSeed());
		assertEquals(1, startThrough.getNextThrough().getSeed());
		assertEquals(4, startThrough.getNextThrough().getNextThrough().getSeed());
		assertEquals(4, startThrough.getNextThrough().getNextThrough().getNextThrough().getSeed());
		assertEquals(4, startThrough.getNextThrough().getNextThrough().getNextThrough().getNextThrough().getSeed());
	}
	
	@Test
	public void testBag() throws Exception {
		String alice = "Alice";
		String bob = "Bob";
		ArrayList<String> players = new ArrayList<>();
		
		players.add(bob);
		players.add(alice);
		
		GameCreator gameCreator = new GameCreator(players);
		
		GameLogicController gameLogicController = gameCreator.getGameLogicController();
		gameCreator.getKalaha().getCurrentPlayer().getThroughs().hasKalaha(false).first().setSeed(1);
		gameLogicController.bag(gameCreator.getKalaha().getCurrentPlayer().getThroughs().hasKalaha(false).first());
		assertEquals(4, gameCreator.getKalaha().getCurrentPlayer().getThroughs().hasKalaha(true).first().getSeed());
	}
}
